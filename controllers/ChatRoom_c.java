package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.User;
import models.Message;
import views.ChatRoom_v;


public class ChatRoom_c extends JFrame implements ActionListener {
    private ChatRoom_v cr;
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = ControllersFacade.getJFrame();
    private User u = ModelsFacade.getUser();

    public ChatRoom_c() {
        //Code to get all messages and send to chatroom view
    
        f.setSize(600, 300);
        cr = new ChatRoom_v();
        f.add(cr.getJPanel());
        f.setVisible(true);
    
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
