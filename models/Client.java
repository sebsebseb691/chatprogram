package models;
import java.io.*;
import java.net.*;
import java.util.LinkedList;


/**
 * Handles client connection
 */
public class Client {
    private Socket socket;
    private ObjectOutputStream oout;
    private ObjectInputStream oin;
    private ModelsFacade mf; 

    private static Client instance;
    private Client(){}
    public static synchronized Client getInstance() {
        if(instance == null) {
            instance = new Client();
        }
        return instance; 
    }

    public void connect(String serverAddress, int port) { 
        try {
            socket = new Socket(serverAddress, port);
            oout = new ObjectOutputStream(socket.getOutputStream());
            oin = new ObjectInputStream(socket.getInputStream());
            mf = ModelsFacade.getInstance();
            listen();
            System.out.println("Connected to server: " + serverAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void send(Object message) {
        try {
            oout.writeObject(message);
            oout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        new Thread(() -> {
            try {  
                // Receive chat history from the server
                @SuppressWarnings("unchecked")
                LinkedList<ChatRoomModel> chatHistory = (LinkedList<ChatRoomModel>) oin.readObject();
                mf.setChatRoomsList(chatHistory); // Set the chat history in the ModelsFacade
            
                Object serverMessage;
                while ((serverMessage = oin.readObject()) != null) {
                    System.out.println("Message received from server: " + serverMessage);
                    if (serverMessage instanceof ChatRoomModel) {
                        System.out.println("Received ChatRoomModel");
                        mf.addChatRoomFromServer((ChatRoomModel) serverMessage);
                    } else if (serverMessage instanceof MessageInterface) {
                        MessageInterface message = (MessageInterface) serverMessage;
                        System.out.println("Received MessageInterface: " + message.getMsg());
                        ChatRoomModel chatRoom = mf.getChatRoomByName(message.getChatRoomName());
                        if (chatRoom != null) {
                            chatRoom.addMessage(message);
                            chatRoom.notifyObservers();
                        } else {
                            System.out.println("Chat room not found: " + message.getChatRoomName());
                        }
                    } else {
                        System.out.println("Unknown message type received: " + serverMessage.getClass().getName());
                    }
                }
            } catch (EOFException e) {
                System.out.println("Connection closed by server.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }).start();
    }

    private void closeConnection() {
        try {
            if (oin != null) oin.close();
            if (oout != null) oout.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println("Error sending message: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
