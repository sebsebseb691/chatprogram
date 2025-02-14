import java.awt.*; 
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.io.*;
import java.lang.reflect.Array;
import java.util.LinkedList; 


public class chatroom {
    
    int idnr; // måste få så alla id nummer blir olika vid skapande 
    Linkedlist<message> msgs = new LinkedList(); 
    Linkedist<user> users = new LinkedList();

    chatroom(){

        idnr = 1;  // eventeullt att man kör ett random generator 
    }

    public void addMessage(message msg){
         
         msgs.add(msg); 

    }

    public void addUser(user u){

        users.add(u); 
    }

    public int getIdnr(){
        return idnr; 
    }
}
