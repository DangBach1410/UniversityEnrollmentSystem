package Adapter;

public class PaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldSystem;

    public PaymentAdapter(OldPaymentSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void processPayment(double amount) {
        oldSystem.makePayment(amount);
    }
}

