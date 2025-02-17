package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import views.ServerList_v;


public class ServerList_c extends JFrame implements ActionListener{
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private ServerList_v sl = new ServerList_v();
    public void actionPerformed(ActionEvent e) {}


    public ServerList_c() {
        f.setSize(600, 300);
        sl.createView(mf.getUser().getUsername());
        f.add(sl.getJPanel());
        f.setVisible(true);
    
        addListenerServerList();
    }


    public void addListenerServerList() {
        sl.getJoinButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code to join chatroom
                //mf.getServerList().chats.
            }
        });
        

        sl.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code to create a new chatroom
                System.out.println("Create a new server button pressed");
            }
        });

        sl.getJoinButton().removeActionListener(this);
    }
}
