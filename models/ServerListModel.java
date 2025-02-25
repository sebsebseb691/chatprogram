package models;

import java.util.LinkedList;
import java.util.List;
import observers.ViewObserver;
import observers.ViewSubject;

/**
 * The {@code ServerListModel} class manages a list of chat rooms and acts as a subject
 * for view observers, notifying them when changes occur.
 * 
 * <p>This class follows the Singleton pattern to ensure a single instance is used
 * throughout the application.</p>
 */
public class ServerListModel implements ViewSubject {

    /** The list of available chat rooms (servers). */
    private LinkedList<ChatroomModel> serverList = new LinkedList<>(); 
    
    /** The list of observers to be notified of changes. */
    private List<ViewObserver> observers = new LinkedList<>();
    
    /** The single instance of {@code ServerListModel}. */
    private static ServerListModel instance = new ServerListModel();
    
    /**
     * Private constructor to enforce Singleton pattern.
     */
    private ServerListModel() {}
    
    /**
     * Returns the singleton instance of the {@code ServerListModel}.
     * 
     * @return the single {@code ServerListModel} instance
     */
    public static ServerListModel getInstance() {
        return instance;
    }
    
    /**
     * Returns the list of available servers.
     * 
     * @return the list of chat rooms
     */
    public static LinkedList<ChatroomModel> getServerList() {
        return instance.serverList;
    }
    
    /**
     * Creates a new chat room and adds it to the server list.
     * Notifies observers of the change.
     * 
     * @param chat the chat room to be added
     */
    public void createServer(ChatroomModel chat) {
        serverList.add(chat); 
        notifyObservers();
    }
    
    /**
     * Adds an observer to be notified of changes.
     * 
     * @param observer the observer to be added
     */
    public void addObserver(ViewObserver observer) {
        observers.add(observer);
    }
    
    /**
     * Removes an observer from the notification list.
     * 
     * @param observer the observer to be removed
     */
    public void removeObserver(ViewObserver observer) {
        observers.remove(observer);
    }
    
    /**
     * Notifies all observers of changes in the server list.
     */
    public void notifyObservers() {
        for (ViewObserver observer : observers) {
            observer.update();
        }
    }
    
    /**
     * Removes a chat room from the server list and notifies observers.
     * 
     * @param chat the chat room to be removed
     */
    public void removeChat(ChatroomModel chat) {
        serverList.remove(chat);
        notifyObservers();
    }
    
    /**
     * Creates a Websocket.
     * 
     */
    private void establishConnection() {}
    
    /**
     * Retrieves all available chat rooms from the server.
     * 
     */
    private void getAllChats() {}
}
