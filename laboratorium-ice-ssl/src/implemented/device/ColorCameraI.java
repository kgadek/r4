package implemented.device;

import generated.cameras._ColorCameraDisp;
import generated.devices.ObserverPrx;
import generated.exceptions.DeviceAlreadyInUseException;
import generated.exceptions.IncorrectUserNameException;
import generated.exceptions.UserAlreadyObserveException;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;

public class ColorCameraI extends _ColorCameraDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean used = false;
	private String userName = null;
	private List<ObserverPrx> observers = new ArrayList<ObserverPrx>();
	private String[] interfaceInfo = { "String getColor()", "void turn(double angle)", "void zoom(short zoomLevel)",
			"String getStatus()" };

	private double angle = 0;
	private short zoomLevel = 0;

	@Override
	public synchronized String getColor(Current __current) {
		if (angle < 90) {
			return "red";
		}
		if (angle < 180) {
			return "green";
		}
		if (angle < 270) {
			return "blue";
		}

		return "yellow";
	}

	@Override
	public synchronized void turn(double angle, Current __current) {
		this.angle += angle;
		this.angle %= 360;
		actionPerformed();
	}

	@Override
	public synchronized void zoom(short zoomLevel, Current __current) {
		if (zoomLevel > 10) {
			zoomLevel = 10;
		}

		if (zoomLevel < 0) {
			zoomLevel = 0;
		}
		this.zoomLevel = zoomLevel;
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
		return "kat: " + angle + " zoom: " + zoomLevel;
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
