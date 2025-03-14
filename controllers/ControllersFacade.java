package controllers;
import javax.swing.JFrame;

/**
 * Facade for controllers, used in controllers to accces JFrame
 * Navigator part used to open different "windows" in the application
 */
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
        HomePageController sl = new HomePageController();
        sl.addPanelToFrame();
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
