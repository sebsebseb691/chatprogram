package models;

public class Navigator {
    private static Navigator instance = new Navigator();
    private Navigator(){}
    public static Navigator getInstance() {return instance;}

// Ska inte dessa metoder uppdatera model bara?
    public void goToLoginPage() {
        LoginPageModel loginPageView = new LoginPageModel();
    }

    //Serverlist är singleton
    public void goToServerList() {
        ServerListModel serverListView = new ServerListModel();
    }


    public void goToChatRoom() {
        ChatroomModel chatRoomView = new ChatroomModel();
    }
}
