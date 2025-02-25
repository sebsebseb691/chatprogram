package controllers;

import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.Message;
import views.ChatRoomView;

/**
 * The {@code ChatRoomController} class handles user interactions within a chat room.
 * It acts as a controller in the MVC architecture, managing the communication between 
 * the {@code ChatRoomView} and the {@code ChatRoomModel}.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Initializing the chat room window</li>
 *   <li>Handling user interactions, such as sending messages</li>
 *   <li>Removing the chat room from the display when necessary</li>
 * </ul>
 * 
 */
public class ChatRoomController extends JFrame implements ActionListener {
    
    private ControllersFacade controllersFacade = new ControllersFacade();
    private ModelsFacade modelsFacade = new ModelsFacade();
    private ChatRoomView chatRoomView = new ChatRoomView();
    
    /** The shared application frame used for displaying the window. */
    private JFrame universalFrame = controllersFacade.getJFrame();
    
     /**
     * Handles action events for this controller.
     *
     * @param e the action event triggered by user interaction
     */
    public void actionPerformed(ActionEvent e) {}

    /**
     * Initializes the chat room by setting up the view and adding listeners.
     * The chat room UI is displayed within the application's main frame.
     */
    public ChatRoomController() {
        universalFrame.setSize(600, 300);
        chatRoomView.createView();
        universalFrame.add(chatRoomView.getJPanel());
        universalFrame.setVisible(true);
    
        addListenerChatRoom();
    }

    /**
     * Adds an action listener to the chat room's send button.
     * When clicked, it creates a new message using the user's input.
     */
    public void addListenerChatRoom() {
        chatRoomView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(chatRoomView.getJTextField().getText());
            }
        });
    }

    /**
     * Removes the chat room from the display.
     * Unregisters listeners and hides the chat room window.
     */
    public void removeChatRoom() {
        chatRoomView.getJButton().removeActionListener(this);
        universalFrame.remove(chatRoomView.getJPanel());
        universalFrame.setVisible(false);
    }

}
