package models;
import java.util.LinkedList;
import java.util.List;

import observers.ViewObserver;
import observers.ViewSubject;


public class ServerList_m implements ViewSubject{
    private LinkedList<ChatRoom_m> serverList = new LinkedList<ChatRoom_m>(); 
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    
    //Singleton
    private static ServerList_m instance = new ServerList_m();
    private ServerList_m(){}
    public static ServerList_m getInstance() {return instance;}
    //Finns det något sätt att ge listan genom modelsfacade?
    public static LinkedList<ChatRoom_m> getServerList() {return instance.serverList;}

    public void addChatRoom(ChatRoom_m chat){
        serverList.add(chat); 
        notifyObservers();
    }

    public void removeChat(ChatRoom_m chat){
        serverList.remove(chat);
        notifyObservers();
    }

    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    public void addObserver(ViewObserver observer) {observers.add(observer);}
    public void removeObserver(ViewObserver observer) {observers.remove(observer);}
}
