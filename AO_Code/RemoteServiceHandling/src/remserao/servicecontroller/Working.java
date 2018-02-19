package remserao.servicecontroller;

public interface Working extends ServiceControllerState { } // handling of composite state

aspect WorkingAspect {
	static class WorkingStateClass implements WorkingState {
		static WorkingStateClass getInstance() {
			return new WorkingStateClass();
		}
	}
	declare parents: ServiceControllerAspect.CallingClass extends WorkingStateClass;
	
	public WorkingStateClass Working.subState; //Collaborator for substate
	public void Working.entry() {
		System.out.println("Working.entry()...");
		subState = serviceController.callingState;
		System.out.println("About to call setSubState");
		setSubState(subState);
	}
	
	public void Working.setSubState(WorkingState ws) {
		System.out.println("Working.setSubState()...Going to change state to "+ws.toString());
		subState = (WorkingStateClass) ws;
		subState.entry();
	}
}

