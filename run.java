import controllers.*;
import server.Server;

public class run {
    public static void main(String[] args){
        
         Server server = Server.getInstance();
        server.start();
        
        ControllersFacade cf = new ControllersFacade();
        cf.openLoginPage();
    
    }
}
