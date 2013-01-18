package client;

import generated.devices.DevicePrx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ice.ByteSeqHolder;
import Ice.Communicator;

public class DeviceMethods {
	class MethodData {
		String returnType;
		List<String> arguments;
		String methodName;
	}
	
	Map<String, MethodData> methods = new HashMap<String, MethodData>();
	
	public DeviceMethods(String interfaceData[]) {
		for (String m : interfaceData) {
			String line[] = m.split(" ");
			MethodData md = new MethodData();
			md.returnType = line[0];
			String line2[] = line[1].split("\\(");
			md.methodName = line2[0];
//			System.out.println(md.methodName + " " + md.returnType);
			md.arguments = new ArrayList<String>();
			if (line2[1].length() > 1) {
				md.arguments.add(line2[1]);
//				System.out.println(line2[1]);
				for (int i = 3; i < line.length; i += 2) {
					md.arguments.add(line[i]);
//					System.out.println(line[i]);
				}
			}
			methods.put(md.methodName, md);
		}
	}
	
	public byte[] createRequest (String[] command, Communicator communicator) throws NoSuchMethodException {
		MethodData md = methods.get(command[0]);
		if (md == null) {
			throw new NoSuchMethodException("Urz¹dzenie, które obs³ugujesz, nie posiada metody " + command[0]);
		}
		
		Ice.OutputStream params = Ice.Util.createOutputStream(communicator);
		
		int i = 1;
		for (String type : md.arguments) {
			if (type.equals("String")) {
				params.writeString(command[i]);
			} else if (type.equals("short")) {
				short s = Short.parseShort(command[i]);
				params.writeShort(s);
			} else if (type.equals("int")) {
				int in = Integer.parseInt(command[i]);
				params.writeInt(in);
			} else if (type.equals("double")) {
				double d = Double.parseDouble(command[i]);
				params.writeDouble(d);
			} else if (type.equals("float")) {
				float f = Float.parseFloat(command[i]);
				params.writeFloat(f);
			} else if (type.equals("boolean")) {
				boolean b = Boolean.parseBoolean(command[i]);
				params.writeBool(b);
			}
			i++;
		}
		
		return params.finished();
	}
	
	public Object invokeRequest(byte[] params, DevicePrx chosenDevice, String methodName, Communicator communicator) throws Exception {
		MethodData md = methods.get(methodName);
		
		ByteSeqHolder result = new ByteSeqHolder();
		
		Boolean requestResult = chosenDevice.ice_invoke(methodName, Ice.OperationMode.Normal, params, result);
		
		Ice.InputStream res = Ice.Util.createInputStream(communicator, result.value);
		
		if (requestResult) {
			if (md.returnType.equals("String")) {
				return res.readString();
			} else if (md.returnType.equals("void")) {
				return null;
			} else if (md.returnType.equals("short")) {
				return res.readShort();
			} else if (md.returnType.equals("int")) {
				return res.readInt();
			} else if (md.returnType.equals("double")) {
				return res.readDouble();
			} else if (md.returnType.equals("float")) {
				return res.readFloat();
			} else if (md.returnType.equals("boolean")) {
				return res.readBool();
			}
		}
		return null;
	}
}
