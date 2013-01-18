package implemented.device;

import generated.bulbators._BoomerangBulbulatorDisp;
import generated.devices.ObserverPrx;
import generated.exceptions.DeviceAlreadyInUseException;
import generated.exceptions.IncorrectUserNameException;
import generated.exceptions.UserAlreadyObserveException;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;

public class BoomerangBulbulatorI extends _BoomerangBulbulatorDisp {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean used = false;
	private String userName = null;
	private List<ObserverPrx> observers = new ArrayList<ObserverPrx>();
	private String[] interfaceInfo = {"void dim()", "void bright()", "String turnOff()", "void turnOn()", "String getStatus()"}; 
	
	private boolean on = false;
	private short brightness = 5;
	
	@Override
	public synchronized void throwAway(Current __current) {
		if (this.brightness > 0) {
			this.brightness--;
			actionPerformed();
		}
	}

	@Override
	public synchronized void getBack(Current ___current) {
		if (this.brightness < 10) {
			this.brightness++;
			actionPerformed();
		}
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
		observers.add(obs);
	}

	@Override
	public synchronized void stopObservation(ObserverPrx obs, Current __current) throws IncorrectUserNameException {
		observers.remove(obs);
	}

	@Override
	public synchronized String getStatus(Current __current) {
		return "wlaczona: " + ((on)?"tak":"nie") + " jasnosc: " + brightness;
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
