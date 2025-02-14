interface UserI {
    public String userName = "";
    public String getUsername();
    public void changeName(String newName);
}

public class User implements UserI{
    private String userName = "";
    //Fascade pattern
    public User() {

    }

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
