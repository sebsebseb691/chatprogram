package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import views.ChatRoom_v;


public class ChatRoom_c extends JFrame implements ActionListener {
    private ChatRoom_v cr;
    private JFrame f = ControllersFascade.getJFrame();

    public void createChatRoom() {
        //Code to get all messages and send to chatroom view
    
        f.setSize(600, 300);
        cr = new ChatRoom_v();
        f.add(cr.getJPanel());
    
        addListenerChatRoom();
    }
    
    
    public void addListenerChatRoom() {
        cr.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message m = new Message(cr.getJTextField().getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
        cr.getJButton().removeActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {}
};
