//CreditCardCharge.java

package obssao.ordermanagement;

public interface CreditCardCharge {

}

    aspect CreditCardChargeAspect {

private long CreditCardCharge.tranID;
private long CreditCardCharge.tranDate;
private long CreditCardCharge.amount;
private long CreditCardCharge.accNum;
private String CreditCardCharge.ccHolderName;
private String CreditCardCharge.ccHolderAddress;
private java.util.Date CreditCardCharge.ccExpiry;

        // declaration of associations
        Order CreditCardCharge.paysFor=null;

        void CreditCardCharge.charge(){

        }

        void CreditCardCharge.chargeSuccessful(){

        }

        void CreditCardCharge.chargeUnsuccessful(){

        }
        }