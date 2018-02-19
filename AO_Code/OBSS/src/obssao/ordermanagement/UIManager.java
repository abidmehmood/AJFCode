// UIManager.java

package obssao.ordermanagement;

public class UIManager {

    public static void main(String args[]) {
        OrderAspect.OrderClass order = OrderAspect.OrderClass.getInstance();

        order.initialize();
        order.newOrder();
        for (int i = 0; i < 5; i++) {
            order.addSelection("ItemNo" + i);
        }

        order.checkout();

    }
}


