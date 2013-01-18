#include "device.ice"

module generated {
	module laboratory {
		struct LabDevice {
			string deviceName;
			string type;
			bool used;
		};
		
		sequence<LabDevice> laboratoryDevices;
		
		interface LaboratoryFactory {	
			laboratoryDevices getLabStatus();
//			generated :: devices :: Device* getDevice(string deviceName) throws generated :: exceptions :: NoSuchDeviceException;
		};
	};
};	
