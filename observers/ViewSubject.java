package observers;

public interface ViewSubject {
    void addObserver(ViewObserver observer);
    void removeObserver(ViewObserver observer);
    void notifyObservers();
}
