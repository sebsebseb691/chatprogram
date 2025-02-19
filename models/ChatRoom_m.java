package models;
import java.util.LinkedList;
import java.util.List;
import observers.ViewObserver;
import observers.ViewSubject;


public class ChatRoom_m implements ViewSubject {
    private String chatName;
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    private LinkedList<Message> msgs = new LinkedList<Message>(); 
    private LinkedList<User> users = new LinkedList<User>();


    public ChatRoom_m(String chatName){
        if(chatName == null) return; //If chatname is null (user presses cancel), do nothing
        else if(chatName.isEmpty()) throw new RuntimeException("Chat name cannot be empty");
        else {
            for(ChatRoom_m chat : ServerList_m.getServerList()){
                if(chat.getChatName().equals(chatName)) throw new RuntimeException("Chat name already exists");
            }
            this.chatName = chatName;
        }
    }


    public void addMessage(Message msg){
        msgs.add(msg);
        notifyObservers();
    }


    public void joinChatRoom(String chatName){
        ModelsFacade mf = new ModelsFacade();
        //Only add user if it is not already in the chatroom
        if(!users.contains(mf.getUser())) users.add(mf.getUser());
        this.chatName = chatName;
        notifyObservers(); 
    }


    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    public void addObserver(ViewObserver observer) {observers.add(observer);}
    public void removeObserver(ViewObserver observer) {observers.remove(observer);}

    public String getChatName() {return chatName;}
    public ChatRoom_m getChatRoomObj() {return this;}
    public LinkedList<Message> getMessages() {return this.msgs;}
}
