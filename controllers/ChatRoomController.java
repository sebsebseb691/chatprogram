package controllers;
import javax.swing.*;
import java.awt.event.*;
import models.ModelsFacade;
import models.Message;
import views.ChatRoomView;


public class ChatRoomController extends JFrame implements ActionListener, ControllerInterface {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private ChatRoomView chatRoomView = new ChatRoomView();
    private JFrame f = cf.getJFrame();
    public void actionPerformed(ActionEvent e) {}


    public void addPanelToFrame() {
        chatRoomView.createView(mf.getChatRoom().getChatName());
        
        f.setSize(800, 600);
        f.add(chatRoomView.getJPanel());
        f.setVisible(true);
    
        addListener();
    }
    
    
    public void addListener() {
        chatRoomView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    @SuppressWarnings("unused")
                    Message m = new Message(chatRoomView.getJTextField().getText());
                    chatRoomView.getJTextField().setText("");                       // Clears the text field
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });

        chatRoomView.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.openServerList();
            }
        });
    }
};
