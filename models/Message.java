package models;
import java.awt.image.BufferedImage;


public class Message implements Message_Interface {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private String msg;
    private String user; //Hade kunnat spara user som user objekt, men kanske lägre koppling om det är string

    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.msg = msg;
            this.user = mf.getUser().getUsername();
        }

        try {
            mf.getChatRoom().addMessage(this);
        } catch (Exception e) {
            throw new RuntimeException("You need to join a chatroom to send messages");
        }
    }

    public String getMsg() {return this.msg;}
    public String getUser() {return this.user;}
    public BufferedImage getImage(){return null;}
}
