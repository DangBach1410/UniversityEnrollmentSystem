package DecoratorPattern.bt2;

public class Main {
    public static void main(String[] args) {
        EmailService email = new BasicEmailSender();

        // Thêm mã hóa, sau đó nén, sau đó ký
        email = new EncryptionDecorator(email);
        email = new CompressionDecorator(email);
        email = new DigitalSignatureDecorator(email);

        email.send("This is a confidential message.");
    }
}
