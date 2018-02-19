package remserao.servicecontroller;

public interface Waiting extends ServiceControllerState {
	
}

aspect WaitingAspect {
	public void Waiting.entry() {
		System.out.println("Waiting.entry()...");
	}
	
	public void Waiting.serviceRequest() {
		System.out.println("Waiting.serviceRequest()...");
		serviceController.disableGUI();
		serviceController.setState(serviceController.workingState);
	}
	
	public void Waiting.finished() {
		serviceController.setState(serviceController.waitingState);
	}
}
