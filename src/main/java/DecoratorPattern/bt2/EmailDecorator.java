package DecoratorPattern.bt2;

public abstract class EmailDecorator implements EmailService {
    protected EmailService wrappee;

    public EmailDecorator(EmailService wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

