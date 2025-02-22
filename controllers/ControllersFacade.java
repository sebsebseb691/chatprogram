package controllers;
import javax.swing.JFrame;

//Kanske göra static? och bara så en controller för respektive grej skapas, för allt på panelen uppdateras när en ny skapas
public class ControllersFacade {
    private JFrame f;
    
    public ControllersFacade() {
        f = new JFrame("Sigma chat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getJFrame() {return f;}

    //Navigator
    public void openChatRoom() {
        ChatRoom_Controller cr = new ChatRoom_Controller();
        cr.addPanelToFrame();
    }

    public void openLoginPage() {
        LoginPage_Controller lp = new LoginPage_Controller();
        lp.addPanelToFrame();
    }

    public void openServerList() {
        ServerList_Controller sl = new ServerList_Controller();
        sl.addPanelToFrame();
    }
}
