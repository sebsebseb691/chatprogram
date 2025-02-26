package controllers;

import javax.swing.JFrame;

/**
 * Facade for managing and navigating between different controllers in the application.
 * Initializes the main application window and provides methods to open different views.
 */
public class ControllersFacade {
    
    private JFrame f;       //Kanske göra static?
    
    // constructor for controllers facade
    public ControllersFacade() {
        f = new JFrame("Sigma chat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public JFrame getJFrame() {return f;}

    // methods for opening different views by creating a new instance of the respective controller
    public void openChatRoom() {ChatRoom_c cr = new ChatRoom_c();}
    public void openLoginPage() {LoginPage_c lp = new LoginPage_c();}
    public void openServerList() {ServerList_c sl = new ServerList_c();}
}
