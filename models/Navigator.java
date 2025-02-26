package models;

/**
 * Navigator is a singleton class responsible for navigating between different models.
 */
public class Navigator {
    private static Navigator instance = new Navigator();
    
    // constructor
    private Navigator(){}
    public static Navigator getInstance() {return instance;}

    // navigates to Login page 
    public void goToLoginPage() {
        LoginPage_m lp = new LoginPage_m();
    }

    // navigates to Server list
    public void goToServerList() {           //Serverlist är singleton
        ServerList_m sl = new ServerList_m();
    }

    // navigates to Chatroom
    public void goToChatRoom() {
        ChatRoom_m cr = new ChatRoom_m();
    }
}
