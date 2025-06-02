package Strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double totalAmount) {
        if (paymentStrategy == null) {
            System.out.println("Vui lòng chọn phương thức thanh toán trước khi thanh toán!");
        } else {
            paymentStrategy.pay(totalAmount);
        }
    }
}

