package implemented.laboratory;

import evictor.ServantEvictor;
import generated.laboratory.LabDevice;
import generated.laboratory._LaboratoryFactoryDisp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Ice.Current;
import Ice.ObjectAdapter;

public class LaboratoryFactoryI extends _LaboratoryFactoryDisp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String CONFIG = "lab.conf";
	private final String IMPL_PKG = "implemented.device.";

	List<LabDevice> availableDevices = new ArrayList<LabDevice>();
	Map<String, Class<?>> deviceClass = new ConcurrentHashMap<String, Class<?>>();

	List<String> users = new ArrayList<String>();

	Ice.Application app;
	ObjectAdapter adapter;
	private ServantEvictor evictor; 
	
	public LaboratoryFactoryI(Ice.Application app, ObjectAdapter adapter, ServantEvictor evictor) throws IOException {
		this.app = app;
		this.adapter = adapter;
		this.evictor = evictor;
		readConfiguration();
	}

	private void readConfiguration() throws IOException {
		File file = new File(CONFIG);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {
			String[] items = line.split(" ");
			try {
				for (int i = 1; i < items.length; i++) {
					System.out.println(items[0]);
					Class<?> c = Class.forName(IMPL_PKG + items[0] + "I");
					LabDevice dev = new LabDevice(items[i], items[0], false);
					availableDevices.add(dev);
					deviceClass.put(items[i], c);
					System.out.println("Stworzono " + items[i] + " o typie " + items[0]);
				}
				evictor.inject(availableDevices, deviceClass);
			} catch (ClassNotFoundException e) {
				System.out.println("Blad konfiguracji. Nie istnieje urzadzenie o podanym typie.");
			}
		}
		br.close();
	}

	@Override
	public LabDevice[] getLabStatus(Current __current) {
		LabDevice[] info = new LabDevice[availableDevices.size()];

		int i = 0;
		for (LabDevice ld : availableDevices) {
			ld.used = evictor.isUsed(new Ice.Identity(ld.deviceName, ld.type));
			
			info[i] = ld;
			i++;
		}
		return info;
	}
}
