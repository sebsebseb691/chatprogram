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

    public String userName = "";
    public String getUsername() {return userName;}

    /**
    * Change a username if it is not empty and does not contain blankspace
    *
    * @param newName new username as a string
    * @throws RuntimeException if newName is empty or contains blankspace
    */
    public void changeName(String newName) throws RuntimeException {
        if(newName.isEmpty()) throw new RuntimeException("Username cannot be empty");
        else if (newName.contains(" ")) throw new RuntimeException("Username cannot contain blankspace");
        else {
            userName = newName;
            //Update login page view here
        }
    }



}
