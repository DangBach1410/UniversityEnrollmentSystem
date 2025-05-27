package AdapterPattern.bt2;

public class StripeAdapter implements PaymentGateway {
    private StripeAPI stripeAPI;

    public StripeAdapter() {
        this.stripeAPI = new StripeAPI();
    }

    @Override
    public void pay(double amount) {
        stripeAPI.makePayment(amount);
    }
}
