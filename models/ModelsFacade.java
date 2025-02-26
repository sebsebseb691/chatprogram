package models;

/**
 * ModelsFacade manages access to the core models. Providing a centralized way 
 * to retrive user, chatroom and server list.
 */
public class ModelsFacade {
    private static User u = new User();
    private ChatRoom_m chatRoom = new ChatRoom_m("Chat room");
    private ServerList_m servers = ServerList_m.getInstance();

    // get methods for user, server, chatroom
    public User getUser() {return u;}
    public ServerList_m getServers() {return servers;}
    public ChatRoom_m getChatRoom() {return chatRoom;}

    // set method for chatroom
    public void setChatRoom(ChatRoom_m chatRoom) {this.chatRoom = chatRoom;}
}