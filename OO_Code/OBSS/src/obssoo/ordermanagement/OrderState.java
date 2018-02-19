package obssoo.ordermanagement;

public abstract class OrderState {

	public static Order order; // reference to context class

	public void entry() {

	}

	public void exit() {

	}

	// methods in structural view

	public void newOrder() {

	}

	public void addSelection() {

	}

	public void checkOut() {

	}

	public void paymentApproved() {

	}

	public void paymentDeclined() {

	}

	public void orderDelivered() {

	}

	public boolean isUpdated() {
		return false;
	}

	public void update(Order data) {

	}

	public boolean isUpdateRequired() {
		return false;
	}

	// methods correponding to events / actions

	public long convert(Currency source, Currency target) {
		return 0;
	}

	public void encrypt() {

	}

	public void decrypt() {

	}

	public boolean isEncrypted() {
		return false;
	}

}
