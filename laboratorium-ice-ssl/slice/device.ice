#include "exceptions.ice"

module generated {
  module devices {
  
    interface Observer {
      void updateStatus(string status);
    };
  
    sequence<string> deviceInterface;
    
    interface Device {
      
      void getControl(string userName)     throws generated :: exceptions :: DeviceAlreadyInUseException;
      void releaseControl(string userName) throws generated :: exceptions :: IncorrectUserNameException;
      void startObservation(Observer* obs) throws generated :: exceptions :: UserAlreadyObserveException;
      void stopObservation(Observer* obs)  throws generated :: exceptions :: IncorrectUserNameException;
      void actionPerformed();
      string getStatus();
      bool isUsed();
      bool canBeEvicted();
      deviceInterface getInterfaceInfo();
    };  
  };
};
