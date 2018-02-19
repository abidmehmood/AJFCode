// ProcessingState.java

package obssao.ordermanagement;

public interface ProcessingState {

}

    aspect ProcessingStateAspect {

public OrderAspect.OrderClass ProcessingState.orderContext;
public OrderAspect.ProcessingClass ProcessingState.compState;

public void ProcessingState.entry(){
        System.out.println("ProcessingState.entry()");
        }

public void ProcessingState.exit(){

        }


public void ProcessingState.convert(){
        System.out.println("ProcessingState.convert()");
        }

public void ProcessingState.paymentApproved(){
        System.out.println("ProcessingState.paymentApproved()");
        }

public void ProcessingState.paymentDeclined(){
        System.out.println("ProcessingState.paymentDeclined()");
        }

        }