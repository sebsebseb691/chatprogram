package models;

public class ModelsFacade {
    private static User u = new User();
    private ChatRoom_m chatRoom = new ChatRoom_m("test");
    private ServerList_m servers = ServerList_m.getInstance();

    public User getUser() {return u;}
    public ServerList_m getServers() {return servers;}
    public ChatRoom_m getChatRoom() {return chatRoom;}
}
