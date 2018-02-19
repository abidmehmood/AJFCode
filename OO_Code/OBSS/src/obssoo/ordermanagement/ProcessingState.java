package obssoo.ordermanagement;

public abstract class ProcessingState {
	public Order o; // we need context here also
	public Processing compState;

	public void entry() {

	}

	public void exit() {

	}

	public void paymentDeclined() {

	}

	public void paymentApproved() {

	}

	public long convert(Currency source, Currency target) {
		return 0;
	}

	public boolean isEncrypted() {
		return false;

	}

	public void encrypt() {

	}

	public void decrypt() {

	}

}
