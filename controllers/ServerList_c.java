package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import views.ServerList_v;

public class ServerList_c extends JFrame implements ActionListener{
    private ServerList_v sl;
    private ModelsFascade mf = new ModelsFascade();
    private ControllersFascade cf = new ControllersFascade();
    private JFrame f = ControllersFascade.getJFrame();
    private User u = ModelsFascade.getUser();

    public ServerList_c() {
        f.setSize(600, 300);
        sl = new ServerList_v();
        f.add(sl.getJPanel());
        f.setVisible(true);
    
        addListenerServerList();
    }


    public void addListenerServerList() {
        sl.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code to join chatroom
                //mf.getServerList().chats.
            }
        });
        sl.getJButton().removeActionListener(this);
        //Open chat room
    }

    public void actionPerformed(ActionEvent e) {}
}
