package FacadePattern.bt2;

class OrderService {
    private Inventory inventory;
    private PaymentGateway payment;
    private Shipping shipping;
    private Notification notification;

    public OrderService() {
        this.inventory = new Inventory();
        this.payment = new PaymentGateway();
        this.shipping = new Shipping();
        this.notification = new Notification();
    }

    public void placeOrder(String productId, int quantity, String account, double amount, String address, String email) {
        System.out.println("\nBắt đầu xử lý đơn hàng...");

        if (!inventory.checkStock(productId, quantity)) {
            System.out.println("Hết hàng.");
            return;
        }

        if (!payment.processPayment(account, amount)) {
            System.out.println("Thanh toán thất bại.");
            return;
        }

        inventory.reduceStock(productId, quantity);
        shipping.shipProduct(productId, quantity, address);
        notification.sendConfirmation(email, "Đơn hàng của bạn đã được xác nhận và đang được giao!");

        System.out.println(" Đơn hàng hoàn tất.\n");
    }
}

