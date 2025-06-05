package bt1;

import java.util.ArrayList;
import java.util.List;

class Publisher implements Subject {
    private String name;
    private List<Observer> followers = new ArrayList<>();

    public Publisher(String name) {
        this.name = name;
    }

    public void post(String content) {
        System.out.println(name + " đăng bài: " + content);
        notifyObservers(name + " vừa đăng bài: " + content);
    }

    @Override
    public void subscribe(Observer o) {
        followers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        followers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : followers) {
            o.update(message);
        }
    }
}
