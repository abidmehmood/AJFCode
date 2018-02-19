package obssoo.ordermanagement;

public class Uninitialized extends OrderState {

	public Uninitialized(Order o) {
		order = o;
	}

	public void entry() {
	
	}

	
	public void exit() {
		
	}
	
	public void newOrder() {
		
		order.setState(order.unsubmittedState);		
		
	}
	
	

}
