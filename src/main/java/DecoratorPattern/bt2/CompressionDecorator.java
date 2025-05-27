package DecoratorPattern.bt2;

public class CompressionDecorator extends EmailDecorator {
    public CompressionDecorator(EmailService wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        String compressed = compress(message);
        super.send(compressed);
    }

    private String compress(String data) {
        return "[Compressed]" + data + "[/Compressed]";
    }
}

