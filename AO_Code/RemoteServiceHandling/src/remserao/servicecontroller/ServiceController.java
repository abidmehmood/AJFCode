package remserao.servicecontroller;

import remserao.remotecaller.*;

public interface ServiceController extends RemoteCaller {

}

aspect ServiceControllerAspect {
	
	public void ServiceController.serviceRequest() {
		scState.serviceRequest();
	}
	public void ServiceController.disableGUI() {
		scState.disableGUI();
	}
	public void ServiceController.finished() {
		scState.finished();
	}
	public void ServiceController.updateGUI() {
		scState.updateGUI();
	} 

	static class ServiceControllerClass implements RemoteCaller {
		public static ServiceControllerClass getInstance() {
			return new ServiceControllerClass();
		}
	}
	
	static class ServiceControllerStateClass {
		static ServiceControllerStateClass getInstance() {
			return new ServiceControllerStateClass();
		}
	}
	static class WaitingClass {
		WaitingClass(ServiceController sc) {
			serviceController = (ServiceControllerClass) sc;
		}
		static WaitingClass getInstance(ServiceController sc) {
			return new WaitingClass(sc);
		}
		public String toString() {
			return "Waiting";
		}
	}
	
	static class WorkingClass {
		WorkingClass(ServiceController sc) {
			serviceController = (ServiceControllerClass) sc;
		}
		static WorkingClass getInstance(ServiceController sc) {
			return new WorkingClass(sc);
		}
		public String toString() {
			return "Working";
		}
	}
	
	static class CallingClass {
		CallingClass(ServiceController sc, Working ws) {
			scContext = (ServiceControllerClass) sc;
			compState = (ServiceControllerAspect.WorkingClass) ws;
		}
		static CallingClass getInstance(ServiceController sc, Working ws) {
			return new CallingClass(sc, ws);
		}
		public String toString() {
			return "Calling";
		}
	}
	
	static class CalledClass {
		CalledClass(ServiceController sc, Working ws) {
			scContext = (ServiceControllerClass) sc;
			compState = (ServiceControllerAspect.WorkingClass) ws;
		}
		static CalledClass getInstance(ServiceController sc, Working ws) {
			return new CalledClass(sc, ws);
		}
		public String toString() {
			return "Called";
		}
	}
	
	declare parents: ServiceControllerStateClass implements ServiceControllerState;
	declare parents: WaitingClass implements Waiting;
	declare parents: WorkingClass implements Working;
	declare parents: CallingClass implements Calling;
	declare parents: CalledClass implements Called;
	declare parents: WaitingClass extends ServiceControllerStateClass;
	declare parents: WorkingClass extends ServiceControllerStateClass;
	declare parents: ServiceControllerClass implements ServiceController;

	public ServiceControllerStateClass ServiceController.scState;
	public WaitingClass ServiceController.waitingState;
	public WorkingClass ServiceController.workingState;
	public CallingClass ServiceController.callingState;
	public CalledClass ServiceController.calledState;
	
	public void ServiceController.initialize() {
		System.out.println("ServiceController.initialize()");
		
		scState = ServiceControllerStateClass.getInstance();
		waitingState = WaitingClass.getInstance(this);
		workingState = WorkingClass.getInstance(this);
		callingState = CallingClass.getInstance(this, workingState);
		calledState = CalledClass.getInstance(this, workingState);
		//set the default state in this context
		scState = waitingState;
		scState.entry();
	}
	
	public void ServiceController.setState(ServiceControllerState st) {
		System.out.println("ServiceController.setState(): changing the state to " + st.toString());
		scState = (ServiceControllerStateClass) st;
		scState.entry();
	}
}
