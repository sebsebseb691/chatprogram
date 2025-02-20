package controllers;
import javax.swing.JFrame;

import models.ChatRoom_m;
import models.ModelsFacade;

public class ControllersFacade {
    //Kanske göra static?
    private JFrame f;
    
    public ControllersFacade() {
        f = new JFrame("Sigma chat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public JFrame getJFrame() {return f;}

    //Navigator, ska det vara egen klass?
    public void openChatRoom() {ChatRoom_c cr = new ChatRoom_c(ModelsFacade.getInstance().getChatRoom().getChatRoomView());}
    public void openLoginPage() {LoginPage_c lp = new LoginPage_c();}
    public void openServerList() {ServerList_c sl = new ServerList_c();}
}
