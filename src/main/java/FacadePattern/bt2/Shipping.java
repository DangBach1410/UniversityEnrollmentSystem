package FacadePattern.bt2;

class Shipping {
    public void shipProduct(String productId, int quantity, String address) {
        System.out.println("Giao hàng " + quantity + " sản phẩm " + productId + " đến " + address);
    }
}

