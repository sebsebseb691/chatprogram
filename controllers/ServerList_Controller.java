package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import models.*;
import views.ServerList_View;


public class ServerList_Controller implements ActionListener{
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private ServerList_View sl = new ServerList_View(this);
    public void actionPerformed(ActionEvent e) {}


    public void addPanelToFrame() {
        sl.createView(mf.getUser().getUsername());

        f.setSize(800, 300);
        f.add(sl.getJPanel());
        f.setVisible(true);
    
        ModelsFacade.getServers().addObserver(sl);
        addListener();
    }


    //Create server button
    public void addListener() {
        sl.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String chatRoomName = (String)JOptionPane.showInputDialog(f, "Enter a name for the chat room");
                    if (chatRoomName != null) { //If doesn't press cancel, otherwise do nothing
                        mf.createChatRoom(chatRoomName);
                        ModelsFacade.getServers().addChatRoom(mf.getChatRoom()); // Notifies model for change 
                    }
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }

    //Join server button
    public void addListeners() {
        List<JButton> joinButtons = sl.getJoinButtons();
        for (JButton joinButton : joinButtons) {
            joinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Join chat room that is pressed
                    mf.getChatRoom().joinChatRoom(joinButton.getText());
                    cf.openChatRoom();
                    removePanelFromFrame();
                    //sl.removeView();
                }
            });
        }
    }

    public void removePanelFromFrame() {
        f.remove(sl.getJPanel());
        f.setVisible(false);
    }
}
