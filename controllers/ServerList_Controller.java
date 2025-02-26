package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import models.*;
import views.ServerList_View;


public class ServerList_Controller implements ActionListener, Controller_Interface{
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private ServerList_View sl = new ServerList_View(this);
    public void actionPerformed(ActionEvent e) {}


    public void addPanelToFrame() {
        sl.createView();

        f.setSize(800, 800);
        f.add(sl.getJPanel());
        f.setVisible(true);
    }

    public void addListenerCreate() {
        sl.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.openLoginPage();
            }
        });
    
        sl.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String chatRoomName = (String) JOptionPane.showInputDialog(f, "Enter a name for the chat room");
                    if (chatRoomName != null && !chatRoomName.trim().isEmpty()) { // If doesn't press cancel and name is not empty
                        // Check if chat room already exists
                        ChatRoom_Model existingChatRoom = mf.getChatRoomByName(chatRoomName);
                        if (existingChatRoom == null) {
                            // Create a new chat room and add it to the model
                            ChatRoom_Model newChatRoom = new ChatRoom_Model(chatRoomName);
                            mf.addChatRoom(newChatRoom);
                        } else {
                            JOptionPane.showMessageDialog(f, "Chat room with this name already exists.");
                        }
                    }
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }


    public void addListener() { // Called from view
        List<JButton> joinButtons = sl.getButtons();
    
        for (JButton joinButton : joinButtons) {
            joinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() != sl.getCreateServerButton()) {
                        // Join chat room that is pressed
                        String chatRoomName = joinButton.getText();
                        ChatRoom_Model chatRoom = mf.getChatRoomByName(chatRoomName);
                        if (chatRoom == null) {
                            chatRoom = new ChatRoom_Model(chatRoomName);
                            mf.addChatRoom(chatRoom);
                        }
                        chatRoom.joinChatRoom(chatRoomName);
                        mf.setChatRoom(chatRoom);
                        cf.openChatRoom();
                    }
                }
            });
        }
    }
}
