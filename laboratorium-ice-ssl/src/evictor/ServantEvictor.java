package evictor;

import generated.devices.Device;
import generated.exceptions.NoSuchDeviceException;
import generated.laboratory.LabDevice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Ice.Current;
import Ice.Identity;
import Ice.LocalObjectHolder;
import Ice.ServantLocator;
import Ice.UserException;

public class ServantEvictor implements ServantLocator {

	private List<LabDevice> availableDevices;
	private Map<String, Class<?>> deviceClass;
	private Map<Ice.Identity, Device> devices = new ConcurrentHashMap<Ice.Identity, Device>();
	private int maxSize;
	
	public ServantEvictor(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void inject(List<LabDevice> availableDevices, Map<String, Class<?>> deviceClass) {
		this.availableDevices = availableDevices;
		this.deviceClass = deviceClass;
	}

	@Override
	public synchronized Ice.Object locate(Current curr, LocalObjectHolder cookie) throws UserException {
		Class<?> c = deviceClass.get(curr.id.name);

		if (availableDevices.isEmpty() || c == null) {
			throw new NoSuchDeviceException();
		}

		Device dev = devices.get(curr.id);
		
		if (dev == null) {
			if (devices.size() >= maxSize)
			{
				System.out.println("Na serwerze jest za duzo serwantow, proba ewikcji");
				evict();
			}
			try {
				dev = add(curr, cookie);
			} catch (Exception e) {
				System.out.println("Blad przy tworzeniu servanta");
			}
		}

		return dev;	
	}

	@Override
	public synchronized void finished(Current curr, Ice.Object servant, java.lang.Object cookie) throws UserException {
		if (devices.size() >= maxSize && curr.operation.equals("releaseControl") && curr.operation.equals("stopObsevation"))
		{
			System.out.println("Na serwerze jest za duzo serwantow, proba ewikcji");
			evict();
		}
	}

	@Override
	public synchronized void deactivate(String category) {
		
	}

	public void evict() {
		List<Ice.Identity> toRemove = new LinkedList<Ice.Identity>();
		for (Ice.Identity id : devices.keySet()) {
			Device dev = devices.get(id);
			if (dev.canBeEvicted()) {
				toRemove.add(id);
			}
		}
		
		for (Ice.Identity id : toRemove) {
			devices.remove(id);
			System.out.println("Usunieto servanta dla "+id.category + "/" + id.name);
		}
	}
	
	public Device add(Ice.Current curr, Ice.LocalObjectHolder cookie) throws InstantiationException,
			IllegalAccessException {

		Class<?> c = deviceClass.get(curr.id.name);

		Device dev = (Device) c.newInstance();

		System.out.println("Stworzono servanta dla " + curr.id.category + "/" + curr.id.name);

		devices.put(curr.id, dev);

		return dev;
	}

	public synchronized boolean isUsed(Identity identity) {
		Device dev = devices.get(identity);
		if (dev != null)
			return dev.isUsed();
		return false;
	}

}
