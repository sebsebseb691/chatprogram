package views;
import javax.swing.*;
import java.awt.*;

import models.ChatroomModel;
import models.ModelsFacade;
import models.ServerListModel;
import observers.ViewObserver;

/**
 * The {@code ServerListView} class represents the graphical user interface for displaying and managing the server list.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Displaying the list of available chat rooms</li>
 *   <li>Displayinng the options to join or create a new chat room</li>
 *   <li>Updating the list of servers displayed when new servers are added</li>
 * </ul>
 */
public class ServerListView extends JPanel implements View, ViewObserver {
    
    /** The main panel containing all components of the server list view. */
    private JPanel mainPanel = new JPanel(); 
    
    /** The panel that lists available chat rooms. */
    private JPanel serverListPanel = new JPanel(new GridLayout(0, 1));
    
    /** A welcome label for the user. */
    private JLabel welcome = new JLabel("Welcome");
    
    /** A label indicating chat room selection instructions. */
    private JLabel chatname = new JLabel("Press a Chat Room to join:");
    
    /** Button for joining a selected chat room. */
    private JButton joinButton = new JButton("Join");
    
    /** Button for creating a new chat room. */
    private JButton createServerButton = new JButton("Create a new server");

    /**
     * Initializes and arranges UI components for the server list view.
     */
    public void createView() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(welcome, BorderLayout.NORTH);
        mainPanel.add(chatname, BorderLayout.CENTER);
        serverListPanel.add(joinButton, BorderLayout.SOUTH);
        mainPanel.add(createServerButton, BorderLayout.SOUTH);

        serverListPanel.repaint();
        mainPanel.repaint(); 
    }

    /**
     * Creates the view and updates the welcome label with the given username.
     *
     * @param username the username to be displayed in the welcome message
     */
    public void createView(String username) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        welcome.setText(welcome.getText() + ": " + username);
        mainPanel.add(welcome);
        mainPanel.add(chatname);
        serverListPanel.add(joinButton, BorderLayout.SOUTH);
        mainPanel.add(createServerButton);

        serverListPanel.repaint();
        mainPanel.repaint();
    }

    /**
     * Removes all UI components from the view and repaints it.
     */
    public void removeView() {
        serverListPanel.removeAll();
        serverListPanel.repaint();
        mainPanel.removeAll();
        mainPanel.repaint();
    }

    /**
     * Updates the view when notified of changes to the server list.
     * Repaints the server list panel with available chat rooms.
     */
    public void update() {
        serverListPanel.removeAll();
        for (ChatroomModel chatRoom : ServerListModel.getInstance().getServerList()) {
            JButton chatLabel = new JButton("chatRoom");
            mainPanel.add(chatLabel);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        System.out.println("ServerListView has been updated.");
    }

    /**
     * Returns the main panel.
     * 
     * @return the main JPanel instance
     */
    public JPanel getJPanel() {return mainPanel;}
    
    /**
     * Returns the panel containing the list of servers.
     * 
     * @return the server list JPanel instance
     */
    public JPanel getServerPanel() {return serverListPanel;}
    
    /**
     * Returns the join button.
     * 
     * @return the join JButton instance
     */
    public JButton getJoinButton() {return joinButton;}
    
    /**
     * Returns the create server button.
     * 
     * @return the create server JButton instance
     */
    public JButton getCreateServerButton() {return createServerButton;}
}
