package models;
import java.util.LinkedList;
import java.util.List;
import observers.*;

/**
 * Represents a chat room
 * All messages and connected users are saved two separate linked lists
 */
interface ChatRoom_Model_Interface {
    /**
     * Add message to a linked list of messages 
     * @param msg the message object that should be added
     */
    public void addMessage(Message msg);

    /**
     * Add user object to a chat if the user is not already in the chat, also update the current chat to the specified chat
     * @param chatName string of the chat to join
     */
    public void joinChatRoom(String chatName);
}


public class ChatRoom_Model implements ChatRoom_Model_Interface, ViewSubject {
    private String chatName;
    private List<ViewObserver> observers = new LinkedList<ViewObserver>();
    private LinkedList<Message> msgs = new LinkedList<Message>(); 
    private LinkedList<User> users = new LinkedList<User>();

    /**
     * Constructs a new ChatRoom with a specified chat name
     * 
     * @param chatName a string of the chat room
     * @throws RuntimeException if the chat name is empty or already exists in the chat room list
     */
    public ChatRoom_Model(String chatName){
        if(chatName == null) return; //If chatname is null (user presses cancel), do nothing
        else if(chatName.isEmpty()) throw new RuntimeException("Chat name cannot be empty");
        else {
            for(ChatRoom_Model chat : ModelsFacade.getServers().getServerList()){
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
        ModelsFacade mf = ModelsFacade.getInstance();
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
    public ChatRoom_Model getChatRoomObj() {return this;}
    public LinkedList<Message> getMessages() {return this.msgs;}


}
