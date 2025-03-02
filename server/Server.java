package server;

import java.io.*;
import java.net.*;
import java.util.*;

import models.ChatRoom_Model;
import models.Message_Interface;

/**
 * Responsible for running the server, while listening on a specified port and accepting new connections.
 */
public class Server {
    private ServerSocket serverSocket;
    private List<ClientManager> clientManagers = new ArrayList<>();
    private LinkedList<ChatRoom_Model> serverList = new LinkedList<ChatRoom_Model>();

    private static Server instance = new Server();
    private Server(){}
    public static Server getInstance() {return instance;}

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Server started on IP: " + ip.getHostAddress() + " Port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(clientSocket, this);
                clientManagers.add(clientManager);
                new Thread(clientManager).start();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(Object message, ClientManager sender) {
        for (ClientManager clientManager : clientManagers) {
            if (clientManager != sender) {
                clientManager.sendMessage(message);
            }
        }
    }

    public void addChatRoom(ChatRoom_Model chatRoom) { 
        // Add chat room to the server's list
        serverList.add(chatRoom);
       
    }

    

    public void addMessage (Message_Interface msg) {
        // Add message to the chat room
       for(ChatRoom_Model chatRoom : serverList){
           if(chatRoom.getChatName().equals(msg.getChatRoomName())){
               chatRoom.addMessage(msg);
           }
        
         }
    }
}
