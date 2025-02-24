package controllers;
import javax.swing.*;


import java.awt.event.*;
import models.*;
import views.ServerListView; 


public class ServerListController extends JFrame implements ActionListener{
    private ServerListModel serverListModel = ServerListModel.getInstance();
    private ModelsFacade modelsFacade = new ModelsFacade();
    private ControllersFacade controllersFacade = new ControllersFacade();
    private JFrame applicationWindow = controllersFacade.getJFrame();
    private JFrame chatroomWindow = controllersFacade.getJFrame();
    private ServerListView serverListView = new ServerListView();
    public void actionPerformed(ActionEvent e) {}

    public ServerListController() {
        applicationWindow.setSize(800, 300);
        serverListView.createView(modelsFacade.getUser().getUsername());
        serverListModel.addObserver(serverListView);
        applicationWindow.add(serverListView.getJPanel());
        applicationWindow.setVisible(true);
    
        addListenerServerList();
    }//


    public void addListenerServerList() {
        serverListView.getJoinButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code to join chatroom
                //modelsFacade.getServerList().chats.
            }
        });
        

        serverListView.getCreateServerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code to create a new chatroom
                chatroomWindow.setSize(150, 150); // kommer antaglien behöva göra en ny class ta emot namn av chatroom
                chatroomWindow.setVisible(true);
                ChatroomModel newChat = new ChatroomModel("New Chatroom");
                serverListModel.createServer(newChat); // Notifies model for change 
            }
        });

        serverListView.getJoinButton().removeActionListener(this);
    }
}
