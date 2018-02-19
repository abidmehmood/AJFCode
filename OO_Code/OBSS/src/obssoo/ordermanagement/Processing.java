package obssoo.ordermanagement;

public class Processing extends OrderState {

	public ProcessingState subState; // Collaborator

	public Processing(Order o) {
		order = o;
	}

	public void entry() {
		
		subState = order.eurosPaymentState; // default state inside Working
												// state
		setSubState(subState);
	}
	
	public void exit() {
		
	}

	public void paymentDeclined() {
		// do if payment is declined
	}

	public void paymentApproved() {
		//if approved change to shipped state
		order.setState(order.shippedState);
	}

	public long convert(Currency source, Currency target) {
		return subState.convert(source, target);
	}

	public boolean isEncrypted() {
		return subState.isEncrypted();
	}

	public void encrypt() {
		subState.encrypt();
	}

	public void decrypt() {
		subState.decrypt();
	}

	public void setSubState(ProcessingState ps) { // switching the nested states
													// in
													// composite state
		subState = ps;
		subState.entry();
	}

}
