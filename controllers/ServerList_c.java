package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import models.*;
import views.ServerList_v;


public class ServerList_c extends JFrame implements ActionListener{
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private ServerList_m sm = mf.getServers();
    private JFrame f = cf.getJFrame();
    private ServerList_v sl = new ServerList_v(this);
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
        sl.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

    //Add action listener to every server and let user join chatroom
    public void addListenerServerListServer() {
        LinkedList<JButton> joinButtons = sl.getJoinButtons();
        for (JButton joinButton : joinButtons) {
            joinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Join chat room that is pressed
                    mf.getChatRoom().joinChatRoom(joinButton.getText());
                    sl.removeView();
                    cf.openChatRoom();
                    
                }
            });
        }
    }
}
