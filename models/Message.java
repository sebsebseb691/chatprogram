package models;

/**
 * Interface for creating a message 
 */
interface MessageInterface {
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
}

public class Message {
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
}
