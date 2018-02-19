package obssoo.ordermanagement;

public class EncryptedPayment extends ProcessingState {
	public EncryptedPayment(Order context, Processing p) {
		o = context;
		compState = p;
	}

	public void entry() {
		}

	
	public void exit() {

	}

	// now the methods here will provide actual impl and overload the methods in super classes
	
	public boolean isEncrypted() {
		// check if it's encrypted
		return false;
	}
	
	public void decrypt() {
		// actually decrypt
	}
		
}