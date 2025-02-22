package models;

public class ModelsFacade {
    private static ModelsFacade instance = new ModelsFacade();
    private ModelsFacade(){
        chatRoom = new ChatRoom_m(null);
    }
    public static ModelsFacade getInstance() {return instance;}

    private static User u = new User();
    private ChatRoom_m chatRoom;
    private ServerList_m servers = ServerList_m.getInstance();

    public void createChatRoom(String name) {
        chatRoom = new ChatRoom_m(name);
    }
    public User getUser() {return u;}
    public ServerList_m getServers() {return servers;}
    public void setChatRoom(ChatRoom_m chatRoom) {this.chatRoom = chatRoom;}
    public ChatRoom_m getChatRoom() {return chatRoom.getChatRoomObj();}
}
