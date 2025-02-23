package models;

public class ModelsFacade {
    private static ModelsFacade instance = new ModelsFacade();
    private ModelsFacade(){chatRoom = new ChatRoom_Model(null);}
    public static ModelsFacade getInstance() {return instance;}

    private static User u = new User();
    private ChatRoom_Model chatRoom;

    public static ServerList_Model getServers() {return ServerList_Model.getInstance();}
    public void createChatRoom(String name) {chatRoom = new ChatRoom_Model(name);}
    public User getUser() {return u;}
    public void setChatRoom(ChatRoom_Model chatRoom) {this.chatRoom = chatRoom;}
    public ChatRoom_Model getChatRoom() {return chatRoom.getChatRoomObj();}
}
