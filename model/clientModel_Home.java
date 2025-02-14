import java.awt.*; 
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.io.*;
import java.lang.reflect.Array;
import java.util.LinkedList;


public class clientModel_Home {

    Linkedist<chatroom> chats = new Linkedist(); 

    public void addchatroom(chatroom chat){

        chats.add(chat); 
    }

    private void establish_con(){}// skapar websocket 

    private void get_all_chats(){} // i denna funktion kanske vi hämtar alla chatter från servern 

}
