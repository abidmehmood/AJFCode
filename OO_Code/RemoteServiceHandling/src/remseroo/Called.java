package remseroo;

public class Called extends WorkingState {

	public Called(RemoteCaller context, Working w) {
		rc = context;
		compState = w;
	}

	public void entry() {
		log("Called.entry()... going to enable GUI");
		enableGUI();
	}

	public void enableGUI() {
		// this method overloads the super's method and provides impl.
		// enableGUI here.
	}

	public String toString() {
		return "CalledState";
	}

	public static void log(String st) {
		RemoteCaller.logger.log(st);
	}
}
