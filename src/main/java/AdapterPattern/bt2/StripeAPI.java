package AdapterPattern.bt2;

public class StripeAPI {
    public void makePayment(double dollars) {
        System.out.println("Paid $" + dollars + " using Stripe.");
    }
}
