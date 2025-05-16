package SINGLETON_PATTERN.bt2;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Starting the application...");
        logger2.log("Starting the application...");
    }
}


