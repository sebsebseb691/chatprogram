package models;

public class ModelsFascade {
    private static User u = new User(); //Funkar tydligen bara om man har static
    private static ServerList_m servers = ServerList_m.getInstance();

    public static User getUser() {return u;}
    public static ServerList_m getServers() {return servers;}
}
