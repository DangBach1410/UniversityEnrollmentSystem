package Observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer user1 = new Subscriber("Alice");
        Observer user2 = new Subscriber("Bob");
        Observer user3 = new Subscriber("Charlie");

        agency.registerObserver(user1);
        agency.registerObserver(user2);
        agency.registerObserver(user3);

        agency.notifyObservers("Hôm nay trời đẹp, nắng nhẹ.");

        agency.removeObserver(user2);

        agency.notifyObservers("Bản tin chiều: Kinh tế tăng trưởng mạnh.");
    }
}

