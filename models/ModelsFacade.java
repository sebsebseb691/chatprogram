package models;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


/**
 * Facade for all models
 * Used to access all models and handle the communication between them
 */
public class ModelsFacade {
    private static ModelsFacade instance = new ModelsFacade();
    private ChatRoomModel currentChatRoom;
    private static Client client; 
    private boolean isProcessingLocal = false;
    private static User u = new User();

    private ModelsFacade() {
        client = Client.getInstance();
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
        client.send(chatRoom); 
    }

    public void addChatRoomFromServer(ChatRoomModel chatRoom) {
        isProcessingLocal = true;
        getServers().addChatRoom(chatRoom);
        isProcessingLocal = false;
    }

    public void createChatRoom(String chatRoomName) {
        ChatRoomModel newChatRoom = new ChatRoomModel(chatRoomName);
        addChatRoom(newChatRoom);
    }

    public void createMessage(String text, String sender, String chatRoomName) {
        Message m = new Message(text, sender, chatRoomName);
        getChatRoom().addMessage(m);
        getClient().send(m);
    }

    public void createImage(File imageFile, String chatRoomName, String user) {
        try {
            Image i = new Image(imageFile, chatRoomName, user);
            getChatRoom().addMessage(i);
            getClient().send(i);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static HomePageModel getServers() {return HomePageModel.getInstance();}
    public static ModelsFacade getInstance() {return instance;}
    public ChatRoomModel getChatRoom() {return currentChatRoom;}
    public void setChatRoom(ChatRoomModel chatRoom) {this.currentChatRoom = chatRoom;}
    public User getUser() {return u;}
    public Client getClient() {return client;}
}