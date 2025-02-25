package models;

/**
 * The {@code Message} class represents a chat message sent by a user.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Storing the message content and sender information</li>
 *   <li>Automatically adding the message to the user's current chat room</li>
 * </ul>
 */
public class Message {
    
    /** The facade for accessing model-related operations. */
    private ModelsFacade modelsFacade = new ModelsFacade();
    
    /** The content of the message. */
    private String message;
    
    /** The username of the sender. */
    private String sender;

    /**
     * Constructs a {@code Message} with the specified content.
     * The sender is automatically assigned based on the current user.
     * If the user is in a chat room, the message is added to it.
     * 
     * @param msg the message content
     * @throws RuntimeException if the message content is empty
     */
    public Message(String msg) {
        if (msg.isEmpty()) {
            throw new RuntimeException("Message cannot be empty");
        } else {
            this.message = msg;
            this.sender = modelsFacade.getUser().getUsername();
        }

        // Attempt to add the message to the current chat room
        try {
            modelsFacade.getChatRoom().addMessage(this);
        } catch (Exception e) {
            // Handle case where the user is not in a chat room
            // This could be improved by notifying the view
        }
    }
}
