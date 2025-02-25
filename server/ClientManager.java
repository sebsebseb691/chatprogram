package server;

import java.io.*;
import java.net.*;
import models.Message;

/**
 * Handles individual client connections.
 */
public class ClientManager implements Runnable {
    
    private final Server server;
    private final Socket clientSocket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    // initiate the clientmanager
    public ClientManager(Socket clientSocket, Server server) throws IOException {      // future feature: add user/username??
        this.clientSocket = clientSocket;
        this.server = server;

        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
    }

    // creates a continius connection while in chatroom
    @Override
    public void run() {
        try{
            Object message;

            while ((message = in.readObject()) != null) {
                if (message instanceof Message) {
                    server.broadcast(message, this);       // 'this' funkar ibland och plötsligt inte
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            server.disconnect(this);       // 'this'
        }
    }

    // method for sending messages
    public void sendMessage(Object message) {
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
          }
    }
    

}