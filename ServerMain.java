import server.*;

/**
 * Main class for the server.
 */

public class ServerMain {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.start(54321);
    }
}