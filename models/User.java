package models;

interface UserI {
    /**
     * Get the username of the user
     * @return the username as a string
     */
    public String getUsername();
    /**
     * Change the username
     * @param newName the new username
     */
    public void changeName(String newName) throws RuntimeException;
}

public class User implements UserI{
    private String userName = "";
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
        else userName = newName;
    }
}
