package remserao.servicecontroller;


import remserao.remotecaller.*;
import remserao.tracing.Trace;

public class Main {

	public static void main(String args[]) {
		Trace.initStream(System.out);
		ServiceControllerAspect.ServiceControllerClass controller = ServiceControllerAspect.ServiceControllerClass.getInstance();
				
		controller.initialize();  
		controller.serviceRequest();
		
	}
}
class RemoteCallerUser implements RemoteCaller {

}

