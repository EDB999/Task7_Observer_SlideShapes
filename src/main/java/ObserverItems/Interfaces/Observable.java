package ObserverItems.Interfaces;

public interface Observable {
    public void notifyAllObserver();
    public void attach(Observer obs);
    public void detach(Observer obs);
}
