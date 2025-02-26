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
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel bottomPanel = new JPanel(new GridLayout(0, 1));
    private JButton createServerButton = new JButton("Create a new Chat Room");
    private JButton backButton = new JButton("Change username");

    private List<JButton> buttons = new ArrayList<>(); //List of buttons of chat rooms, fetched in controller to add listeners

    private ServerList_Controller serverListController; //Take in controller to add buttons

    //Kommer inte på något annat sätt än att ta in controller
    public ServerList_View(ServerList_Controller serverListController) {
        this.serverListController = serverListController;
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
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(welcome);
        labelsPanel.add(new JLabel("Press a Chat Room to join or Create a new Chat Room"));
        labelsPanel.add(list);
        labelsPanel.add(createServerButton);
        labelsPanel.setBackground(Color.LIGHT_GRAY);
        
        //Top panel
        JPanel topPanel = new JPanel(); 
        topPanel.setLayout(new BorderLayout());
        topPanel.add(labelsPanel,BorderLayout.WEST);
        topPanel.setBackground(Color.LIGHT_GRAY);

        //Panel for back button
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setBackground(Color.LIGHT_GRAY);
        backButtonPanel.add(backButton);
        topPanel.add(backButtonPanel, BorderLayout.EAST);

        //Chat room list panel
        JScrollPane scroll;
        scroll = new JScrollPane(bottomPanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //Add panels to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        ModelsFacade.getServers().addObserver(this); //Add self to observer
        serverListController.addListenerCreate();
        update();
        this.repaint();
    }


    public void update() {
        buttons.clear();
        bottomPanel.removeAll();
        
        //Add buttons for every chat room
        for (ChatRoom_Model i : ModelsFacade.getServers().getServerList()) {
            JButton joinChat = new JButton(i.getChatName());
            buttons.add(joinChat); //Add button to list
            bottomPanel.add(joinChat); //Add button to panel
        }

        serverListController.addListener(); //Controller adds listeners to every button
        bottomPanel.revalidate();
        bottomPanel.repaint();
    }


    public JPanel getJPanel() {return mainPanel;}
    public JButton getCreateServerButton() {return createServerButton;}
    public JButton getBackButton() {return backButton;}
    public List<JButton> getButtons() {return buttons;}
}
