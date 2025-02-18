package models;

public class Message {
    private ModelsFacade mf = new ModelsFacade();
    private String msg;
    private String user;

    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.msg = msg;
            this.user = "seb"; //mf.getUser().getUsername();
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
