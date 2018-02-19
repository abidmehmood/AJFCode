package remserao.remotecaller;

public interface Triable extends RemoteCallerState {
	
}

aspect TriableAspect {
	
	public void Triable.entry() {
		System.out.println("Triable.entry()");
			
		int retries = remoteCaller.retries;
		boolean result = false;
		while (retries < remoteCaller.MAX) {
			System.out.println("trying to call remote service, retry no. " + retries);

			result = remoteCaller.callRemoteService();

			if (result) {
				acknowledged();
				break;
			} else {
				retries++;
			}
		}
		if (retries == remoteCaller.MAX) {
			notAcknowledged();
		}
	}
	
	public void Triable.exit() {
		System.out.println("Triable.exit()");
	}
	
	public void Triable.acknowledged() {
		System.out.println("Triable.ack()");
		remoteCaller.setState(remoteCaller.triedState);
	}
	
	public void Triable.notAcknowledged() {
		System.out.println("Triable.notAck()");
		remoteCaller.setState(remoteCaller.triedState);
	}
	
	
	public boolean Triable.callRemoteService() {
		System.out.println("Triable.callRemoteService()");
		return false;
	}
	
	public String Triable.toString() {
		return "Triable";
	}
}