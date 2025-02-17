package models;

public class Navigator {
    private static Navigator instance = new Navigator();
    private Navigator(){}
    public static Navigator getInstance() {return instance;}


    public void goToLoginPage() {
        LoginPage_m lp = new LoginPage_m();
    }

    //Serverlist är singleton
    public void goToServerList() {
        ServerList_m sl = new ServerList_m();
    }


    public void goToChatRoom() {
        ChatRoom_m cr = new ChatRoom_m();
    }
}
