package AdapterPattern.bt2;

public class PaypalAdapter implements PaymentGateway {
    private PaypalAPI paypalAPI;

    public PaypalAdapter() {
        this.paypalAPI = new PaypalAPI();
    }

    @Override
    public void pay(double amount) {
        paypalAPI.sendPayment(amount);
    }
}
