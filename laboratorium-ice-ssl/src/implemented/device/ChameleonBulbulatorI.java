package implemented.device;

import generated.bulbators._ChameleonBulbulatorDisp;
import generated.devices.ObserverPrx;
import generated.devices.ObserverPrxHelper;
import generated.exceptions.DeviceAlreadyInUseException;
import generated.exceptions.IncorrectUserNameException;
import generated.exceptions.UserAlreadyObserveException;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;

public class ChameleonBulbulatorI extends _ChameleonBulbulatorDisp {

	private static final long serialVersionUID = 1L;
	private boolean used = false;
	private String userName = null;
	private List<ObserverPrx> observers = new ArrayList<ObserverPrx>();
	private String[] interfaceInfo = {"String changeColor()", "String turnOff()", "void turnOn()", "String getStatus()"}; 
	
	private boolean on = false;
	private String color = "white";
	
	@Override
	public synchronized void changeColour(String color, Current __current) {
		this.color = color;
		actionPerformed();
	}
	
	@Override
	public synchronized void turnBulbulOff(Current __current) {
		on = false;
		actionPerformed();
	}

	@Override
	public synchronized void turnBulbulOn(Current __current) {
		on = true;
		actionPerformed();
	}
	
	@Override
	public synchronized void getControl(String userName, Current __current) throws DeviceAlreadyInUseException {
		if (used)
			throw new DeviceAlreadyInUseException("urzadzenie zajete");
		used = true;
		this.userName = userName;
	}

	@Override
	public synchronized void releaseControl(String userName, Current __current) throws IncorrectUserNameException {
		if (!this.userName.equals(userName))
			throw new IncorrectUserNameException(userName + "nie jest wlascicielem --- nie mozna zwolnic zasobow");
		used = false;
		userName = null;
	}
	
	@Override
	public synchronized void startObservation(ObserverPrx obs, Current __current) throws UserAlreadyObserveException {
		Ice.ObjectPrx obj = __current.con.createProxy(obs.ice_getIdentity());
		ObserverPrx client = ObserverPrxHelper.uncheckedCast(obj);
		observers.add(client);
	}

	@Override
	public synchronized void stopObservation(ObserverPrx obs, Current __current) throws IncorrectUserNameException {
		observers.remove(obs);
	}

	@Override
	public synchronized String getStatus(Current __current) {
		return "swieci: " + (on?"tak":"nie") + " kolor: " + color;
	}

	@Override
	public synchronized boolean isUsed(Current __current) {
		return used;
	}

	@Override
	public synchronized String[] getInterfaceInfo(Current __current) {
		return interfaceInfo;
	}

	@Override
	public synchronized void actionPerformed(Current __current) {
		for (ObserverPrx o : observers) {
			o.updateStatus(getStatus());
		}
	}

	@Override
	public boolean canBeEvicted(Current __current) {
		return !isUsed() && observers.isEmpty();
	}

}
