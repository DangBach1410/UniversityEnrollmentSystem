package ProxyPattern.bt1;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Ảnh chưa được load thật sự ở đây
        System.out.println("Before displaying...");

        // Khi gọi display() lần đầu mới load ảnh
        image1.display(); // Load + Hiển thị
        System.out.println("---");
        image1.display(); // Chỉ hiển thị, không load lại

        System.out.println("---");
        image2.display(); // Load + Hiển thị
    }
}

