package remserao.remotecaller;

public interface RemoteCaller {}

aspect RemoteCallerAspect {
	// declaration of fields and methods into interface
	public int RemoteCaller.retries = 0;
	public int RemoteCaller.MAX = 5; 
	
	public boolean RemoteCaller.callRemoteService() {
		return state.callRemoteService();
	}
	
	public void RemoteCaller.acknowledged() {
		state.acknowledged();
	}
	public void RemoteCaller.notAcknowledged() {
		state.notAcknowledged();
	}
	public void RemoteCaller.enableGUI() {
		state.enableGUI();
	}
	
	static class RemoteCallerClass {
		public static RemoteCallerClass getInstance() {
			return new RemoteCallerClass();
		}
	}

	static class RemoteCallerStateClass {
		static RemoteCallerStateClass getInstance() {
			return new RemoteCallerStateClass();
		}
	}
	static class TriableClass {
		TriableClass(RemoteCaller rc) {
			remoteCaller = (RemoteCallerClass) rc;
		}
		static TriableClass getInstance(RemoteCaller rc) {
			
			return new TriableClass(rc);
		}
	}
	static class TriedClass {
		TriedClass(RemoteCaller rc) {
			remoteCaller = (RemoteCallerClass) rc;
		}
		static TriedClass getInstance(RemoteCaller rc) {
			return new TriedClass(rc);
		}
	}

	declare parents: RemoteCallerClass implements RemoteCaller;
	declare parents: RemoteCallerStateClass implements RemoteCallerState;
	declare parents: TriableClass implements Triable;
	declare parents: TriedClass implements Tried;
	declare parents: TriableClass extends RemoteCallerStateClass;
	declare parents: TriedClass extends RemoteCallerStateClass;
		
	public RemoteCallerStateClass RemoteCaller.state; //reference to class that handles states
	
	public TriableClass RemoteCaller.triableState; // references to classes each representing a state
	public TriedClass RemoteCaller.triedState; 

	public void RemoteCaller.initialize() {
		System.out.println("RemoteCaller.initialize()...");
		state = RemoteCallerStateClass.getInstance();
		triableState = TriableClass.getInstance(this);
		triedState = TriedClass.getInstance(this);

		state.entry();
	} 
	
	public void RemoteCaller.setState(RemoteCallerState st) {
		System.out.println("RemoteCaller.setState(): going to change the state to "
				+ st.toString());
		state = (RemoteCallerStateClass) st;
		state.entry();
	}
		
}