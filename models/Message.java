package models;
import java.awt.image.BufferedImage;


public class Message implements MessageInterface {
    private static final long serialVersionUID = 1L; // Add a serialVersionUID for better serialization control
    private String msg;
    private String user;
    private String chatRoomName;


    public Message(String msg, String user, String chatRoomName) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.msg = msg;
            this.user = user;
            this.chatRoomName = chatRoomName;
        }
    }

    @Override
    public String getMsg() {return this.msg;}
    @Override
    public String getUser() {return this.user;}
    @Override
    public String getChatRoomName() {return this.chatRoomName;}
    @Override
    public BufferedImage getImage() {return null;}
}