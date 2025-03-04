package models;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import observers.*;

/**
 * Represents a chat room
 * All messages and connected users are saved two separate linked lists
 */
interface ChatRoomModelInterface {
    /**
     * Add message to a linked list of messages 
     * @param msg the message object that should be added
     */
    public void addMessage(MessageInterface msg);

    /**
     * Add user object to a chat if the user is not already in the chat, also update the current chat to the specified chat
     * @param chatName string of the chat to join
     */
    public void joinChatRoom(String chatName);

    /**
     * Get all messages sent in a specific chat room
     * @return a linked list of Messages that implements MessageInterface
     */
    public LinkedList<MessageInterface> getMessages();
}


public class ChatRoomModel implements ChatRoomModelInterface, ViewSubject, Serializable {
    private String chatName;
    private transient List<ViewObserver> observers = new LinkedList<ViewObserver>();
    private LinkedList<MessageInterface> msgs = new LinkedList<MessageInterface>(); 
    private LinkedList<User> users = new LinkedList<User>();


    /**
     * Constructs a new ChatRoom with a specified chat name
     * 
     * @param chatName a string of the chat room
     * @throws RuntimeException if the chat name is empty or already exists in the chat room list
     */
    public ChatRoomModel(String chatName){
        if(chatName == null) return; //If chatname is null (user presses cancel), do nothing
        else if(chatName.isEmpty()) throw new RuntimeException("Chat name cannot be empty");
        else {
            for(ChatRoomModel chat : ModelsFacade.getServers().getServerList()){
                if(chat.getChatName().equals(chatName)) throw new RuntimeException("Chat name already exists");
            }
            this.chatName = chatName;
        }
    }

    @Override
    public void addMessage(MessageInterface msg){
        msgs.add(msg);
        notifyObservers();
    }

    @Override
    public void joinChatRoom(String chatName){
        ModelsFacade mf = ModelsFacade.getInstance();
        //Only add user if it is not already in the chatroom
        if(!users.contains(mf.getUser())) users.add(mf.getUser());
        this.chatName = chatName;//Fixa
        notifyObservers(); 
    }

    public void notifyObservers() {
        for(ViewObserver observer : observers){
            observer.update();
        }
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        observers = new LinkedList<>(); // Initialize the observers list after deserialization
    }

    public void addObserver(ViewObserver observer) {observers.add(observer);}
    public void removeObserver(ViewObserver observer) {observers.remove(observer);}
    public String getChatName() {return chatName;}
    @Override
    public LinkedList<MessageInterface> getMessages() {return this.msgs;}
}
