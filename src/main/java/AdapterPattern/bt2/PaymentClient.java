package AdapterPattern.bt2;

public class PaymentClient {
    private PaymentGateway gateway;

    public PaymentClient(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void makePayment(double amount) {
        gateway.pay(amount);
    }
}
