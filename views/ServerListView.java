package views;
import javax.swing.*;
import java.awt.*;

import models.ChatroomModel;
import models.ModelsFacade;
import models.ServerListModel;
import observers.ViewObserver;

public class ServerListView extends JPanel implements View, ViewObserver {
    private JPanel mainPanel = new JPanel(); 
    private JPanel serverListPanel = new JPanel(new GridLayout(0, 1));
    private JLabel welcome = new JLabel("Welcome");
    private JLabel chatname = new JLabel("Press a Chat Room to join:");
    private JButton joinButton = new JButton("Join");
    private JButton createServerButton = new JButton("Create a new server");

    public void createView() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(welcome, BorderLayout.NORTH);
        mainPanel.add(chatname, BorderLayout.CENTER);
        serverListPanel.add(joinButton, BorderLayout.SOUTH);
        mainPanel.add(createServerButton, BorderLayout.SOUTH);

        serverListPanel.repaint();
        mainPanel.repaint(); 
    }

    public void createView(String username) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        welcome.setText(welcome.getText() + ": " + username); //Add username to welcome message
        mainPanel.add(welcome);
        mainPanel.add(chatname);
        serverListPanel.add(joinButton, BorderLayout.SOUTH);
        mainPanel.add(createServerButton);

        serverListPanel.repaint();
        mainPanel.repaint();
    }


    public void removeView() {
        serverListPanel.removeAll();
        serverListPanel.repaint();
        mainPanel.removeAll();
        mainPanel.repaint();
    }

    public void update() {
        // Code to update the view when notified
        
        serverListPanel.removeAll();
        for (ChatroomModel chatRoom : ServerListModel.getInstance().getServerList()) {
            JButton chatLabel = new JButton("chatRoom");
            mainPanel.add(chatLabel);
        
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        System.out.println("ServerList_v has been updated.");
    }
    

    

    public JPanel getJPanel() {return mainPanel;}
    public JPanel getServerPanel() {return serverListPanel;}
    public JButton getJoinButton() {return joinButton;}
    public JButton getCreateServerButton() {return createServerButton;}
}
