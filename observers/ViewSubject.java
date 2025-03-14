package observers;

/**
 * Interface for the observable part of the observer pattern
 */
public interface ViewSubject {
    /**
     * Add an observer to the list of observers
     * @param observer the observer to be added
     */
    void addObserver(ViewObserver observer);

    /**
     * Remove an observer from the list of observers
     * @param observer the observer to be removed
     */
    void removeObserver(ViewObserver observer);

    /**
     * Notify all observers that the observable object has been updated
     */
    void notifyObservers();
}
