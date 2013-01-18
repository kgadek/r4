package client;

import generated.devices.DevicePrx;
import generated.devices.DevicePrxHelper;
import generated.devices.ObserverPrx;
import generated.devices.ObserverPrxHelper;
import generated.exceptions.DeviceAlreadyInUseException;
import generated.exceptions.IncorrectUserNameException;
import generated.exceptions.UserAlreadyObserveException;
import generated.laboratory.LabDevice;
import generated.laboratory.LaboratoryFactoryPrx;
import generated.laboratory.LaboratoryFactoryPrxHelper;
import implemented.device.ObserverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Ice.Application;
import Ice.ObjectPrx;

public class Client extends Application {

	LaboratoryFactoryPrx lab;
	String location;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String userName;
	private ObserverPrx obs;

	public Client() {
	  userName = "joedoe";
		try {
      userName = Client.br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
  }}

	@Override
	public int run(String[] args) {
	  
		setInterruptHook(new Thread() {
			public void run() {
				try {
					communicator().destroy();
				} catch (Ice.LocalException ex) {
					ex.printStackTrace();
		}}});
		
		lab = LaboratoryFactoryPrxHelper.checkedCast(communicator().propertyToProxy("LaboratoryFactory.Proxy"));
		location = communicator().getProperties().getProperty("LaboratoryFactory.Proxy");
		location = location.substring(location.indexOf(":"));
			
		while (true) {
			try {
				chooseDevice();
			} catch (IOException e) {
				e.printStackTrace();
	}}};
	
	LabDevice[] showLabState() {
		LabDevice[] status = lab.getLabStatus();
		System.out.println("zawartość laboratorium: ");
		int i = 0;
		for (LabDevice ld : status) {
			System.out.println("[" + i + "] typ:" + ld.type + " nazwa:" + ld.deviceName + " uzywany:"	+ (ld.used ? "TAK" : "NIE"));
			i++;
		}
		System.out.println("Wybierz urzadzenie: [0-" + (i - 1) + "]. Wpisz /q aby zakonczyc.");
		return status;
	}

	void chooseDevice() throws IOException {
		LabDevice[] status = showLabState();
		String line;
		line = br.readLine();
				
		if (line.equals("/q"))
			System.exit(0);

		int devNo = Integer.parseInt(line);
		DevicePrx chosen = DevicePrxHelper.checkedCast(communicator().stringToProxy(status[devNo].type+"/"+status[devNo].deviceName+location));
		
		System.out.println("Wybierz operacje: ");
		System.out.println("  0) kontroluj ");
		System.out.println("  1) obserwuj ");
		
		line = br.readLine();
		
		int tmp = Integer.parseInt(line);
		
		if (tmp == 0) {
			try {
				chosen.getControl(userName);
				System.out.println("Obslugujesz urzadzenie, aby zakonczyc, wpisz /q");
				controlDevice(chosen);
			} catch (DeviceAlreadyInUseException | IncorrectUserNameException e) {
				System.out.println(e.getMessage());
				return;
			}
		} else if (tmp == 1) {
			try {
				chosen.startObservation(getObserver());
				System.out.println("Obserwujesz urzadzenie, aby zakonczyc, wpisz /q");
				if ((line = br.readLine()) != null && line.equals("/q"))
					chosen.stopObservation(getObserver());
			} catch (UserAlreadyObserveException e) {
				System.out.println("To urzadzenie juz jest obserwowane");
				return;
			} catch (Exception e) {
				System.out.println("Problem przy tworzeniu obserwatora");
				return;
			}
		}
	}

	private void showInfo(String interf[]) {
		for (String method : interf)
			System.out.println(method);
		System.out.println("Aby wyswietlic ponownie, wpisz /info. Wywolanie metod: nazwaMetody [argumenty]");
	}
	
	private void controlDevice(DevicePrx chosenDevice) throws IncorrectUserNameException, IOException {
		String interf[] = chosenDevice.getInterfaceInfo();
		DeviceMethods methods = new DeviceMethods(interf);
		
		showInfo(interf);
		
		String line;
		while ((line = br.readLine()) != null) {
			if (line.equals("/q")) {
				chosenDevice.releaseControl(userName);
				break;
			} else if (line.equals("/info")) {
				showInfo(interf);
			} else {
				String[] command = line.split(" ");
				
				try {
					byte[] params = methods.createRequest(command, communicator());
					Object o = methods.invokeRequest(params, chosenDevice, command[0], communicator());
					if (o != null) {
						System.out.println(o);
					}
				} catch (NoSuchMethodException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Nastapil problem przy wywolaniu metody " + e.getMessage());
				}
			}
		}
	}
	
	private ObserverPrx getObserver() {
		if (obs == null) {
			Ice.ObjectAdapter adapter = communicator().createObjectAdapter("Observer");
			ObjectPrx obj = adapter.add(new ObserverI(), communicator().stringToIdentity("Observer"));
			obs = ObserverPrxHelper.uncheckedCast(obj);
	        adapter.activate();
	        lab.ice_getConnection().setAdapter(adapter);
		}
		return obs;

	}

	public static void main(String[] args) throws IOException {
		System.out.println("Wpisz nazwe uzytkownika:");

		Client app = new Client();
		int status = app.main("Client", args, "config.client");
		System.exit(status);
	}
}
