package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import models.*;
import views.ServerListView;


public class ServerListController implements ActionListener, ControllerInterface{
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private ServerListView sl = new ServerListView(this);
    public void actionPerformed(ActionEvent e) {}
    
    @Override
    public void addPanelToFrame() {
        sl.createView();

        f.setSize(800, 800);
        f.add(sl.getJPanel());
        f.setVisible(true);
    }

    @Override
    public void addListener() {
        sl.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.openLoginPage();
            }
        });
    
        sl.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String chatRoomName = (String) JOptionPane.showInputDialog(f, "Enter a name for the chat room");
                    if (chatRoomName != null && !chatRoomName.trim().isEmpty()) { // If user doesn't press cancel and name is not empty
                        // Check if chat room already exists
                        ChatRoomModel existingChatRoom = mf.getChatRoomByName(chatRoomName);
                        if (existingChatRoom == null) {
                            // Create a new chat room and add it to the model
                            ChatRoomModel newChatRoom = new ChatRoomModel(chatRoomName);
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


    @Override
    public void addListeners() {
        List<JButton> joinButtons = sl.getButtons();
    
        for (JButton joinButton : joinButtons) {
            joinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() != sl.getCreateServerButton()) {
                        // Join chat room that is pressed
                        String chatRoomName = joinButton.getText();
                        ChatRoomModel chatRoom = mf.getChatRoomByName(chatRoomName);
                        if (chatRoom == null) {
                            chatRoom = new ChatRoomModel(chatRoomName);
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
