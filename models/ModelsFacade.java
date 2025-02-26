package models;

public class ModelsFacade {
    private static ModelsFacade instance = new ModelsFacade();
    private ModelsFacade(){chatRoom = new ChatRoomModel(null);}
    public static ModelsFacade getInstance() {return instance;}

    private static User u = new User();
    private ChatRoomModel chatRoom;

    public static ServerListModel getServers() {return ServerListModel.getInstance();}
    public void createChatRoom(String name) {chatRoom = new ChatRoomModel(name);}
    public User getUser() {return u;}
    public void setChatRoom(ChatRoomModel chatRoom) {this.chatRoom = chatRoom;}
    public ChatRoomModel getChatRoom() {return chatRoom.getChatRoomObj();}
}
