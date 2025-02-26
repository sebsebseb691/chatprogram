package models;
import java.util.LinkedList;
import java.util.List;

import observers.ViewObserver;
import observers.ViewSubject;

/**
 * Serverlist_m is a singleton that manages the list of available chatrooms
 */
public class ServerList_m implements ViewSubject{
    private LinkedList<ChatRoom_m> serverList = new LinkedList<ChatRoom_m>(); 
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    
    //Singleton
    private static ServerList_m instance = new ServerList_m();
    
    // constructor
    private ServerList_m(){}

    // lists of instances and chatrooms
    public static ServerList_m getInstance() {return instance;}
    public static LinkedList<ChatRoom_m> getServerList() {return instance.serverList;}

    // creates a new chatroom, adds to the list and notify observers
    public void createServer(ChatRoom_m chat){
        serverList.add(chat); 
        notifyObservers();
    }

    // removes a chatroom from the list and notify observers
    public void removeChat(ChatRoom_m chat){
        serverList.remove(chat);
        notifyObservers();
    }

    // mothod for notifying observers
    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    // methods for observers
    public void addObserver(ViewObserver observer) {observers.add(observer);}
    public void removeObserver(ViewObserver observer) {observers.remove(observer);}
}
