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
    private JPanel topP = new JPanel(); 
    private JPanel sp = new JPanel(new GridLayout(0, 1));
    private JPanel backP = new JPanel();
    private List<JButton> buttons = new ArrayList<>();

    private JButton createServerButton = new JButton("Create a new Chat Room");
    private JButton back = new JButton("Change username");

    private ServerList_Controller sl; //Take in controller to add buttons

    //Kommer inte på något annat sätt än att ta in controller
    public ServerList_View(ServerList_Controller sl) {
        this.sl = sl;
    }


    public void createView() {
        topP.setLayout(new BoxLayout(topP, BoxLayout.Y_AXIS));
        backP.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Labels for top panel
        JLabel welcome = new JLabel("Welcome");
        welcome.setText("Welcome: " + ModelsFacade.getInstance().getUser().getUsername()); //Add username to welcome message
        welcome.setFont(new Font("Calibri", Font.BOLD, 30));
        JLabel list = new JLabel("Server list:");
        list.setFont(new Font("Calibri", Font.BOLD, 20));
        
        topP.add(welcome);
        topP.add(new JLabel("Press a Chat Room to join or Create a new Chat Room:"));
        topP.add(createServerButton);
        topP.add(list);
        topP.setBackground(Color.LIGHT_GRAY);

        //Back button
        backP.setBackground(Color.LIGHT_GRAY);
        backP.add(back);
        topP.add(backP);

        sp.setLayout(new BoxLayout(sp, BoxLayout.Y_AXIS));

        //Chat room list panel
        JScrollPane scroll;
        scroll = new JScrollPane(sp);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        mainP.add(topP, BorderLayout.NORTH);
        mainP.add(scroll, BorderLayout.CENTER); //Display serverlist to the right, maybe change later

        ModelsFacade.getServers().addObserver(this); //Add self to observer
        sl.addListenerCreate();
        update();
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
        sp.revalidate();
        sp.repaint();
    }


    public JPanel getJPanel() {return mainP;}
    public JButton getCreateServerButton() {return createServerButton;}
    public JButton getBackButton() {return back;}
    public List<JButton> getButtons() {return buttons;}
}
