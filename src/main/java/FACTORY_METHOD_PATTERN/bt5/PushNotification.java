package FACTORY_METHOD_PATTERN.bt5;

public class PushNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Gửi thông báo đẩy (Push Notification).");
    }
}

