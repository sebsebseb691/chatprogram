package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.ChatRoom_m;
import models.Message;
import views.ChatRoom_v;


public class ChatRoom_c extends JFrame implements ActionListener {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    public void actionPerformed(ActionEvent e) {}

    public ChatRoom_c(ChatRoom_v cr) {
        //Code to get all messages and send to chatroom view
        f.setSize(600, 300);
        f.add(cr.getJPanel());
        f.setVisible(true);
    
        addListenerChatRoom(cr);
    }
    
    
    public void addListenerChatRoom(ChatRoom_v cr) {
        cr.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message m = new Message(cr.getJTextField().getText());
                    System.out.println(cr.getJTextField().getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }


    public void removeChatRoom(ChatRoom_v cr) {
        cr.getJButton().removeActionListener(this);
        f.remove(cr.getJPanel());
        f.setVisible(false);
    }
};
