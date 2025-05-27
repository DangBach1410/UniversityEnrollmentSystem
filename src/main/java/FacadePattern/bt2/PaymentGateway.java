package FacadePattern.bt2;

class PaymentGateway {
    public boolean processPayment(String account, double amount) {
        System.out.println("Xử lý thanh toán từ tài khoản " + account + ": $" + amount);
        return true;
    }
}
