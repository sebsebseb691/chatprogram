import server.*;

//Run this class to start the server
public class ServerStart {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.start(54321);
    }
}