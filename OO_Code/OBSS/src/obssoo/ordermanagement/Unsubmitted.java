package obssoo.ordermanagement;

public class Unsubmitted extends OrderState {

	public Unsubmitted(Order o) {
		order = o;
	}

	public void entry() {
	
	}

	
	public void exit() {
		
	}
	
	public void addSelection() {
		// keep adding selection here
	}
	
	public void update(Order o) {
		//here we'll make call to method for persistence
		
		
		
		
	}
	
	public boolean isUpdateRequired() {
		// check if update is required
		return false;
	}

	public void checkOut() {
		order.setState(order.processingState);
		
	}
}
