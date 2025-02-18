package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import views.ServerList_v; 


public class ServerList_c extends JFrame implements ActionListener{
    private ServerList_m sm = ServerList_m.getInstance();
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private ServerList_v sl = new ServerList_v();
    public void actionPerformed(ActionEvent e) {}

    public ServerList_c() {
        f.setSize(800, 300);
        sl.createView(mf.getUser().getUsername());
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
                //Gör om så panel ändras, inte frame, frame är singleton!!!
                try {
                    String serverName = (String)JOptionPane.showInputDialog(f, "Enter a name for the chat room");
                    if (serverName != null) { //If user presses cancel, do nothing
                        ChatRoom_m newChat = new ChatRoom_m(serverName);
                        sm.createServer(newChat); // Notifies model for change 
                    }
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
        sl.getJoinButton().removeActionListener(this);
    }
}
