// OrderState.java

package obssao.ordermanagement;


public interface OrderState {

}

    aspect OrderStateAspect {

// constructor for this class
public OrderAspect.OrderClass OrderState.order;


public void OrderState.entry(){
        System.out.println("OrderState.orderEntry()");
        }

public void OrderState.exit(){

        }

public void OrderState.newOrder(){

        }

public void OrderState.addSelection(String item){

        }

public void OrderState.checkout(){

        }

public boolean OrderState.paymentApproved(){
        // will be overloaded
        return false;
        }

public boolean OrderState.paymentDeclined(){
        // will be overloaded
        return false;

        }

public boolean OrderState.orderDelivered(){
        // will be overloaded
        return false;
        }


        }