import controllers.*;
import models.Client;

public class ClientStart {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        client.connect("172.20.10.14", 54321);

        ControllersFacade cf = new ControllersFacade();
        cf.openLoginPage();
    }
}