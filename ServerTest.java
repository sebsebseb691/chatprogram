import server.*;

// (ServerTest sen Client)
// För att köra: 
// 1. javac ServerTest.java
// 2. java ServerTest
// 3. '+' (ny terminal)

public class ServerTest {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.start();
    }
}