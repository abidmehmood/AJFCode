// Uninitialized.java

package obssao.ordermanagement;

public interface Uninitialized extends OrderState {

}
    aspect UninitializedAspect {
public void Uninitialized.entry(){
        System.out.println("Uninitialized.entry()");
        }
public void Uninitialized.exit(){
        System.out.println("Uninitialized.exit()");
        }

public void Uninitialized.newOrder(){
        System.out.println("Uninitialized.newOrder()");
        order.setState(order.unsubmittedState);

        }

        }
