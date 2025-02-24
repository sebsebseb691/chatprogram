package server;

import java.io.*;
import java.net.*;

// (ServerTest sen Client)
// För att köra: 
// 1. javac server/Client.java
// 2. java server/Client


/**
 * Temporary test client.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 54321);
            System.out.println("Connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create a separate thread that listens for server messages
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverMessage;
                        while ((serverMessage = in.readLine()) != null) {
                            System.out.println("Server: " + serverMessage);
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }).start();


            // Main thread, listens for user input and sends to server
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = console.readLine()) != null) {
                out.println(input);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
