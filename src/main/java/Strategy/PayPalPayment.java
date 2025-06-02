package Strategy;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ qua PayPal bằng tài khoản " + email);
    }
}

