package obssoo.ordermanagement;

import java.util.Date;

public class CreditCardCharge {

	private long tranID;
	private Date tranDate;
	private long amount;
	private long accNum;
	private String ccHolderName;
	private String ccHolderAddress;
	private Date ccExpiry;
	private boolean encrypted;
	
	// field for relationship
	
	Order paysFor = null;
	Currency converter = null;
	
	public void charge() {
		
	}
	
	public void chargeSuccessful() {
		
	}
	
	public void chargeUnsuccessful() {
		
	}
	
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
