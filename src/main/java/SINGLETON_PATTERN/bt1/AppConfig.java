package SINGLETON_PATTERN.bt1;

public class AppConfig {
    private static AppConfig instance;

    private String appName = "My Application";

    private AppConfig() {
        System.out.println("AppConfig instance created.");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String name) {
        this.appName = name;
    }
}

