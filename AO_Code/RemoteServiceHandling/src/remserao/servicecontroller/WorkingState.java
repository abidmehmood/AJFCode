package remserao.servicecontroller;

public interface WorkingState {
	
}

aspect WorkingStateAspect {
	public ServiceControllerAspect.ServiceControllerClass WorkingState.scContext;
	public ServiceControllerAspect.WorkingClass WorkingState.compState;
	public void WorkingState.entry() {
		System.out.println("WorkingState.entry()");
	}
	public void WorkingState.exit() {
		
	}
}
