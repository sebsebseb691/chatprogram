package models;

public class Message {
    private ModelsFacade ModelsFacade = new ModelsFacade();
    private User u = ModelsFacade.getUser();
    private String msg;
    private String user;

    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.msg = msg;
            user = u.getUsername();
        }

        //Ska meddelandet skickas direkt? Kanske ändra
        try {
            ModelsFacade.getChatRoom().addMessage(this);
        } catch (Exception e) {
            // Visa meddelande i view, user är inte i något chatroom
        }
        
        //Testa meddelande 
        //System.out.println(user + ": " + this.msg);
    }
}
