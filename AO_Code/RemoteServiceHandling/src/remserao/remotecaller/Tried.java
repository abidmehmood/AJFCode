package remserao.remotecaller;

public interface Tried extends RemoteCallerState {
	
}

aspect TriedAspect {
	public void Tried.entry() {
		System.out.println("Tried.entry()");
	}
	public void Tried.exit() {
		System.out.println("Tried.exit()");
	}
	public void Tried.enableGUI() {
		System.out.println("Tried.enableGUI()");
	}
	public String Tried.toString() {
		return "Tried";
	}
}
