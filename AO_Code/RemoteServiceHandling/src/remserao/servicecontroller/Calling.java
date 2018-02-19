package remserao.servicecontroller;

import remserao.remotecaller.*;

public interface Calling extends WorkingState, Triable {
}

aspect CallingAspect {
	public String Calling.toString() {
		return "Calling";
	}
}

