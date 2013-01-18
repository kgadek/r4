#include "device.ice"

module generated {
	module bulbs {	
		interface Bulb extends generated::devices::Device {
			void turnOff();
			void turnOn();
		};	
	
		interface LightBulb extends Bulb {
			void dim();
			void bright();
		};
	
		interface ColorBulb extends Bulb {
			void changeColor(string color);
		};
	};
};
