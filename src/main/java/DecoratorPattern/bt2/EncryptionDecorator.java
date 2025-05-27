package DecoratorPattern.bt2;

public class EncryptionDecorator extends EmailDecorator {
    public EncryptionDecorator(EmailService wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        String encrypted = encrypt(message);
        super.send(encrypted);
    }

    private String encrypt(String data) {
        return "[Encrypted]" + data + "[/Encrypted]";
    }
}

