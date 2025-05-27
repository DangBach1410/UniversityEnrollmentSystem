package DecoratorPattern.bt2;

public class BasicEmailSender implements EmailService {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

