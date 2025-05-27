package AdapterPattern.bt2;

public class PaypalAPI {
    public void sendPayment(double amountInUsd) {
        System.out.println("Paid $" + amountInUsd + " using PayPal.");
    }
}
