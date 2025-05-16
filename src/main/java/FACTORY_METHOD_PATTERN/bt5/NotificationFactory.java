package FACTORY_METHOD_PATTERN.bt5;

public class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type == null) {
            return null;
        }

        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Loại thông báo không hợp lệ: " + type);
        };
    }
}

