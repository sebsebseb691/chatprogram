package views;
import javax.swing.*;
import java.awt.*;

import models.ChatRoom_m;
import models.ModelsFacade;
import models.ServerList_m;
import observers.ViewObserver;

public class ServerList_v extends JPanel implements View, ViewObserver {
    private JPanel p = new JPanel(); 
    private JPanel sp = new JPanel(new GridLayout(0, 1));
    private JLabel welcome = new JLabel("Welcome");
    private JLabel chatname = new JLabel("Press a Chat Room to join:");
    private JButton createServerButton = new JButton("Create a new server");


    public void createView() {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(welcome, BorderLayout.NORTH);
        p.add(chatname, BorderLayout.CENTER);
        p.add(createServerButton, BorderLayout.SOUTH);

        sp.repaint();
        p.repaint(); 
    }


    public void createView(String username) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        welcome.setText(welcome.getText() + ": " + username); //Add username to welcome message
        p.add(welcome);
        p.add(chatname);
        p.add(createServerButton);

        sp.repaint();
        p.repaint();
    }


    public void removeView() {
        sp.removeAll();
        sp.repaint();
        p.removeAll();
        p.repaint();
    }


    public void update() {
        // Code to update the view when notified
        sp.removeAll();
        for (ChatRoom_m i : ServerList_m.getServerList()) { //Är det okej att ta in model i view? Kanske ändra hur man hämtar listan
            JButton joinChat = new JButton(i.getChatName());
            sp.add(joinChat);
            //How to add action listener to every button? Is it okay to call a method in controller from viw
            //Add action listener on every button and listen for what button is pressed
        }

        sp.revalidate();
        sp.repaint();
    }

    public JButton getJoinButton() {return joinChat;}
    public JPanel getJPanel() {return p;}
    public JPanel getServerPanel() {return sp;}
    public JButton getCreateServerButton() {return createServerButton;}
}
