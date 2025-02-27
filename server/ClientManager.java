package server;

import java.io.*;
import java.net.*;
import models.*;

/**
 * Handles individual client connections.
 */
public class ClientManager implements Runnable {
    
    private final Server server;
    private final Socket clientSocket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    // constructor
    public ClientManager(Socket clientSocket, Server server) throws IOException {      // future feature: add user/username??
        this.clientSocket = clientSocket;
        this.server = server;

        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
    }

    // close connection
    public void close() {
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            
            System.out.println("Client connecion is closed.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // creates a continius connection while in chatroom
    @Override
    public void run() {
        try {
            Object message;
            while ((message = in.readObject()) != null) {

                if (!server.isConnected(this)) {
                    System.out.println("Client already disconnected.");
                    close();
                    break;
                }
                
                if (message instanceof Message) {
                    System.out.println("Broadcasting message from: " + this);
                    server.broadcast(message, this);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            close();
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