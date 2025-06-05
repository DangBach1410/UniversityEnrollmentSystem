package bt2;

public class Main {
    public static void main(String[] args) {
        ImageData original = new BasicImage("anh123.jpg");

        System.out.println("--- Lưu ảnh gốc ---");
        original.save();

        System.out.println("\n--- Lưu ảnh đã nén ---");
        ImageData compressed = new CompressedImage(original);
        compressed.save();

        System.out.println("\n--- Lưu ảnh đã mã hóa ---");
        ImageData encrypted = new EncryptedImage(original);
        encrypted.save();

        System.out.println("\n--- Lưu ảnh đã nén và mã hóa ---");
        ImageData compressedEncrypted = new EncryptedImage(new CompressedImage(original));
        compressedEncrypted.save();
    }
}
