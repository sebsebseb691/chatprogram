package models;

public class ModelsFacade {
    private static User u = new User(); //Funkar tydligen bara om man har static
    private static ChatRoom_m chatRoom = new ChatRoom_m("test"); //Måste initiera ett chatroom, vet inte hur jag ska komma förbi det
    private static ServerList_m servers = ServerList_m.getInstance();

    public static User getUser() {return u;}
    public static ServerList_m getServers() {return servers;}
    public static ChatRoom_m getChatRoom() {return chatRoom;}
}
