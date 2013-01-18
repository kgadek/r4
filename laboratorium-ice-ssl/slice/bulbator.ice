#include "device.ice"

module generated {
	module bulbators {	
		interface Bulbator extends generated::devices::Device {
			void turnBulbulOff();
			void turnBulbulOn();
		};	
	
		interface BoomerangBulbulator extends Bulbator {
			void throwAway();
			void getBack();
		};
	
		interface ChameleonBulbulator extends Bulbator {
			void changeColour(string color);
		};
	};
};
