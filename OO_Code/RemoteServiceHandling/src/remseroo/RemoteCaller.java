package remseroo;

//context class to represent the remote call handling as a whole
public class RemoteCaller {

	public RemoteCallerState state; // the collaborator
	public Waiting waitState;
	public Working workingState;
	public Calling callingState;
	public Called calledState;

	public int retries = 0;
	public int MAX = 5;

	public static Logger logger = new Logger();

	RemoteCaller() { // constructor
		waitState = new Waiting(this);
		workingState = new Working(this);
		callingState = new Calling(this, workingState);
		calledState = new Called(this, workingState);

		state = waitState; // default state
		log("RemoteCaller() initialized");
		log("state is " + state.toString());
	}

	// method to change the state
	public void setState(RemoteCallerState st) {
		log("RemoteCaller.setState(): going to change the state to "
				+ st.toString());
		state = st;
		log("RemoteCaller.setState(): state changed to " + state.toString());
		state.entry();
	}

	public void serviceRequest() {
		state.serviceRequest();
	}

	public boolean callRemoteService() {
		log("in RemoteCaller.callRemoteService()... ");
		return state.callRemoteService();
	}

	public void acknowledged() {
		state.acknowledged();
	}

	public void notAcknowledged() {
		state.notAcknowledged();
	}

	public void enableGUI() {
		state.enableGUI();
	}

	public void disableGUI() {
		state.disableGUI();
	}

	public void updateGUI() {
		state.updateGUI();
	}

	public void finished() {
		state.finished();
	}

	public static void log(String st) {
		RemoteCaller.logger.log(st);
	}

}
