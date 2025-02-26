package controllers;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import models.*;
import views.ServerList_v;

/**
 * Controller for Server list. Manages creating and joining chatrooms.
 */
public class ServerList_c extends JFrame implements ActionListener{
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private ServerList_m sm = mf.getServers();
    private JFrame f = cf.getJFrame();
    private ServerList_v sl = new ServerList_v(this);
    public void actionPerformed(ActionEvent e) {}

    // constructor for Server list
    public ServerList_c() {
        f.setSize(800, 300);
        sl.createView(mf.getUser().getUsername());
        sm.addObserver(sl);
        f.add(sl.getJPanel());
        f.setVisible(true);
    
        addListenerServerList();
    }

    // method for event listener to 'Create Chat' button
    public void addListenerServerList() {
        sl.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code to create a new chatroom
                try {
                    String serverName = (String)JOptionPane.showInputDialog(f, "Enter a name for the chat room");
                    if (serverName != null) { //If doesn't press cancel, otherwise do nothing
                        ChatRoom_m newChat = new ChatRoom_m(serverName);
                        sm.createServer(newChat); // Notifies model for change 
                    }
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
        sl.getCreateServerButton().removeActionListener(this);
    }

    // method adds event listener to every servers 'Join' button
    public void addListenerServerListServer() {
        LinkedList<JButton> joinButtons = sl.getJoinButtons();
        for (JButton joinButton : joinButtons) {
            joinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Code to join chatroom
                    System.out.println("User wants to join: " + joinButton.getText());
                }
            });
        }
    }

}
