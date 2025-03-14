package controllers;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import models.ModelsFacade;
import views.ChatRoomView;


public class ChatRoomController extends JFrame implements ActionListener, ControllerInterface {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private ChatRoomView chatRoomView = new ChatRoomView();
    private JFrame f = cf.getJFrame();

    @Override
    public void addPanelToFrame() {
        chatRoomView.createView(mf.getChatRoom().getChatName());
        
        f.setSize(800, 600);
        f.add(chatRoomView.getJPanel());
        f.setVisible(true);
    
        addListener();
    }
    
    @Override
    public void addListener() {
        //Listener for text message
        chatRoomView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    mf.createMessage(chatRoomView.getJTextField().getText(), mf.getUser().getUsername(), mf.getChatRoom().getChatName());
                    chatRoomView.getJTextField().setText(""); // Clears the text field after message is sent
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });

        //Add listener for sending image message
        chatRoomView.getSendImageButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    mf.createImage(selectedFile, mf.getChatRoom().getChatName(), mf.getUser().getUsername());
                }
            }
        });

        //Add listener to back button
        chatRoomView.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.openServerList();
            }
        });
    }

    @Override
    public void addListeners() {}
    @Override
    public void actionPerformed(ActionEvent e) {}
}