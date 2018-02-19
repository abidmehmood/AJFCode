package remseroo;

public abstract class WorkingState {

	public RemoteCaller rc; // we need context here also
	public Working compState;

	public void entry() {
		log("in WorkingState.entry()");
	}

	public void exit() {

	}

	public boolean callRemoteService() {
		return false;
	}

	public void acknowledged() {

	}

	public void notAcknowledged() {

	}

	public void enableGUI() {

	}

	public void updateGUI() {

	}

	public static void log(String st) {
		RemoteCaller.logger.log(st);
	}
}
