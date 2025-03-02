package server;

import java.io.*;
import java.net.*;
import models.*;

/**
 * Handles individual client connections.
 */
// filepath: /c:/Users/richa/Desktop/chatprogram/server/ClientManager.java
public class ClientManager implements Runnable {
    private Socket socket;
    private Server server;
    private ObjectOutputStream oout;
    private ObjectInputStream oin;

    public ClientManager(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            oout = new ObjectOutputStream(socket.getOutputStream());
            oout.flush();
            oin = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            sendChatHistory(); // Send chat history to the client when it connects

            Object message;
            while ((message = oin.readObject()) != null) {
                if (message instanceof ChatRoom_Model) {
                    server.addChatRoom((ChatRoom_Model) message);
                    server.broadcast(message, this);
                } else if (message instanceof Message_Interface) {
                    server.addMessage((Message_Interface) message);
                    server.broadcast(message, this);
                }
            }
        }catch (EOFException e) {
            System.out.println("Client disconnected."+ e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    } 

    private void sendChatHistory() {
        try {
            oout.writeObject(server.getServerList());
            oout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void sendMessage(Object message) {
        try {
            oout.writeObject(message);
            oout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (oin != null) oin.close();
            if (oout != null) oout.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}