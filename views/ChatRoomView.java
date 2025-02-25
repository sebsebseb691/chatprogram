package views;

import javax.swing.*;

/**
 * The {@code ChatRoomView} class represents the graphical user interface for a chat room.
 * It extends {@code JPanel} and implements the {@code View} interface.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Creating and displaying the chat room user interface</li>
 *   <li>Providing access to UI components for interaction</li>
 *   <li>Allowing removal of the chat room view</li>
 * </ul>
 */
public class ChatRoomView extends JPanel implements View {
    
    /** The main panel for the chatroom containing graphics elements . */
    private JPanel chatPanel = new JPanel();
    
    /** Label displaying the chat room name. */
    private JLabel chatname = new JLabel("Chatroom name");
    
    /** Text field for user input messages. */
    private JTextField messageField = new JTextField(30);
    
    /** Button to send messages. */
    private JButton sendButton = new JButton("Send");

    /**
     * Creates the chat room view by adding UI components to the panel.
     */
    public void createView() {
        chatPanel.add(chatname);
        chatPanel.add(messageField);
        chatPanel.add(sendButton);
        chatPanel.repaint();
    }

    /**
     * Removes all components from the chat panel and repaints it.
     */
    public void removeView() {
        chatPanel.removeAll();
        chatPanel.repaint();
    }

    /**
     * Returns the main chat panel.
     * 
     * @return the chat panel
     */
    public JPanel getJPanel() {
        return chatPanel;
    }

    /**
     * Returns the send button.
     * 
     * @return the send button component
     */
    public JButton getJButton() {
        return sendButton;
    }

    /**
     * Returns the text field responsible for messege input in chats.
     * 
     * @return the message text field
     */
    public JTextField getJTextField() {
        return messageField;
    }
}


//Lägg till observer som interface
//Implementera observer i chat
//Ska få uppdateringar