// Shipped.java

package obssao.ordermanagement;

public interface Shipped extends OrderState {

}
    aspect ShippedAspect {
private boolean Shipped.orderDelivered=false;
public void Shipped.entry(){
        System.out.println("Shipped.entry()");
        orderDelivered=true;
        if(orderDelivered){
        System.out.println("Shipped.entry(): order delivered, change to delivered state");
        order.setState(order.deliveredState);

        }else{
        System.out.println("Shipped.entry(): order not delivered, stay in shipped state");
        }


        }
public void Shipped.exit(){
        System.out.println("Shipped.exit()");
        }

public boolean Shipped.orderDelivered(){
        System.out.println("Shipped.orderDelivered() --- changing to deliveredState");
        return false;

        }


        }