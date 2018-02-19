// Unsubmitted.java

package obssao.ordermanagement;

import obssao.persistence.UpdateRequired;

public interface Unsubmitted extends OrderState, UpdateRequired {

}
    aspect UnsubmittedAspect {

public void Unsubmitted.entry(){
        System.out.println("Unsubmitted.entry()");
        }

public void Unsubmitted.exit(){
        System.out.println("Unsubmitted.exit()");
        }

public void Unsubmitted.addSelection(String item){
        System.out.println("Unsubmitted.newOrder(): added item = "+item);
        order.setState(order.unsubmittedState);
        }

public void Unsubmitted.checkout(){
        System.out.println("Unsubmitted.checkout()... going to change to processingState");
        order.setState(order.processingState);
        }
        }