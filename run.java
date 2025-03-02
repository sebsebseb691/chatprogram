import controllers.*;
import models.Client;

public class run {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        client.connect("192.168.56.1", 54321);

        ControllersFacade cf = new ControllersFacade();
        cf.openLoginPage();
    }
}