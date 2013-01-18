#include "device.ice"

module generated {
	module telescopes {
		interface Telescope extends generated::devices::Device {
			void turn(double angle);
			void zoom(short zoomLevel);
		};
	
		interface RGBTelescope extends Telescope {
			string getColor();
		};
	
		interface InfraRedTelescope extends Telescope {
			string getTemp();
			void focusOnHighestTemp();
		};
	};
};
