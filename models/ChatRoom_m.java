package models;
import java.util.LinkedList;


public class ChatRoom_m {
    private String chatName;
    private LinkedList<Message> msgs = new LinkedList(); 
    private LinkedList<User> users = new LinkedList();

    public ChatRoom_m(String chatName){
        if(chatName.isEmpty()) throw new RuntimeException("Chatname cannot be empty");
        else {this.chatName = chatName;}
    }

    public void addMessage(Message msg){
        msgs.add(msg);
    }

    public void joinChatRoom(){
        //Only add user if it is not already in the chatroom
        if(!users.contains(ModelsFacade.getUser())) users.add(ModelsFacade.getUser());
    }

    public String getChatName() {return chatName;}
    public ChatRoom_m getChatRoom() {return this;} 
}
