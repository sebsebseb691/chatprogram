package models;
import java.util.LinkedList;


public class ChatRoom_m {
    
    int idnr; // måste få så alla id nummer blir olika vid skapande 
    LinkedList<Message> msgs = new LinkedList(); 
    LinkedList<User> users = new LinkedList();

    ChatRoom_m(){
        idnr = 1;  // eventeullt att man kör ett random generator 
    }

    public void addMessage(Message msg){
        msgs.add(msg); 

    }

    public void addUser(User u){
        users.add(u); 
    }

    public int getIdnr(){
        return idnr; 
    }
}
