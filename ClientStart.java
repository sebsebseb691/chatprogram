import controllers.*;
import models.Client;

public class ClientStart {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        client.connect("10.0.27.5", 54321);

        ControllersFacade cf = new ControllersFacade();
        cf.openLoginPage();
    }
}