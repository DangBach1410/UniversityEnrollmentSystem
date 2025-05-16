package SINGLETON_PATTERN.bt2;

public class Logger {
    private Logger() {
        System.out.println("Logger instance created.");
    }

    private static class LoggerHelper {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHelper.INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

