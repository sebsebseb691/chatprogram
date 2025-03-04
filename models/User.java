package models;

/**
 * Represents a user by username as a string
 */
interface UserInterface extends java.io.Serializable{
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


public class User implements UserInterface {
    private String username = "";
    public String getUsername() {return username;}

    public void changeName(String newName) throws RuntimeException {
        if(newName.isEmpty()) throw new RuntimeException("Username cannot be empty");
        else if (newName.contains(" ")) throw new RuntimeException("Username cannot contain blankspace");
        else username = newName;
    }
}
