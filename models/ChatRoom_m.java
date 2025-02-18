package models;
import java.util.LinkedList;


public class ChatRoom_m {
    private String chatName;
    private LinkedList<Message> msgs = new LinkedList<Message>(); 
    private LinkedList<User> users = new LinkedList<User>();

    public ChatRoom_m(String chatName){
        if(chatName == null) return; //If chatname is null (user presses cancel), do nothing
        else if(chatName.isEmpty()) throw new RuntimeException("Chatname cannot be empty");
        else {this.chatName = chatName;}
    }

    public void addMessage(Message msg){
        msgs.add(msg);
    }

    public void joinChatRoom(){
        ModelsFacade mf = new ModelsFacade();
        //Only add user if it is not already in the chatroom
        if(!users.contains(mf.getUser())) users.add(mf.getUser());
    }

    public String getChatName() {return chatName;}
    public ChatRoom_m getChatRoom() {return this;} 
}
