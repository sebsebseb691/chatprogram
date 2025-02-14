package models;
import java.awt.*; 
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.io.*;
import java.lang.reflect.Array;
import java.util.LinkedList;


public class ChatRoom_m {
    
    int idnr; // måste få så alla id nummer blir olika vid skapande 
    LinkedList<Message> msgs = new LinkedList(); 
    LinkedList<user> users = new LinkedList();

    ChatRoom_m(){

        idnr = 1;  // eventeullt att man kör ett random generator 
    }

    public void addMessage(Message msg){
         
         msgs.add(msg); 

    }

    public void addUser(user u){

        users.add(u); 
    }

    public int getIdnr(){
        return idnr; 
    }
}
