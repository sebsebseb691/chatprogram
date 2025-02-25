package views;
import javax.swing.*;
import controllers.Controller_Interface;
import java.awt.*;
import models.ChatRoom_Model;
import models.ModelsFacade;
import observers.ViewObserver;

import java.util.ArrayList;
import java.util.List;

public class ServerList_View extends JPanel implements View, ViewObserver {
    private JPanel mainP = new JPanel(new BorderLayout());
    private JPanel bottomP = new JPanel(new GridLayout(0, 1));
    private JButton createServerB = new JButton("Create a new Chat Room");
    private JButton back = new JButton("Change username");

    private List<JButton> buttons = new ArrayList<>(); //List of buttons of chat rooms, fetched in controller to add listeners

    private Controller_Interface sl; //Take in controller to add buttons

    //Kommer inte på något annat sätt än att ta in controller
    public ServerList_View(Controller_Interface sl) {
        this.sl = sl;
    }


    public void createView() {
        //Labels of top panel
        JLabel welcome = new JLabel("Welcome");
        welcome.setText("Welcome: " + ModelsFacade.getInstance().getUser().getUsername()); //Add username to welcome message
        welcome.setFont(new Font("Calibri", Font.BOLD, 30));
        welcome.setAlignmentX(LEFT_ALIGNMENT);

        JLabel list = new JLabel("List of Chat Rooms:");
        list.setFont(new Font("Calibri", Font.BOLD, 20));
        list.setAlignmentX(LEFT_ALIGNMENT);

        //Panel for username, info and create chat
        JPanel labelsP = new JPanel();
        labelsP.setLayout(new BoxLayout(labelsP, BoxLayout.Y_AXIS));
        labelsP.add(welcome);
        labelsP.add(new JLabel("Press a Chat Room to join or Create a new Chat Room"));
        labelsP.add(list);
        labelsP.add(createServerB);
        labelsP.setBackground(Color.LIGHT_GRAY);
        
        //Top panel
        JPanel topP = new JPanel(); 
        topP.setLayout(new BorderLayout());
        topP.add(labelsP,BorderLayout.WEST);
        topP.setBackground(Color.LIGHT_GRAY);

        //Panel for back button
        JPanel backP = new JPanel();
        backP.setBackground(Color.LIGHT_GRAY);
        backP.add(back);
        topP.add(backP, BorderLayout.EAST);

        //Chat room list panel
        JScrollPane scroll;
        scroll = new JScrollPane(bottomP);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //Add panels to main panel
        mainP.add(topP, BorderLayout.NORTH);
        mainP.add(scroll, BorderLayout.CENTER);

        bottomP.setLayout(new BoxLayout(bottomP, BoxLayout.Y_AXIS));

        ModelsFacade.getServers().addObserver(this); //Add self to observer
        sl.initalize();
        update();
        this.repaint();
    }


    public void update() {
        buttons.clear();
        bottomP.removeAll();
        
        //Add buttons for every chat room
        for (ChatRoom_Model i : ModelsFacade.getServers().getServerList()) {
            JButton joinChat = new JButton(i.getChatName());
            buttons.add(joinChat); //Add button to list
            bottomP.add(joinChat); //Add button to panel
        }

        sl.addListener(); //Controller adds listeners to every button
        bottomP.revalidate();
        bottomP.repaint();
    }


    public JPanel getJPanel() {return mainP;}
    public JButton getCreateServerButton() {return createServerB;}
    public JButton getBackButton() {return back;}
    public List<JButton> getButtons() {return buttons;}
}
