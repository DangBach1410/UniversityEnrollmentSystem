package SINGLETON_PATTERN.bt3;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.INSTANCE;
        db1.connect();

        DatabaseConnection db2 = DatabaseConnection.INSTANCE;
        db2.connect();

        System.out.println(db1 == db2);
    }
}

