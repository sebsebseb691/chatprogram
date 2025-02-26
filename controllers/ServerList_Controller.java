package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import models.*;
import views.ServerList_View;


public class ServerList_Controller implements ActionListener, Controller_Interface{
    private ModelsFacade modelsFacade = ModelsFacade.getInstance();
    private ControllersFacade controllersFacade = new ControllersFacade();
    private JFrame frame = controllersFacade.getJFrame();
    private ServerList_View serverListView = new ServerList_View(this);
    public void actionPerformed(ActionEvent e) {}


    public void addPanelToFrame() {
        serverListView.createView();

        frame.setSize(800, 800);
        frame.add(serverListView.getJPanel());
        frame.setVisible(true);
    }

    public void addListenerCreate() {
        serverListView.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controllersFacade.openLoginPage();
            }
        });

        serverListView.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //if(e.getSource() == sl.getCreateServerButton()) {
                    try {
                        String chatRoomName = (String) JOptionPane.showInputDialog(frame, "Enter a name for the chat room");
                        if (chatRoomName != null) { // If doesn't press cancel, otherwise do nothing
                            modelsFacade.createChatRoom(chatRoomName);
                            ModelsFacade.getServers().addChatRoom(modelsFacade.getChatRoom()); // Notifies model for change
                        }
                    } catch (RuntimeException exc) {
                        JOptionPane.showMessageDialog(frame, exc.getMessage());
                    }
                //}
            }
        });
    }


    public void addListener() { //Called from view
        List<JButton> joinButtons = serverListView.getButtons();

        for (JButton joinButton : joinButtons) {
            joinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() != serverListView.getCreateServerButton()) {
                        // Join chat room that is pressed
                        modelsFacade.getChatRoom().joinChatRoom(joinButton.getText());
                        controllersFacade.openChatRoom();
                    }
                }
            });
        }
    }
}
