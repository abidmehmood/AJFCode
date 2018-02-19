package remseroo;

public class Working extends RemoteCallerState { // handling of the composite
													// state

	public WorkingState subState; // Collaborator

	public Working(RemoteCaller rc) {
		remoteCaller = rc;
	}

	public void entry() {
		log("Working.entry().....");
		subState = remoteCaller.callingState; // default state inside Working
												// state

		setSubState(subState);
	}

	public boolean callRemoteService() {
		return subState.callRemoteService();
	}

	public void acknowledged() {
		subState.acknowledged();
	}

	public void notAcknowledged() {
		subState.notAcknowledged();
	}

	public void enableGUI() {
		subState.enableGUI();
	}

	public void updateGUI() {
		subState.updateGUI();

	}

	public void setSubState(WorkingState ws) { // switching the nested states in
												// composite state
		log("Working.setSubState().. going to change substate to "
				+ ws.toString());
		subState = ws;
		subState.entry();
	}

	public void finished() { // transition to go out from Working state
		// we have to switch to Waiting state here
		log("WorkingState.finished()");
		remoteCaller.setState(remoteCaller.waitState);
	}

	public static void log(String st) {
		RemoteCaller.logger.log(st);
	}

	public String toString() {
		return "WorkingState";
	}
}
