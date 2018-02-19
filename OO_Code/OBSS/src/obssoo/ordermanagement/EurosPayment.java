package obssoo.ordermanagement;

public class EurosPayment extends ProcessingState {
	public EurosPayment(Order context, Processing p) {
		o = context;
		compState = p;
	}

	public void entry() {
		}

	
	public void exit() {

	}

	// now the methods here will provide actual impl and overload the methods in super classes
	
	public long convert(Currency source, Currency target) {
		// do the actual conversion here and return converted amount
		// and set the state to DollarsPayment
		long amountInDollars = 0;
		compState.setSubState(o.dollarsPaymentState);
		
		return amountInDollars;
	}
		
}
