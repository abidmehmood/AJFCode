// Processing.java

package obssao.ordermanagement;

public interface Processing extends OrderState {

}

    aspect ProcessingAspect {

static class ProcessingStateClass implements ProcessingState {
    static ProcessingStateClass getInstance() {
        return new ProcessingStateClass();
    }
}
    declare parents:OrderAspect.EurosPaymentClass extends ProcessingStateClass;

public static ProcessingStateClass subState; //Collaborator for substate

public void Processing.entry(){
        System.out.println("Processing.entry()... with context = "+order);
        subState=order.eurosPaymentState;
        System.out.println("About to call setSubState");
        setSubState(subState);
        }

public void Processing.setSubState(ProcessingState ws){
        System.out.println("Processing.setSubState()...Going to change state to "+ws.toString());
        subState=(ProcessingStateClass)ws;
        subState.entry();
        }
        }