package models;

public class ModelsFacade {
    private static User u = new User();
    private ChatRoom_m chatRoom = new ChatRoom_m("Chat room");
    private ServerList_m servers = ServerList_m.getInstance();

    public User getUser() {return u;}
    public ServerList_m getServers() {return servers;}
    public ChatRoom_m getChatRoom() {return chatRoom;}
    public void setChatRoom(ChatRoom_m chatRoom) {this.chatRoom = chatRoom;}
}
