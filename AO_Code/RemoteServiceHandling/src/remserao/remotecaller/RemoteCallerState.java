package remserao.remotecaller;

public interface RemoteCallerState {
	
}

aspect RemoteCallerStateAspect {

	public RemoteCallerAspect.RemoteCallerClass RemoteCallerState.remoteCaller;

	public void RemoteCallerState.entry() {}
	public void RemoteCallerState.exit() {}
	public boolean RemoteCallerState.callRemoteService() {
		return false;
	}
	public void RemoteCallerState.acknowledged() {}
	public void RemoteCallerState.notAcknowledged() {}
	public void RemoteCallerState.enableGUI(){} 
}
