package views;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import models.Message;
import models.ModelsFacade;


public class ChatRoom_View extends JPanel implements View, observers.ViewObserver {
    private JPanel topP = new JPanel(); //Panel for chatroom name
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel bottomP = new JPanel(new FlowLayout()); //Panel for message input
    private JPanel messageP = new JPanel(new BorderLayout()); //Messages panel

    private JLabel chatNameL = new JLabel();
    private JTextField messageF = new JTextField(30);
    private JButton sendButton = new JButton("Send");
    private JScrollPane scroll;
    private ModelsFacade mf = ModelsFacade.getInstance();


    public void createView() {
        createView("No chat name");
    }

    public void createView(String chatName) {
        //Top panel, server name
        chatNameL.setText("Connected to: " + chatName);
        chatNameL.setFont(new Font("Calibri", Font.BOLD, 30));
        topP.add(chatNameL, BorderLayout.NORTH);
        topP.setBackground(Color.LIGHT_GRAY);

        //Bottom panel, message input and send button
        bottomP.add(messageF, BorderLayout.WEST);
        sendButton.setPreferredSize(new Dimension(80, 18));
        bottomP.add(sendButton, BorderLayout.EAST);

        //Scroll
        messageP.setLayout(new BoxLayout(messageP, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(messageP);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Add panels to main panel
        mainPanel.add(topP, BorderLayout.NORTH);
        mainPanel.add(bottomP, BorderLayout.SOUTH);
        mainPanel.add(scroll, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
        this.repaint();

        mf.getChatRoom().addObserver(this); //Add self to observer list
        update(); //Update too see messages
    }

    public void displayMessage(String username, String msg) {
        JLabel message = new JLabel(username + ": " + msg);
        message.setOpaque(true);
        message.setBackground(Color.WHITE);
        Border b = new LineBorder(Color.LIGHT_GRAY, 2);
        message.setBorder(b);

        messageP.add(message);
    }


    public void update() {
        messageP.removeAll();

        for (Message i : mf.getChatRoom().getMessages()) {
            displayMessage(i.getUser(), i.getMsg());
        }
        
        messageP.revalidate();
        messageP.repaint();
    }


    public void removeView() {
        this.removeAll();
        this.repaint();
    }


    public JPanel getJPanel() {return mainPanel;}
    public JButton getJButton() {return sendButton;}
    public JTextField getJTextField() {return messageF;}
}
