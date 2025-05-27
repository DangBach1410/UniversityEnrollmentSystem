package ProxyPattern.bt2;

public class Main {
    public static void main(String[] args) {
        Document doc1 = new ProxyDocument("confidential.pdf", "admin");
        Document doc2 = new ProxyDocument("confidential.pdf", "guest");

        System.out.println("== Admin access ==");
        doc1.display(); // Được phép

        System.out.println("\n== Guest access ==");
        doc2.display(); // Bị từ chối
    }
}

