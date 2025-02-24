package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import models.ModelsFacade;
import models.Message;
import models.Image;
import views.ChatRoom_View;

public class ChatRoom_Controller extends JFrame implements ActionListener, Controller_Interface {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private ChatRoom_View chatRoomView = new ChatRoom_View();
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

        // Add listener for sending image messages
        chatRoomView.getSendImageButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Image imageMessage = new Image(selectedFile);
                        chatRoomView.displayImage(imageMessage.getUser(), imageMessage.getImage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}