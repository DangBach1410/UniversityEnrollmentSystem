package FACTORY_METHOD_PATTERN.bt6;

public class Main {
    public static void main(String[] args) {
        // Đăng ký sản phẩm vào factory
        ProductFactory.register("book", BookProduct::new);
        ProductFactory.register("phone", PhoneProduct::new);

        // Tạo sản phẩm từ factory
        Product product1 = ProductFactory.create("book");
        product1.info(); // Sản phẩm là một cuốn sách.

        Product product2 = ProductFactory.create("phone");
        product2.info(); // Sản phẩm là một chiếc điện thoại.
    }
}

