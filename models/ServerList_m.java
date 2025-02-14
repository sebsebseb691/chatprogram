package models;

import java.util.LinkedList;


public class ServerList_m {

    LinkedList<ChatRoom_v> chats = new LinkedList(); 

    public void addchatroom(ChatRoom_v chat){

        chats.add(chat); 
    }

    private void establish_con(){}// skapar websocket 

    private void get_all_chats(){} // i denna funktion kanske vi hämtar alla chatter från servern 

}
