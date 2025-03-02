package models;

import java.util.LinkedList;

public class ModelsFacade {
    private static ModelsFacade instance = new ModelsFacade();
    private ChatRoomModel currentChatRoom;
    private static Client c; 
    private boolean isProcessingLocal = false;

    private ModelsFacade() {
     c = Client.getInstance();
    }

    public static User u = new User();

    public static ModelsFacade getInstance() {
        return instance;
    }

    public static ServerListModel getServers() {return ServerListModel.getInstance();}

    public ChatRoomModel getChatRoom() {
        return currentChatRoom;
    }

    public void setChatRoom(ChatRoomModel chatRoom) {
        this.currentChatRoom = chatRoom;
    } 

    public void setChatRoomsList(LinkedList<ChatRoomModel> chatRoomsList) {

        getServers().getServerList().clear();
        for (ChatRoomModel chatRoom : chatRoomsList) {
            getServers().addChatRoom(chatRoom);
        }

    }

    public ChatRoomModel getChatRoomByName(String chatName) {
        for (ChatRoomModel chatRoom : getServers().getServerList()) {
            if (chatRoom.getChatName().equals(chatName)) {
                return chatRoom;
            }
        }
        return null;
    }

    public void addChatRoom(ChatRoomModel chatRoom) { 
        if(isProcessingLocal) return;
        getServers().addChatRoom(chatRoom);
        c.send(chatRoom); 

    }

    public void addChatRoomFromServer(ChatRoomModel chatRoom) {
        isProcessingLocal = true;
        getServers().addChatRoom(chatRoom);
        isProcessingLocal = false;
    }
    

    public User getUser() {
        return u;
    }

    public Client getClient() {
        return c;
    }
}