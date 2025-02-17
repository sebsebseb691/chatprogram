package models;
import java.util.LinkedList;


public class ServerList_m {
    private LinkedList<ChatRoom_m> serverList = new LinkedList<ChatRoom_m>();
    
    //Singleton
    private static ServerList_m instance = new ServerList_m();
    private ServerList_m(){}
    public static ServerList_m getInstance() {return instance;}
    public static LinkedList<ChatRoom_m> getServerList() {return instance.serverList;}

    public void createServer(ChatRoom_m chat){
        serverList.add(chat); 
    }

    private void establish_con(){}// skapar websocket 

    private void get_all_chats(){} // i denna funktion kanske vi hämtar alla chatter från servern 
}
