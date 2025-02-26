package models;

import java.util.LinkedList;
import java.util.List;
import observers.ViewObserver;
import observers.ViewSubject;

/**
 * ChatRoom_m manages messages, users and observer notifications for UI updates
 */
public class ChatRoom_m implements ViewSubject {
    private String chatName;
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    private LinkedList<Message> msgs = new LinkedList<Message>(); 
    private LinkedList<User> users = new LinkedList<User>();

    // constructor for chatroom, initializes a new chat with a given name
    public ChatRoom_m(String chatName){
        if(chatName == null) return; //If chatname is null (user presses cancel), do nothing
        else if(chatName.isEmpty()) throw new RuntimeException("Chat name cannot be empty");
        else {this.chatName = chatName;}
    }

    // adds message to chat and notify observers
    public void addMessage(Message msg){
        msgs.add(msg);
        notifyObservers();
    }

    // adds user to chat
    public void joinChatRoom(){
        ModelsFacade mf = new ModelsFacade();
        //Only add user if it is not already in the chatroom
        if(!users.contains(mf.getUser())) users.add(mf.getUser());
    }

    // notify observers that chatroom is updated
    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    // adds or removes an observer from a chatroom
    public void addObserver(ViewObserver observer) {observers.add(observer);}
    public void removeObserver(ViewObserver observer) {observers.remove(observer);}

    // get methods for chat name, room and chat history
    public String getChatName() {return chatName;}
    public ChatRoom_m getChatRoom() {return this;}
    public LinkedList<Message> getMessages() {return this.msgs;}

}
