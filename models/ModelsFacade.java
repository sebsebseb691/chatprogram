package models;

/**
 * The {@code ModelsFacade} class provides a centralized access point for managing
 * key model components of the application.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Providing access to the current user</li>
 *   <li>Managing the active chat room</li>
 *   <li>Managing the list of available servers</li>
 * </ul>
 */
public class ModelsFacade {
    
    /** The current user of the application. */
    private static User user = new User();
    
    /** The active chat room instance. */
    private ChatroomModel chatRoom = new ChatroomModel("test");
    
    /** The list of available servers. */
    private ServerListModel servers = ServerListModel.getInstance();

    /**
     * Returns the current user instance.
     * 
     * @return the {@code User} object representing the current user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the list of available servers.
     * 
     * @return the {@code ServerListModel} instance managing the server list
     */
    public ServerListModel getServers() {
        return servers;
    }

    /**
     * Returns the active chat room instance.
     * 
     * @return the {@code ChatroomModel} representing the current chat room
     */
    public ChatroomModel getChatRoom() {
        return chatRoom;
    }
}
