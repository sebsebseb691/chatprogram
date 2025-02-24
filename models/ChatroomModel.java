package models;
import java.util.LinkedList;


public class ChatroomModel {
    private String chatName;
    private LinkedList<Message> messageList = new LinkedList<Message>(); 
    private LinkedList<User> userList = new LinkedList<User>();

    public ChatroomModel(String chatName){
        if(chatName.isEmpty()) throw new RuntimeException("Chatname cannot be empty");
        else {this.chatName = chatName;}
    }

    public void addMessage(Message message){
        messageList.add(message);
    }

    public void joinChatRoom(){
        ModelsFacade modelsFacade = new ModelsFacade();
        //Only add user if it is not already in the chatroom
        if(!userList.contains(modelsFacade.getUser())) userList.add(modelsFacade.getUser());
    }

    public String getChatName() {return chatName;}
    public ChatroomModel getChatRoom() {return this;} 
}
