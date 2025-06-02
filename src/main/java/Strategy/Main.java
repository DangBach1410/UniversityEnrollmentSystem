package Strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        double amount = 500_000;
        cart.checkout(amount);

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Nguyen Van A"));
        cart.checkout(amount);

        cart.setPaymentStrategy(new PayPalPayment("abc@example.com"));
        cart.checkout(amount);

        cart.setPaymentStrategy(new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        cart.checkout(amount);
    }
}

