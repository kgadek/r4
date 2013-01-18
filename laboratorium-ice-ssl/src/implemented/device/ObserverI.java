package implemented.device;

import Ice.Current;
import generated.devices._ObserverDisp;

public class ObserverI extends _ObserverDisp {

  private static final long serialVersionUID = -64542054755049480L;

  @Override
	public void updateStatus(String status, Current __current) {
		System.out.println("Status " + status);
	}

}
