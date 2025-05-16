package SINGLETON_PATTERN.bt3;

public enum DatabaseConnection {
    INSTANCE;

    DatabaseConnection() {
        System.out.println("DatabaseConnection instance created.");
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}

