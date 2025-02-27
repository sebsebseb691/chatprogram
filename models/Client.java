package models;

import java.io.*;
import java.net.*;

/**
 * Temporary test client.
 */
public class Client {

    private final int port = 54321;
    private final String host = "localhost";

    private Socket socket;
    private ObjectOutputStream oout;
    private ObjectInputStream oin;

   
    // constructor
    public Client(){
        try{
            this.socket = new Socket(host, port);
            
            this.oout = new ObjectOutputStream(socket.getOutputStream());
            this.oin = new ObjectInputStream(socket.getInputStream());
            
            listen();
            //send();       //behöver kopplas till chat fönster


            } catch (IOException e){
                System.out.println(e.getMessage());
                }
    }


    // listen to messages
    private void listen(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Object serverMessage;
                    while ((socket != null) && !socket.isClosed()) {
                        try {
                            serverMessage = oin.readObject();
                            System.out.println("Server: " + serverMessage);

                        } catch (ClassNotFoundException e) {
                            System.out.println(e.getMessage());
                          }
                    }
                } catch (IOException e) {
                       System.out.println(e.getMessage());
                    }
            }
        }).start();

    }

    // user sending messages
    private void send(final Object message) {  
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oout.writeObject(message);
                    oout.flush();
                    System.out.println("Sent: " + message);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

    // close connection
    public void close() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            if (oout != null) {
                oout.close();
            }
            if (oin != null) {
                oin.close();
            }
            
            System.out.println("Client connecion is closed.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
