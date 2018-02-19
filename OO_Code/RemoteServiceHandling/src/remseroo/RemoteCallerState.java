package remseroo;

// abstract class to represent state of context class
public abstract class RemoteCallerState {

	public static RemoteCaller remoteCaller; // reference to context class

	public void entry() {

	}

	public void exit() {

	}

	public void serviceRequest() {

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

	public void disableGUI() {

	}

	public void updateGUI() {

	}

	public void finished() {

	}

	public static void main(String args[]) {

		remoteCaller = new RemoteCaller();
		remoteCaller.serviceRequest();

		remoteCaller.finished();
	}

}
