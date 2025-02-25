package controllers;

import javax.swing.*;
import java.awt.event.*;
import models.*;
import views.ServerListView; 

/**
 * The {@code ServerListController} class manages user interactions with the server list view.
 * It serves as the controller in the MVC pattern, handling actions related to
 * joining and creating chat rooms.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Displaying the server list </li>
 *   <li>Handling user interactions for joining and creating chat rooms</li>
 *   <li>Updating the server list based on user actions</li>
 * </ul>
 */
public class ServerListController extends JFrame implements ActionListener {
    
    private ControllersFacade controllersFacade = new ControllersFacade();
    private ServerListModel serverListModel = ServerListModel.getInstance();
    private ModelsFacade modelsFacade = new ModelsFacade();
    private ServerListView serverListView = new ServerListView();

    private JFrame applicationWindow = controllersFacade.getJFrame();
    private JFrame chatroomWindow = controllersFacade.getJFrame();
    
    
    
    /**
     * Handles action events for this controller.
     * 
     * @param e the action event triggered by user interaction
     */
    public void actionPerformed(ActionEvent e) {}

    /**
     * Constructs a {@code ServerListController} and initializes the server list UI.
     * Sets up the view and registers it as an observer of the server list model.
     */
    public ServerListController() {
        applicationWindow.setSize(800, 300);
        serverListView.createView(modelsFacade.getUser().getUsername());
        serverListModel.addObserver(serverListView);
        applicationWindow.add(serverListView.getJPanel());
        applicationWindow.setVisible(true);
    
        addListenerServerList();
    }

    /**
     * Adds action listeners to the server list view's buttons.
     * Handles user interactions for joining and creating chat rooms.
     */
    public void addListenerServerList() {
        serverListView.getJoinButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to join chatroom
                // modelsFacade.getServerList().chats.
            }
        });
        
        serverListView.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to create a new chatroom
                chatroomWindow.setSize(150, 150);
                chatroomWindow.setVisible(true);
                ChatroomModel newChat = new ChatroomModel("New Chatroom");
                serverListModel.createServer(newChat); // Notifies model of the change 
            }
        });

        serverListView.getJoinButton().removeActionListener(this);
    }
}
