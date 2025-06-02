package Adapter;

public class Main {
    public static void main(String[] args) {
        OldPaymentSystem oldSystem = new OldPaymentSystem();

        PaymentProcessor processor = new PaymentAdapter(oldSystem);

        processor.processPayment(500000);
    }
}