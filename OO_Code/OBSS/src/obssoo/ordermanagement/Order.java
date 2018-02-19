package obssoo.ordermanagement;

public class Order {

	//context class to represent the remote call handling as a whole

		public OrderState state; // the collaborator
		public Uninitialized uninitializedState;
		public Unsubmitted unsubmittedState;
		public Processing processingState;
		public EurosPayment eurosPaymentState;
		public DollarsPayment dollarsPaymentState;
		public EncryptedPayment encryptedPaymentState;
		public Delivered deliveredState;
		public Shipped shippedState;
				
		public long orderID = 0;
		
		//variables in result of associations
		Customer isPlaceBy = null;
		CreditCardCharge isPaidFor = null;
		DBManager persister = null;
		
		
		Order() { // constructor
			uninitializedState = new Uninitialized(this);
			unsubmittedState = new Unsubmitted(this);
			processingState = new Processing(this);
			eurosPaymentState = new EurosPayment(this, processingState);
			dollarsPaymentState = new DollarsPayment(this, processingState);
			encryptedPaymentState = new EncryptedPayment(this, processingState);
			deliveredState = new Delivered(this);
			shippedState = new Shipped(this);
			
			state = uninitializedState; // default state
			
		}

		// method to change the state
		public void setState(OrderState st) {
			state = st;
			state.entry();
		}

		// methods in structural view
		//Note: events/actions of Order which are not here are implemented in CreditCardCharge class
		// because they correspond to states which have been mapped to that class. 
		
		public void newOrder() {
			state.newOrder();
		}
		
		public void addSelection() {
			state.addSelection();
		}
		
		public void checkOut() {
			state.checkOut();
		}

		public void paymentApproved() {
			state.paymentApproved();
		}
		
		public void paymentDeclined() {
			state.paymentDeclined();
		}
		
		public void orderDelivered() {
			state.orderDelivered();
		}
		
		public boolean isUpdated() {
			return state.isUpdated();
		}
		
		public void update(Order data) {
			state.update(data);
		}
		
		public boolean isUpdateRequired() {
			return state.isUpdateRequired();
		}
		
		// methods which are not in structural view but given in events/actions of Order
		// they will pass method calls to CreditCardCharge class
		// because they correspond to states which have been mapped to that class. 
		
		public long convert(Currency source, Currency target) {
			return state.convert(source, target);
		}
		
		public void encrypt() {
			state.encrypt();
		}
		
		public void decrypt() {
			state.decrypt();
		}
		
		public boolean isEncrypted() {
			return state.isEncrypted();
		}
}
