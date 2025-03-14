import controllers.*;
import models.Client;

//Run this class to start a client
public class ClientStart {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        //Change the IP address to the server's IP address
        client.connect("192.168.156.1", 54321);

        ControllersFacade cf = new ControllersFacade();
        cf.openLoginPage();
    }
}