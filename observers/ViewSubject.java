package observers;

public interface ViewSubject {
    void addObserver(ViewObserver o);
    void removeObserver(ViewObserver o);
    void notifyObservers();
}
