package views;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;

//Lägg till observer som interface
//Implementera observer i chat
//Ska få uppdateringar

public class ChatRoom_v extends JPanel implements View {
    private JPanel topP = new JPanel(); //Panel for chatroom name
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel bottomP = new JPanel(new FlowLayout()); //Panel for message input
    private JPanel messageP = new JPanel(new BorderLayout()); //Messages panel
    private JLabel chatNameL = new JLabel();
    private JTextField messageF = new JTextField(30);
    private JButton sendButton = new JButton("Send");

    public void createView() {
        createView("No chatname");
    }

    public void createView(String chatName) {
        chatNameL.setText("Connected to: " + chatName);
        chatNameL.setFont(new Font("Calibri", Font.BOLD, 30));
        topP.add(chatNameL, BorderLayout.NORTH);
        topP.setBackground(Color.LIGHT_GRAY);

        //Add code to get all messages from chatroom m
        JLabel msg = new JLabel("Hej sigma"); // Test message
        msg.setOpaque(true);
        msg.setBackground(Color.WHITE); // Set the background color if needed
        Border border = new LineBorder(Color.LIGHT_GRAY, 2); // Create a light gray border with thickness 2
        msg.setBorder(border); // Set the border to the label
        messageP.add(msg, BorderLayout.NORTH);

        bottomP.add(messageF, BorderLayout.WEST);
        sendButton.setPreferredSize(new Dimension(80, 18));
        bottomP.add(sendButton, BorderLayout.EAST);

        //Add panels to main panel
        mainPanel.add(topP, BorderLayout.NORTH);
        mainPanel.add(bottomP, BorderLayout.SOUTH);
        mainPanel.add(messageP, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

        this.repaint();
    }

    public void displayMessage(String username, String message) {
        JLabel user = new JLabel(username + ": ");
        user.setOpaque(true);
        user.setBackground(Color.LIGHT_GRAY);
        Border b = new LineBorder(Color.LIGHT_GRAY, 2);
        user.setBorder(b);

        JLabel msg = new JLabel(message);
        msg.setOpaque(true);
        msg.setBackground(Color.WHITE);
        Border b2 = new LineBorder(Color.LIGHT_GRAY, 2);
        msg.setBorder(b2);
        messageP.add(user, BorderLayout.NORTH);
        messageP.add(msg, BorderLayout.NORTH);
    }


    public void removeView() {
        this.removeAll();
        this.repaint();
    }


    public JPanel getJPanel() {return mainPanel;}
    public JPanel getMessageP() {return mp;}
    public JButton getJButton() {return sendButton;}
    public JTextField getJTextField() {return messageF;}
}
