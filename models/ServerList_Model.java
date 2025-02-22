package models;
import java.util.LinkedList;
import java.util.List;

import observers.ViewObserver;
import observers.ViewSubject;


public class ServerList_Model implements ViewSubject{
    private LinkedList<ChatRoom_Model> serverList = new LinkedList<ChatRoom_Model>(); 
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    
    //Singleton
    private static ServerList_Model instance = new ServerList_Model();
    private ServerList_Model(){}
    public static ServerList_Model getInstance() {return instance;}

    public LinkedList<ChatRoom_Model> getServerList() {return serverList;}

    public void addChatRoom(ChatRoom_Model chat){
        serverList.add(chat); 
        notifyObservers();
    }

    public void removeChat(ChatRoom_Model chat){
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
