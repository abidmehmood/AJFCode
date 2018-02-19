package remseroo;

public class Waiting extends RemoteCallerState {
	public Waiting(RemoteCaller rc) {
		remoteCaller = rc;
	}

	public void entry() {

		log("Waiting.entry()... ");
	}

	public void serviceRequest() {
		log("Waiting.serviceRequest()");
		remoteCaller.retries = 0;
		disableGUI();

		remoteCaller.setState(remoteCaller.workingState); // changing the state
	}

	public void disableGUI() {
		// disable the GUI here
	}

	public void finished() {
		log("Waiting.finished()... going to set Waiting state");

		remoteCaller.setState(remoteCaller.waitState);

	}

	public static void log(String st) {
		RemoteCaller.logger.log(st);
	}

	public String toString() {
		return "WaitingState";
	}
}
