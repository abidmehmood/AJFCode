package remserao.tracing;

/**
 *
 * This class connects the tracing functions in the Trace class with
 * the constructors and methods in the application classes.
 *
 */
import remserao.*;

aspect TraceMyClasses {
    /**
     * Application classes.
     */
    pointcut myClass(): within (RemoteCallerAspect) || within (RemoteCallerStateAspect) ||
    					within (TriableAspect) || within (TriedAspect) || 
    					within (ServiceControllerAspect) || within (ServiceControllerStateAspect) ||
    					within (WaitingAspect) || within (WorkingAspect) ||
    					within (WorkingStateAspect) || within (CallingAspect) || 
    					within (CalledAspect);  
    /**
     * The constructors in those classes.
     */
    pointcut myConstructor(): myClass() && execution(new(..));
    /**
     * The methods of those classes.
     */
    pointcut myMethod(): myClass() && execution(* *(..));

    /**
     * Prints trace messages before and after executing constructors.
     */
    before (): myConstructor() {
    	Trace.traceEntry("Before constructor " + thisJoinPointStaticPart.getSignature());
    }
    after(): myConstructor() {
        Trace.traceExit("After constructor " + thisJoinPointStaticPart.getSignature());
    }

    /**
     * Prints trace messages before and after executing methods.
     */
    before (): myMethod() {
        Trace.traceEntry("Before method " + thisJoinPointStaticPart.getSignature());
    }
    after(): myMethod() {
        Trace.traceExit("After method " + thisJoinPointStaticPart.getSignature());
    }

    /**
     * A main function for testing the trace aspect.
     */
    public static void main(String[] args) {
        Trace.TRACELEVEL = 2;
        Trace.initStream(System.err);
    }
}

