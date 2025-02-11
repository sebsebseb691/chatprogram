import java.awt.*; 
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.io.*;
import java.lang.reflect.Array;


interface User {
    public String userName = "";
    public void changeName(String newName);
    public String getUsername();
}


interface message {
    public String message = "";
    public String user = "";
    public void sendMessage(String message);
}


public class clientModel {
    
}
