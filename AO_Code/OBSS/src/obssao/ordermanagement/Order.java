// Order.java

package obssao.ordermanagement;

//import obssao.persistence.*;

public interface Order {
}

    aspect OrderAspect {
// declaration of fields and methods into interface
public long Order.orderID=-1;

        //definition of associations

        Customer Order.isPlaceBy=null;
        CreditCardCharge Order.isPaidFor=null;

public void Order.newOrder(){
        System.out.println("Order.newOrder with state = "+orderState);
        // order.setState(order.unsubmittedState);
        orderState.newOrder();

        }

public void Order.addSelection(String item){
        System.out.println("Order.addSelection())");
        orderState.addSelection(item);
        }

public void Order.checkout(){
        System.out.println("Order.checkout())");
        orderState.checkout();
        }

public boolean Order.paymentApproved(){
        return orderState.paymentApproved();
        }

public boolean Order.paymentDeclined(){
        return orderState.paymentDeclined();
        }

public boolean Order.orderDelivered(){
        return orderState.orderDelivered();
        }

static class OrderClass {
    public static OrderClass getInstance() {
        return new OrderClass();
    }
}

// aspect-specific interface implementations to provide access to intances
// of classes that correspond to interfaces
static class OrderStateClass {
    static OrderStateClass getInstance() {
        return new OrderStateClass();
    }
}

static class UninitializedClass {
    UninitializedClass(Order o) {
        order = (OrderClass) o;
    }

    static UninitializedClass getInstance(Order o) {

        return new UninitializedClass(o);
    }
}

static class UnsubmittedClass {
    UnsubmittedClass(Order o) {
        order = (OrderClass) o;
    }

    static UnsubmittedClass getInstance(Order o) {

        return new UnsubmittedClass(o);
    }
}

static class ProcessingClass {
    ProcessingClass(Order o) {
        order = (OrderClass) o;
    }

    static ProcessingClass getInstance(Order o) {

        return new ProcessingClass(o);
    }
}

static class EurosPaymentClass {
    EurosPaymentClass(Order o, Processing ps) {
        orderContext = (OrderClass) o;
        compState = (OrderAspect.ProcessingClass) ps;
    }

    static EurosPaymentClass getInstance(Order o, Processing ps) {
        return new EurosPaymentClass(o, ps);
    }

    public String toString() {
        return "EurosPayment";
    }
}

static class DollarsPaymentClass {
    DollarsPaymentClass(Order o, Processing ps) {
        orderContext = (OrderClass) o;
        compState = (OrderAspect.ProcessingClass) ps;
    }

    static DollarsPaymentClass getInstance(Order o, Processing ps) {
        return new DollarsPaymentClass(o, ps);
    }

    public String toString() {
        return "DollarsPayment";
    }
}

static class EncryptedPaymentClass {
    EncryptedPaymentClass(Order o, Processing ps) {
        orderContext = (OrderClass) o;
        compState = (OrderAspect.ProcessingClass) ps;
    }

    static EncryptedPaymentClass getInstance(Order o, Processing ps) {
        return new EncryptedPaymentClass(o, ps);
    }

    public String toString() {
        return "EncryptedPayment";
    }
}

static class ShippedClass {
    ShippedClass(Order o) {
        order = (OrderClass) o;
    }

    static ShippedClass getInstance(Order o) {

        return new ShippedClass(o);
    }
}

static class DeliveredClass {
    DeliveredClass(Order o) {
        order = (OrderClass) o;
    }

    static DeliveredClass getInstance(Order o) {

        return new DeliveredClass(o);
    }
}

    // declare associations of classes to interfaces and other classes
    declare parents:OrderStateClass implements OrderState;
        declare parents:OrderClass implements Order;
        declare parents:UninitializedClass implements Uninitialized;
        declare parents:UnsubmittedClass implements Unsubmitted;
        declare parents:ProcessingClass implements Processing;
        declare parents:ShippedClass implements Shipped;
        declare parents:DeliveredClass implements Delivered;
        //substates of Processing
        declare parents:EurosPaymentClass implements EurosPayment;
        declare parents:DollarsPaymentClass implements DollarsPayment;
        declare parents:EncryptedPaymentClass implements EncryptedPayment;

        declare parents:UninitializedClass extends OrderStateClass;
        declare parents:UnsubmittedClass extends OrderStateClass;
        declare parents:ProcessingClass extends OrderStateClass;
        declare parents:ShippedClass extends OrderStateClass;
        declare parents:DeliveredClass extends OrderStateClass;

public OrderStateClass Order.orderState; // reference to class that
// handles states

public UninitializedClass Order.uninitializedState;// references to classes
// each
// representing
// a state
public UnsubmittedClass Order.unsubmittedState;
public ProcessingClass Order.processingState;
public EurosPaymentClass Order.eurosPaymentState;
public DollarsPaymentClass Order.dollarsPaymentState;
public EncryptedPaymentClass Order.encryptedPaymentState;
public ShippedClass Order.shippedState;
public DeliveredClass Order.deliveredState;

// initialize the Order

public void Order.initialize(){
        System.out.println("Order.initialize()...");
        orderState=OrderStateClass.getInstance();
        uninitializedState=UninitializedClass.getInstance(this);
        unsubmittedState=UnsubmittedClass.getInstance(this);
        processingState=ProcessingClass.getInstance(this);
        shippedState=ShippedClass.getInstance(this);
        deliveredState=DeliveredClass.getInstance(this);

        dollarsPaymentState=DollarsPaymentClass.getInstance(this,processingState);
        eurosPaymentState=EurosPaymentClass.getInstance(this,processingState);
        encryptedPaymentState=EncryptedPaymentClass.getInstance(this,processingState);

        orderState=uninitializedState;

        orderState.entry();
        }

public void Order.setState(OrderState st){
        System.out.println("Order.setState(): going to change the state to "
        +st.toString());
        orderState=(OrderStateClass)st;
        System.out.println("Order.setState(): state changed to "+orderState);
        orderState.entry();
        }

        }