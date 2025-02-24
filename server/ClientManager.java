package server;

import java.io.*;
import java.net.*;

/**
 * Handles individual client connections.
 */
public class ClientManager implements Runnable {
    private final Socket clientSocket;
    private final Server server;

    // initiate the clientmanager
    public ClientManager(Socket clientSocket, Server server) {      // future feature: add user/username??
        this.clientSocket = clientSocket;
        this.server = server;
    }

    // creates a continius connection while in chatroom
    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
            String message;

            while ((message = in.readLine()) != null) {
                System.out.println(message);
                server.broadcast(message);          // broadcast message, change to fit in with the rest of the program
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            server.disconnect(clientSocket);
        }
    }
}