package controllers;
import javax.swing.JFrame;


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
        ChatRoomController cr = new ChatRoomController();
        cr.addPanelToFrame();
    }

    public void openLoginPage() {
        removeAllViews();
        LoginPageController lp = new LoginPageController();
        lp.addPanelToFrame();
    }

    public void openServerList() {
        removeAllViews();
        ServerListController sl = new ServerListController();
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
