public class PaymentStrategyDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        PaymentManager paymentManager = new PaymentManager();
        paymentManager.setPaymentStrategy(PaymentOptions.COD);
        paymentManager.processPayment();

        paymentManager.setPaymentStrategy(PaymentOptions.Crypto);
        paymentManager.processPayment();

        paymentManager.setPaymentStrategy(PaymentOptions.UPI);
        paymentManager.processPayment();

    }
}

enum PaymentOptions {
    CreditCard, COD, UPI, Crypto
}

class PaymentStrategyFactory {
    public static IPaymentStrategy getStrategy(PaymentOptions paymentStrategy) {
        if (paymentStrategy == PaymentOptions.CreditCard)
            return new CreditCardStrategy();
        else if (paymentStrategy == PaymentOptions.COD)
            return new CashOnDeliveryStrategy();
        else if (paymentStrategy == PaymentOptions.UPI)
            return new UPIStrategy();
        else if (paymentStrategy == PaymentOptions.Crypto)
            return new CryptoStrategy();
        else {
            // default -> COD
            return new CashOnDeliveryStrategy();
        }
    }
}

class PaymentManager {
    IPaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentOptions paymentStrategy) {
        this.paymentStrategy = PaymentStrategyFactory.getStrategy(paymentStrategy);
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