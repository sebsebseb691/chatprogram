package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.Message;
import views.ChatRoom_View;


public class ChatRoom_Controller extends JFrame implements ActionListener, Controller_Interface {
    private ModelsFacade modelsFacade = ModelsFacade.getInstance();
    private ControllersFacade controllersFacade = new ControllersFacade();
    private ChatRoom_View chatRoomView = new ChatRoom_View();
    private JFrame frame = controllersFacade.getJFrame();
    public void actionPerformed(ActionEvent e) {}


    public void addPanelToFrame() {
        chatRoomView.createView(modelsFacade.getChatRoom().getChatName());
        
        frame.setSize(800, 600);
        frame.add(chatRoomView.getJPanel());
        frame.setVisible(true);
    
        addListener();
    }
    
    
    public void addListener() {
        //Adds listener to the send button
        chatRoomView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    @SuppressWarnings("unused")
                    Message sentMessage = new Message(chatRoomView.getJTextField().getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(frame, exc.getMessage());
                }
            }
        });
        //Adds listener to the back button
        chatRoomView.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controllersFacade.openServerList();
            }
        });
    }
};
