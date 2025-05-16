package FACTORY_METHOD_PATTERN.bt5;

public class Main {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("email");
        notification1.send(); // Gửi thông báo qua Email.

        Notification notification2 = NotificationFactory.createNotification("sms");
        notification2.send(); // Gửi thông báo qua SMS.

        Notification notification3 = NotificationFactory.createNotification("push");
        notification3.send(); // Gửi thông báo đẩy (Push Notification).
    }
}

