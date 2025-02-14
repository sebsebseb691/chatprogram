package models;

public class Message {
    ModelsFascade ModelsFascade = new ModelsFascade();
    User u = ModelsFascade.getUser();
    private String msg;
    private String user;

    public Message(String msg) {
        if (msg.isEmpty()) throw new RuntimeException("Message cannot be empty");
        else {
            this.msg = msg;
            user = u.getUsername();
        }
        System.out.println(user + ": " + this.msg);
    }
}
