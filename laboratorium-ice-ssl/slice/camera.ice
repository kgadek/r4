#include "device.ice"

module generated {
	module cameras {
		interface Camera extends generated::devices::Device {
			void turn(double angle);
			void zoom(short zoomLevel);
		};
	
		interface ColorCamera extends Camera {
			string getColor();
		};
	
		interface TermoCamera extends Camera {
			string getTemp();
			void focusOnHighestTemp();
		};
	};
};
