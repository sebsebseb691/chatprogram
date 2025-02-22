package controllers;
import javax.swing.JFrame;
import models.ModelsFacade;

public class ControllersFacade {
    //Kanske göra static?
    private JFrame f;
    private ChatRoom_c cr;
    
    public ControllersFacade() {
        f = new JFrame("Sigma chat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public JFrame getJFrame() {return f;}
    public ChatRoom_c getChatRoomController() {return cr;}

    //Navigator
    public void createChatRoom() {cr = new ChatRoom_c();}
    public void openChatRoom(ChatRoom_c chat) {chat.seeChatRoom();}
    public void openLoginPage() {LoginPage_c lp = new LoginPage_c();}
    public void openServerList() {ServerList_c sl = new ServerList_c();}
}
