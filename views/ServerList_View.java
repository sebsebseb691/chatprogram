package views;
import javax.swing.*;
import controllers.ServerList_Controller;
import java.awt.*;
import models.ChatRoom_Model;
import models.ModelsFacade;
import observers.ViewObserver;

import java.util.ArrayList;
import java.util.List;

public class ServerList_View extends JPanel implements View, ViewObserver {
    private JPanel mainP = new JPanel(new BorderLayout());
    private JPanel p = new JPanel(); 
    private JPanel sp = new JPanel(new GridLayout(0, 1));
    private JLabel welcome = new JLabel("Welcome");
    private JLabel chatname = new JLabel("Press a Chat Room to join or Create a new Chat Room:");
    private JButton createServerButton = new JButton("Create a new Chat Room");
    private List<JButton> buttons = new ArrayList<>();
    private ServerList_Controller sl; //Take in controller to add buttons

    //Kommer inte på något annat sätt än att ta in controller
    public ServerList_View(ServerList_Controller sl) {
        this.sl = sl;
    }


    public void createView() {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        welcome.setText(welcome.getText() + ": " + ModelsFacade.getInstance().getUser().getUsername()); //Add username to welcome message
        welcome.setFont(new Font("Calibri", Font.BOLD, 30));
        p.add(welcome);
        p.add(chatname);
        p.add(createServerButton);

        mainP.add(p, BorderLayout.NORTH);

        sp.setLayout(new BoxLayout(sp, BoxLayout.Y_AXIS));

        ModelsFacade.getServers().addObserver(this);
        buttons.add(createServerButton);
        sl.addListenerCreate();

        this.repaint();
    }


    public void removeView() {
        this.removeAll();
        this.repaint();
    }


    public void update() {
        buttons.clear();
        sp.removeAll();

        //Add buttons for every chatroom
        for (ChatRoom_Model i : ModelsFacade.getServers().getServerList()) {
            JButton joinChat = new JButton(i.getChatName());
            buttons.add(joinChat); //Add all buttons to a list
            sp.add(joinChat); //Add button to panel
        }

        sl.addListener(); //Controller adds listeners to every button
        mainP.add(sp, BorderLayout.EAST); //Display serverlist to the right, maybe change later
        sp.revalidate();
        sp.repaint();
    }


    public JPanel getJPanel() {return mainP;}
    public JButton getCreateServerButton() {return createServerButton;}
    public List<JButton> getButtons() {return buttons;}
}
