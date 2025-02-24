package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.Message;
import views.ChatRoomView;


public class ChatRoomController extends JFrame implements ActionListener {
    private ModelsFacade modelsFacade = new ModelsFacade();
    private ControllersFacade controllersFacade = new ControllersFacade();
    private JFrame universalFrame = controllersFacade.getJFrame();
    private ChatRoomView chatRoomView = new ChatRoomView();
    public void actionPerformed(ActionEvent e) {}
    

    public ChatRoomController() {
        //Code to get all messages and send to chatroom view
    
        universalFrame.setSize(600, 300);
        chatRoomView.createView();
        universalFrame.add(chatRoomView.getJPanel());
        universalFrame.setVisible(true);
    
        addListenerChatRoom();
    }
    
    
    public void addListenerChatRoom() {
        chatRoomView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message msg = new Message(chatRoomView.getJTextField().getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(universalFrame, exc.getMessage());
                }
            }
        });
    }


    public void removeChatRoom() {
        chatRoomView.getJButton().removeActionListener(this);
        universalFrame.remove(chatRoomView.getJPanel());
        universalFrame.setVisible(false);
    }
};
