public class Message {
    User u;
    private String msg;
    private String user;

    public Message(String msg) {
        this.msg = msg;
        user = u.getUsername();
    }
}
