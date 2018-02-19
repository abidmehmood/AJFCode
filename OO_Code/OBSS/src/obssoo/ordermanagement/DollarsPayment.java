package obssoo.ordermanagement;

public class DollarsPayment extends ProcessingState {
	public DollarsPayment(Order context, Processing p) {
		o = context;
		compState = p;
	}

	public void entry() {
		}

	
	public void exit() {

	}

	public boolean isEncrypted() {
		// check if it's encrypted
		return false;
	}
	
	public void encrypt() {
		// actually encrypt and set state to encrypted payment state
		compState.setSubState(o.encryptedPaymentState);
	}
		
}