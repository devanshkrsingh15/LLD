package Template;

import java.util.*;

public class AmazonDeliveryDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        System.out.println();
        DeliverySystem deliverySystem = new LocalDeliverySystem();
        deliverySystem.processOrder();
        System.out.println("-------------");
        deliverySystem = new InternationalDeliverySystem();
        deliverySystem.processOrder();

    }
}

    abstract class DeliverySystem {
        public void processOrder() {
            verifyOrder();
            assignDeliveryPartner();
            trackDelivery();
        }

        abstract void verifyOrder();

        abstract void assignDeliveryPartner();

        abstract void trackDelivery();
    }

    class LocalDeliverySystem extends DeliverySystem {
        @Override
        void verifyOrder() {
            System.out.println("Verifying Order in Local Area");

        }

        @Override
        void assignDeliveryPartner() {
            System.out.println("Assigning Delivery Partner in Local Area");

        }

        @Override
        void trackDelivery() {
            System.out.println("Tracking Delivery in Local Area");
        }
    }

    class InternationalDeliverySystem extends DeliverySystem {
        @Override
        void verifyOrder() {
            System.out.println("Verifying Order in International Area");

        }

        @Override
        void assignDeliveryPartner() {
            System.out.println("Assigning Delivery Partner in International Area");

        }

        @Override
        void trackDelivery() {
            System.out.println("Tracking Delivery in International Area");
        }
}
