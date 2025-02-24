package models;

public class ModelsFacade {
    private static User user = new User();
    private ChatroomModel chatRoom = new ChatroomModel("test");
    private ServerListModel servers = ServerListModel.getInstance();

    public User getUser() {return user;}
    public ServerListModel getServers() {return servers;}
    public ChatroomModel getChatRoom() {return chatRoom;}
}
