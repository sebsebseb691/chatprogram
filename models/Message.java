package models;

public class Message {
    private ModelsFacade mf = new ModelsFacade();
    private String msg;
    private String user;

    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.msg = msg;
            user = mf.getUser().getUsername();
        }

        //Ska meddelandet skickas direkt? Kanske ändra
        try {
            mf.getChatRoom().addMessage(this);
        } catch (Exception e) {
            // Visa meddelande i view, user är inte i något chatroom
        }
        
        //Testa meddelande 
        //System.out.println(user + ": " + this.msg);
    }
}
