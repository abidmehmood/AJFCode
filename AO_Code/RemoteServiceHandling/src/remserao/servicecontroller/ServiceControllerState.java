package remserao.servicecontroller;

public interface ServiceControllerState {
	
}

aspect ServiceControllerStateAspect {
	public ServiceControllerAspect.ServiceControllerClass ServiceControllerState.serviceController;
	public void ServiceControllerState.entry() {
		System.out.println("ServiceControllerState.entry()...");
	}
	public void ServiceControllerState.exit() {}
	public void ServiceControllerState.serviceRequest() {}
	public void ServiceControllerState.disableGUI() {}
	public void ServiceControllerState.updateGUI() {}
	public void ServiceControllerState.finished() {}

}

