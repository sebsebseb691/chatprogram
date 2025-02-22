package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.Message;
import views.ChatRoom_v;


public class ChatRoom_c extends JFrame implements ActionListener {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private ChatRoom_v chatRoomView = new ChatRoom_v();
    private JFrame f = cf.getJFrame();
    public void actionPerformed(ActionEvent e) {}

    public ChatRoom_c() {

    }

    public void seeChatRoom() {
        f.setSize(600, 300);
        chatRoomView.createView(mf.getChatRoom().getChatName());
        f.add(chatRoomView.getJPanel());
        f.setVisible(true);
    
        addListenerChatRoom();
    }
    
    
    public void addListenerChatRoom() {
        chatRoomView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message m = new Message(chatRoomView.getJTextField().getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }


    public void removeChatRoom() {
        chatRoomView.getJButton().removeActionListener(this);
        f.remove(chatRoomView.getJPanel());
        f.setVisible(false);
    }
};
