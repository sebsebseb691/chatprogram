package models;
import java.awt.image.BufferedImage;


public class Message implements MessageInterface {
    private static final long serialVersionUID = 1L; // Add a serialVersionUID for better serialization control
    private String text;
    private String sender;
    private String chatRoomName;


    public Message(String text, String sender, String chatRoomName) {
        if (text.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.text = text;
            this.sender = sender;
            this.chatRoomName = chatRoomName;
        }
    }

    @Override
    public String getMsg() {return this.text;}
    @Override
    public String getUser() {return this.sender;}
    @Override
    public String getChatRoomName() {return this.chatRoomName;}
    @Override
    public BufferedImage getImage() {return null;}
}