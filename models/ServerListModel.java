package models;
import java.util.LinkedList;
import java.util.List;

import observers.ViewObserver;
import observers.ViewSubject;


public class ServerListModel implements ViewSubject{

    private LinkedList<ChatroomModel> serverList = new LinkedList<ChatroomModel>(); 
     private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    
    //Singleton
    private static ServerListModel instance = new ServerListModel();
    private ServerListModel(){}
    public static ServerListModel getInstance() {return instance;}
    public static LinkedList<ChatroomModel> getServerList() {return instance.serverList;}

    public void createServer(ChatroomModel chat){ // ska det inte vara en chat som skapas här?
        serverList.add(chat); 
        notifyObservers();
    }

    public void addObserver(ViewObserver observer) {
        observers.add(observer);
    }

    
    public void removeObserver(ViewObserver observer) {
        observers.remove(observer);
    }


    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    public void removeChat(ChatroomModel chat){
        serverList.remove(chat);
        notifyObservers();
    }

    private void establishConnection(){}// skapar websocket 

    private void getAllChats(){} // i denna funktion kanske vi hämtar alla chatter från servern 
}
