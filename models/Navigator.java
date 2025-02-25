package models;

/**
 * The {@code Navigator} class is responsible for managing navigation between different
 * application views by creating instances of the corresponding models.
 * 
 * <p>This class follows the Singleton pattern to ensure a single instance is used throughout the application.</p>
 */
public class Navigator {
    
    /** The single instance of the {@code Navigator} class. */
    private static Navigator instance = new Navigator();
    
    /**
     * Private constructor to prevent external instantiation.
     */
    private Navigator() {}
    
    /**
     * Returns the singleton instance of the {@code Navigator} class.
     * 
     * @return the single {@code Navigator} instance
     */
    public static Navigator getInstance() {
        return instance;
    }

    /**
     * Navigates to the login page by creating a new instance of {@code LoginPageModel}.
     */
    public void goToLoginPage() {
        LoginPageModel loginPageView = new LoginPageModel();
    }

    /**
     * Navigates to the server list through {@code ServerListModel}.
     *
     */ 
    public void goToServerList() {
        ServerListModel serverListView = new ServerListModel();
    }

    /**
     * Navigates to the chat room by creating a new instance of {@code ChatroomModel}.
     */
    public void goToChatRoom() {
        ChatroomModel chatRoomView = new ChatroomModel();
    }
}
