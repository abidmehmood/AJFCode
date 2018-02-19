package obssoo.ordermanagement;

public class Shipped extends OrderState {

	public Shipped(Order o) {
		order = o;
	}

	public void entry() {
	
	}

	
	public void exit() {
		
	}
	
	public void orderDelivered() {
		// set state to delivered
		order.setState(order.deliveredState);
	}
}