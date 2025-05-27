package FacadePattern.bt2;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.placeOrder(
                "SP123",
                2,
                "user123",
                100.0,
                "123 Lê Lợi, TP.HCM",
                "user@example.com"
        );
    }
}

