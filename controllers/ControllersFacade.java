package controllers;
import javax.swing.JFrame;
import views.*;


//Kanske göra static? och bara så en controller för respektive grej skapas, för allt på panelen uppdateras när en ny skapas
//och slippa new ChatRoom_View i controller tex
public class ControllersFacade {
    private JFrame f;

    
    public ControllersFacade() {
        f = new JFrame("Sigma chat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getJFrame() {return f;}


    //Navigator
    public void openChatRoom() {
        removeAllViews();
        ChatRoom_Controller cr = new ChatRoom_Controller();
        cr.addPanelToFrame();
    }

    public void openLoginPage() {
        removeAllViews();
        LoginPage_Controller lp = new LoginPage_Controller();
        lp.addPanelToFrame();
    }

    public void openServerList() {
        removeAllViews();
        ServerList_Controller sl = new ServerList_Controller();
        sl.addPanelToFrame();
    }

    /**
     * Remove panel from the frame, used to clear frame when opening a new "window" 
     */
    private void removeAllViews() {
        f.getContentPane().removeAll();
        f.setVisible(false);
        f.repaint();
    }
}
