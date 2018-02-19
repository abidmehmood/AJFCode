package remseroo;

public class Calling extends WorkingState {

	private static final long MAX = 5;
	private static long retries = 1;

	public Calling(RemoteCaller context, Working w) {
		rc = context;
		compState = w;
	}

	public void entry() {
		log("Calling.entry()...");
		boolean result = false;
		while (retries <= MAX) {
			log("trying to call remote service, retry no. " + retries);
			result = callRemoteService();

			if (result) {
				acknowledged();
				break;
			} else {
				retries++;
			}
		}
		if (retries > MAX) {
			notAcknowledged();
		}
	}

	public boolean callRemoteService() {
		// this method overloads the method in super classes and provides actual
		// impl.
		return false;
	}

	public void exit() {

	}

	public void updateGUI() {
		// overload the method in context and state clases and provide impl here
		// update the GUI here.
	}

	public void acknowledged() {
		log("Calling.acknowledged()...");
		rc.updateGUI();
		compState.setSubState(rc.calledState);
	}

	public void notAcknowledged() {
		log("Calling.notAcknowledged... giving up without updating GUI..");
		compState.setSubState(rc.calledState);
	}

	public String toString() {
		return "CallingState";
	}

	public static void log(String st) {
		RemoteCaller.logger.log(st);
	}
}
