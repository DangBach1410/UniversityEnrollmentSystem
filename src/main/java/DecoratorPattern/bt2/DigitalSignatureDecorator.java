package DecoratorPattern.bt2;

public class DigitalSignatureDecorator extends EmailDecorator {
    public DigitalSignatureDecorator(EmailService wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        String signed = sign(message);
        super.send(signed);
    }

    private String sign(String data) {
        return data + " [Signed: JohnDoe]";
    }
}

