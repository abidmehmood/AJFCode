// Delivered.java

package obssao.ordermanagement;

public interface Delivered extends OrderState {

}

    aspect DeliveredAspect {

public void Delivered.entry(){
        System.out.println("Delivered.entry(): order delivered, bye");


        }

public void Delivered.exit(){
        System.out.println("Delivered.exit()");

        }
        }