package Strategy;

public class PaymentStrategyDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        PaymentManager paymentManager = new PaymentManager();
        paymentManager.setPaymentStrategy(new CashOnDeliveryStrategy());
        paymentManager.processPayment();

        paymentManager.setPaymentStrategy(new CryptoStrategy());
        paymentManager.processPayment();

        paymentManager.setPaymentStrategy(null);
        paymentManager.processPayment();

    }
}

class PaymentManager {
    IPaymentStrategy paymentStrategy;

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        if (paymentStrategy == null) {
            System.out.println("Please set a payment strategy");
        } else {
            paymentStrategy.execute();
        }
    }

    public void finalize() {
        if (paymentStrategy != null) {
            // Clean up the strategy instance
            paymentStrategy = null;
        }
    }
}

interface IPaymentStrategy {
    void execute();
}

class CreditCardStrategy implements IPaymentStrategy {
    @Override
    public void execute() {
        System.out.println("Making Payment through Credit Card");
    }

}

class CashOnDeliveryStrategy implements IPaymentStrategy {
    @Override
    public void execute() {
        System.out.println("Making Payment through Cash on Delivery");
    }

}

class UPIStrategy implements IPaymentStrategy {

    @Override
    public void execute() {
        System.out.println("Making Payment through UPI");
    }

}

class CryptoStrategy implements IPaymentStrategy {
    @Override
    public void execute() {
        System.out.println("Making Payment through Crypto");
    }

}