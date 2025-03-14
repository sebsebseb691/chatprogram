package models;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Represents both a text-message and image-message
 * Contains message as text, user that sent the message, name of the chat room it belongs to and an image if there is one
 */
public interface MessageInterface extends Serializable {
    /**
     * Gets the message content
     * @return a string of the message
     */
    public String getMsg();

    /**
     * Gets the username of the user who sent a message
     * @return the username of who sent the message as a string
     */
    public String getUser(); 

    /**
     * Get the sent image
     * @return the image as a buffered image
     */
    public BufferedImage getImage(); 

    /**
     * Get the name of the chat room the message belongs to
     * @return string of the chat room name
     */
    public String getChatRoomName(); 
}
