package Observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("Đã đăng ký người dùng: " + o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("Đã hủy đăng ký người dùng: " + o);
    }

    @Override
    public void notifyObservers(String news) {
        System.out.println("\nCó tin mới: " + news);
        for (Observer o : observers) {
            o.update(news);
        }
    }
}

