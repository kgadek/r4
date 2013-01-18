package implemented.device;

import generated.devices.ObserverPrx;
import generated.exceptions.DeviceAlreadyInUseException;
import generated.exceptions.IncorrectUserNameException;
import generated.exceptions.UserAlreadyObserveException;
import generated.telescopes._RGBTelescopeDisp;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;

public class RGBTelescopeI extends _RGBTelescopeDisp {

  private static final long serialVersionUID = 1784594038831852133L;
  private boolean used = false;
	private String userName = null;
	private List<ObserverPrx> observers = new ArrayList<ObserverPrx>();
	private String[] interfaceInfo =  {
                                	    "String getColor()",
                                	    "void turn(double angle)",
                                	    "void zoom(short zoomLevel)",
                                			"String getStatus()"
                                    };
	private double angle = 0;
	private short zoomLevel = 0;

	@Override
	public synchronized String getColor(Current __current) {
	  switch(((int)angle%5) / 90) {
  	  case 0:  return "red";
  	  case 1:  return "green";
  	  case 2:  return "magenta";
  	  case 3:  return "not yellow";
  	  default: return "dunno";
	  }
	}

	@Override
	public synchronized void turn(double angle, Current __current) {
		this.angle += angle;
		this.angle %= 360;
		actionPerformed();
	}

	@Override
	public synchronized void zoom(short zoomLevel, Current __current) {
	  this.zoomLevel = (short) Math.max(Math.min(zoomLevel, 10), 0);
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
		return "(kat, zoom) = (" + angle + ", " + zoomLevel + ")";
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
		for (ObserverPrx o : observers)
			o.updateStatus(getStatus());
	}


	@Override
	public boolean canBeEvicted(Current __current) {
		return !isUsed() && observers.isEmpty();
	}
}
