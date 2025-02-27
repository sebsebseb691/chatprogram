package server;

import java.io.*;
import java.net.*;
import java.util.*;

import models.*;

/**
 * Responsible for running the server, while listening on a specified port and accepting new connections.
 */
public class Server {
    static Server instance;
    ServerSocket server;
    ArrayList<ServerList_m> list = new ArrayList<ServerList_m>();       //lista över chattrum

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
                        ClientManager clientManager = new ClientManager(clientSocket, Server.this);     // skapa clientManager för den som ansluter på servern
                        clientManagers.add(clientManager);      // lägger till clientManager:n på vår lista
                        
                        new Thread(clientManager).start();      // skapar egen tråd för varje klient
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

    // get method clients in array
    public boolean isConnected(ClientManager clientManager) {
        synchronized (clientManagers) {
            return clientManagers.contains(clientManager);
        }
    }
    // removes disconnected clients from chat
    public void disconnect(ClientManager clientManager) {
        clientManagers.remove(clientManager);
        System.out.println("Client:" + clientManager + " has disconnected.");
    }

}