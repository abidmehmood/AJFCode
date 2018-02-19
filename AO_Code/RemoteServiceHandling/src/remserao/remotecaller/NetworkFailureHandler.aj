package remserao.remotecaller;

public aspect NetworkFailureHandler {
	
	pointcut triableUsed(Triable t) : execution (* *(..)) && target (t);
	
	pointcut excludeInternalCalls(): !within (RemoteCallerAspect) || !within (RemoteCallerStateAspect) ||
									!within (TriableAspect) || !within(TriedAspect);
	pointcut toUse(Triable t): triableUsed(t) && excludeInternalCalls();
	
	before(Triable t): toUse(t) {
		
		System.out.println("JoinPoint detected: Going to execute advice");
		RemoteCallerAspect.RemoteCallerClass rc = RemoteCallerAspect.RemoteCallerClass.getInstance();
		t.remoteCaller = rc;
		t.remoteCaller.state = RemoteCallerAspect.RemoteCallerStateClass.getInstance();
		t.remoteCaller.triableState = RemoteCallerAspect.TriableClass.getInstance(rc);
		t.remoteCaller.triedState = RemoteCallerAspect.TriedClass.getInstance(rc);
			
		System.out.println("Finished executing advice");
	}
	
}
