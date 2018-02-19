package remserao.servicecontroller;

public interface Called extends WorkingState {
	
}

aspect CalledAspect {

	public String Called.toString() {
		return "Called";
	}
}
