package ChainOfResponsibility;

public class SwiggyOrderDemo {
    public static void main(String[] args) {
        OrderValidator chainOfValidator = new OrderValidator(
                new PaymentValidator(new PaymentFailure(null)));

        chainOfValidator.process("Chicken Tikka");

    }
}

interface IHandler {
    public void process(String item);
}

class OrderValidator implements IHandler {
    IHandler next;

    OrderValidator(IHandler next) {
        this.next = next;
    }

    public void process(String item) {
        System.out.println("Validating order for " + item);

        if (next != null) {
            next.process(item);
        }
    }
}

class PaymentValidator implements IHandler {
    IHandler next;

    PaymentValidator(IHandler next) {
        this.next = next;
    }

    public void process(String item) {
        System.out.println("Processing payment for order of " + item);

        if (next != null) {
            next.process(item);
        }
    }
}

class RestaurantHandler implements IHandler {
    IHandler next;

    RestaurantHandler(IHandler next) {
        this.next = next;
    }

    public void process(String item) {
        System.out.println("Order received by Restaurant, preparing " + item);

        if (next != null) {
            next.process(item);
        }
    }
}
class PaymentFailure implements IHandler{

     IHandler next;

    PaymentFailure(IHandler next) {
        this.next = next;
    }

    @Override
    public void process(String item) {
        System.out.println("Payment fails, do you want to refund or reorder");

        if (next != null) {
            next.process(item);
        }
    }
    
}
class DeliveryHandler implements IHandler {
    IHandler next;

    DeliveryHandler(IHandler next) {
        this.next = next;
    }

    public void process(String item) {
        System.out.println("Order prepared, ready to dispatch " + item);

        if (next != null) {
            next.process(item);
        }
    }
}
