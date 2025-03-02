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
    private static final String HISTORY_FILE = "chat_history.ser";

    private static Server instance = new Server();
    private Server() {}
    public static Server getInstance() { return instance; }

    public void start(int port) {
        loadChatHistory(); // Load chat history when the server starts
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
        serverList.add(chatRoom);
        saveChatHistory(); // Save chat history whenever a new chat room is added
    }

    public void addMessage(Message_Interface msg) {
        for (ChatRoom_Model chatRoom : serverList) {
            if (chatRoom.getChatName().equals(msg.getChatRoomName())) {
                chatRoom.addMessage(msg);
                saveChatHistory(); // Save chat history whenever a new message is added
                break;
            }
        }
    }

    private void saveChatHistory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HISTORY_FILE))) {
            oos.writeObject(serverList);
            System.out.println("Chat history saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatHistory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HISTORY_FILE))) {
            serverList = (LinkedList<ChatRoom_Model>) ois.readObject();
            System.out.println("Chat history loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("No chat history found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } 

    public LinkedList<ChatRoom_Model> getServerList() {
        return serverList;
    }
}