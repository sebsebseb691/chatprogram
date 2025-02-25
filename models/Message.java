package models;

import java.io.Serializable;

public class Message implements Serializable {
    private ModelsFacade mf = new ModelsFacade();
    private String msg;
    private String user;

    // empty message constructor
    public Message() {

    }

    // constructor with message
    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");   // message can be empty??
        else {
            this.msg = msg;
            this.user = mf.getUser().getUsername();
        }

        //Ska meddelandet skickas direkt? Kanske ändra
        try {
            mf.getChatRoom().addMessage(this);
        } catch (Exception e) {
            //User is not in a chat room
            throw new RuntimeException("You need to join a chatroom to send messages");
        }
    }

    public String getMsg() {return this.msg;}
    public String getUser() {return this.user;}
}
