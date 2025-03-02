package models;

/**
 * Represents a user by username as a string
 */
interface User_Interface extends java.io.Serializable{
    /**
     * Get the username of the user
     * @return the username as a string
     */
    public String getUsername();
    /**
    * Change a username if it is not empty and does not contain blankspace
    *
    * @param newName new username as a string
    * @throws RuntimeException if newName is empty or contains blankspace
    */
    public void changeName(String newName) throws RuntimeException;
}


public class User implements User_Interface {
    private String userName = "";
    public String getUsername() {return userName;}

    public void changeName(String newName) throws RuntimeException {
        if(newName.isEmpty()) throw new RuntimeException("Username cannot be empty");
        else if (newName.contains(" ")) throw new RuntimeException("Username cannot contain blankspace");
        else userName = newName;
    }
}
