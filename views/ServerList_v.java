package views;
import javax.swing.*;
import controllers.ServerList_c;
import java.awt.*;
import models.ChatRoom_m;
import models.ServerList_m;
import observers.ViewObserver;
import java.util.LinkedList;

public class ServerList_v extends JPanel implements View, ViewObserver {
    private JPanel mainP = new JPanel(new BorderLayout());
    private JPanel p = new JPanel(); 
    private JPanel sp = new JPanel(new GridLayout(0, 1));
    private JLabel welcome = new JLabel("Welcome");
    private JLabel chatname = new JLabel("Press a Chat Room to join or Create a new Chat Room:");
    private JButton createServerButton = new JButton("Create a new Chat Room");
    private LinkedList<JButton> joinButtons = new LinkedList<JButton>();
    private ServerList_c sl; //Take in controller to add buttons

    //Kommer inte på något annat sätt än att ta in controller
    public ServerList_v(ServerList_c sl) {
        this.sl = sl;
    }

    public void createView() { //Needed because of view interface
        //Should not be possible to get here because of how user.changename() works
        createView("No-username");
    }


    public void createView(String username) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        welcome.setText(welcome.getText() + ": " + username); //Add username to welcome message
        welcome.setFont(new Font("Calibri", Font.BOLD, 30));
        p.add(welcome);
        p.add(chatname);
        p.add(createServerButton);
        mainP.add(p, BorderLayout.NORTH);

        sp.setLayout(new BoxLayout(sp, BoxLayout.Y_AXIS));
        update(); //Show servers

        this.repaint();
    }


    public void removeView() {
        this.removeAll();
        this.repaint();
    }


    //Runs when model tells view
    public void update() {
        sp.removeAll();

        //Add buttons for every chatroom
        for (ChatRoom_m i : ServerList_m.getServerList()) { //Är det okej att ta in model i view? Kanske ändra hur man hämtar listan
            JButton joinChat = new JButton(i.getChatName());
            joinButtons.add(joinChat);
            sp.add(joinChat);
        }

        sl.addListenerServerListServer(); //Tell controller to add action listeners to every button
        mainP.add(sp, BorderLayout.EAST); //Display serverlist to the right, maybe change later
        sp.revalidate();
        sp.repaint();
    }


    public JPanel getJPanel() {return mainP;}
    public JButton getCreateServerButton() {return createServerButton;}
    public LinkedList<JButton> getJoinButtons() {return joinButtons;}
}
