package controllers;
import javax.swing.*;


import java.awt.event.*;
import models.*;
import views.ServerList_v; 


public class ServerList_c extends JFrame implements ActionListener{
    private ServerList_v sl;
    private ServerList_m sm = ServerList_m.getInstance();
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private JFrame f2 = cf.getJFrame();

    public ServerList_c() {
        f.setSize(800, 300);
        sl = new ServerList_v(mf.getUser().getUsername());
        sm.addObserver(sl);
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
                f2.setSize(150, 150); // kommer antaglien behöva göra en ny class ta emot namn av chatroom
                f2.setVisible(true);
                ChatRoom_m newChat = new ChatRoom_m("New Chatroom");
                sm.createServer(newChat); // Notifies model for change 
            }
        });

        sl.getJoinButton().removeActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {}
}
