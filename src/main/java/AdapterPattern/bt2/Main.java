package AdapterPattern.bt2;

public class Main {
    public static void main(String[] args) {
        PaymentClient paypalClient = new PaymentClient(new PaypalAdapter());
        paypalClient.makePayment(100);

        PaymentClient stripeClient = new PaymentClient(new StripeAdapter());
        stripeClient.makePayment(150);

        PaymentClient cryptoClient = new PaymentClient(new CryptoAdapter());
        cryptoClient.makePayment(30000); // ~1 BTC
    }
}
