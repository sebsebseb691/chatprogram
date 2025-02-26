package models;



public class ModelsFacade {
    private static ModelsFacade instance = new ModelsFacade();
    private ChatRoom_Model currentChatRoom;

    private ModelsFacade() {}

    public static User u = new User();

    public static ModelsFacade getInstance() {
        return instance;
    }

    public static ServerList_Model getServers() {return ServerList_Model.getInstance();}

    public ChatRoom_Model getChatRoom() {
        return currentChatRoom;
    }

    public void setChatRoom(ChatRoom_Model chatRoom) {
        this.currentChatRoom = chatRoom;
    }

    public ChatRoom_Model getChatRoomByName(String chatName) {
        for (ChatRoom_Model chatRoom : getServers().getServerList()) {
            if (chatRoom.getChatName().equals(chatName)) {
                return chatRoom;
            }
        }
        return null;
    }

    public void addChatRoom(ChatRoom_Model chatRoom) {
        getServers().addChatRoom(chatRoom);
    }

    public User getUser() {
        return u;
    }
}