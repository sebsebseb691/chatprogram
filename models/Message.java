package models;

public class Message {
    private ModelsFacade modelsFacade = new ModelsFacade();
    private String message;
    private String sender;

    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.message = msg;
            this.sender = modelsFacade.getUser().getUsername();
        }

        //Ska meddelandet skickas direkt? Kanske ändra
        try {
            modelsFacade.getChatRoom().addMessage(this);
        } catch (Exception e) {
            // Visa meddelande i view, user är inte i något chatroom
        }
        
        //Testa meddelande 
        //System.out.println(user + ": " + this.msg);
    }
}
