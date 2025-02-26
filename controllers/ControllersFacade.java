package controllers;
import javax.swing.JFrame;


//Kanske göra static? och bara så en controller för respektive grej skapas, för allt på panelen uppdateras när en ny skapas
//och slippa new ChatRoom_View i controller tex
public class ControllersFacade {
    private JFrame frame;

    
    public ControllersFacade() {
        frame = new JFrame("Sigma chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getJFrame() {return frame;}


    //Navigator
    public void openChatRoom() {
        removeAllViews();
        ChatRoom_Controller chatRoomController = new ChatRoom_Controller();
        chatRoomController.addPanelToFrame();
    }

    public void openLoginPage() {
        removeAllViews();
        LoginPage_Controller loginPageController = new LoginPage_Controller();
        loginPageController.addPanelToFrame();
    }

    public void openServerList() {
        removeAllViews();
        ServerList_Controller serverListController = new ServerList_Controller();
        serverListController.addPanelToFrame();
    }

    /**
     * Remove panel from the frame, used to clear frame when opening a new "window" 
     */
    private void removeAllViews() {
        frame.getContentPane().removeAll();
        frame.setVisible(false);
        frame.repaint();
    }
}
