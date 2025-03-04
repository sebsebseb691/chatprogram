package models;
import java.util.LinkedList;
import java.util.List;
import observers.*;


/**
 * Handles the list of created chat rooms in a linked list
 */
interface ServerListModelInterface {
    /**
     * Add a chat room object to a linked list
     * @param chat the chat room to be added
     */
    public void addChatRoom(ChatRoomModel chat);

    /**
     * Remove a chat room from a linked list
     * @param chat the chat room to be removed
     */
    public void removeChat(ChatRoomModel chat);

    /**
     * Used to get the list of chat rooms
     * @return a linked list of all existing ChatRoomModels
     */
    public LinkedList<ChatRoomModel> getServerList();
}


public class HomePageModel implements ServerListModelInterface, ViewSubject{
    private LinkedList<ChatRoomModel> serverList = new LinkedList<ChatRoomModel>(); 
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    
    //Singleton
    private static HomePageModel instance = new HomePageModel();
    private HomePageModel(){}
    public static HomePageModel getInstance() {return instance;}
    
    @Override
    public void addChatRoom(ChatRoomModel chat){
        serverList.add(chat); 
        notifyObservers();
    }

    @Override
    public void removeChat(ChatRoomModel chat){
        serverList.remove(chat);
        notifyObservers();
    }

    @Override
    public LinkedList<ChatRoomModel> getServerList() {return serverList;}

    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    public void addObserver(ViewObserver observer) {observers.add(observer);}
    public void removeObserver(ViewObserver observer) {observers.remove(observer);}
}
