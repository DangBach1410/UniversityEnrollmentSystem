package bt1;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers(String message);
}
