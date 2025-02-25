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

    ArrayList<ClientManager> clientManagers = new ArrayList<>();
    int port = 54321;

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
                while (!server.isClosed() ) {
                    try {
                        Socket clientSocket = server.accept();
                        ClientManager clientManager = new ClientManager(clientSocket, Server.this);
                        clientManagers.add(clientManager);
                        
                        new Thread(clientManager).start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                      }
                }
            }
        }).start();
    }

    // broadcast the message to groupmembers
    public void broadcast(Object message, ClientManager clientManager) {
        synchronized (clientManagers) {
            for (ClientManager client : clientManagers) {
                if(client != clientManager){
                    client.sendMessage(message);        //vill ändra
                }

            }
        }
    }

    // removes disconnected clients from chat
    public void disconnect(ClientManager clientManager) {
        clientManagers.remove(clientManager);
        System.out.println("Client:" + clientManager + " has disconnected.");
    }
}