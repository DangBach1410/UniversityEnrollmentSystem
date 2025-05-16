package SINGLETON_PATTERN.bt1;

public class Main {
    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println(config1.getAppName());
        config2.setAppName("New Name");

        System.out.println(config1.getAppName());
        System.out.println(config1 == config2);
    }
}

