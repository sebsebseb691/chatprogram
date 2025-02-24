package server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Responsible for running the server, while listening on a specified port and accepting new connections.
 */
public class Server {
    static Server instance;
    ServerSocket server;

    ArrayList<Socket> clients = new ArrayList<>();
    int port = 54321;       // can it be fixed??

    // initiate server on specified port
    private Server() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server connected on port: " + port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // makes sure only one instance exists of server, follow Singleton pattern
    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    // awaits attempted connections
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Socket clientSocket = server.accept();
                        clients.add(clientSocket);
                        new Thread(new ClientManager(clientSocket, Server.this)).start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }).start();
    }

    // broadcast the message to groupmembers
    public void broadcast(String message) {
        for (Socket clientSocket : clients) {       // future feature: if(clientSocket != sender) don't duplicate message
            try { 
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // removes disconnected clients from chat
    public void disconnect(Socket client) {
        clients.remove(client);
        System.out.println(client + " has disconnected.");
    }
}