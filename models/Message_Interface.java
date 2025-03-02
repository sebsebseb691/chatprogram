package models;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public interface Message_Interface extends Serializable {
    /**
     * Gets the message content.
     *
     * @return a string of the message
     */
    public String getMsg();

    /**
     * Gets the username of the user who sent a message
     *
     * @return the username of who sent the message as a string
     */
    public String getUser(); 

    public BufferedImage getImage(); 


    public String getChatRoomName(); 
}
