package views;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import models.ChatRoom_m;
import models.Message;
import models.ModelsFacade;


public class ChatRoom_v extends JPanel implements View, observers.ViewObserver {
    private JPanel topP = new JPanel(); //Panel for chatroom name
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel bottomP = new JPanel(new FlowLayout()); //Panel for message input
    private JPanel messageP = new JPanel(new BorderLayout()); //Messages panel
    private JLabel chatNameL = new JLabel();
    private JTextField messageF = new JTextField(30);
    private JButton sendButton = new JButton("Send");

    private ModelsFacade mf = ModelsFacade.getInstance();
    private ChatRoom_m activeChat = mf.getChatRoom();

    public void createView() {
        createView("No chat name");
    }

    public void createView(String chatName) {
        mf.setChatRoom(activeChat);
        //Top panel, show server name
        chatNameL.setText("Connected to: " + chatName);
        chatNameL.setFont(new Font("Calibri", Font.BOLD, 30));
        topP.add(chatNameL, BorderLayout.NORTH);
        topP.setBackground(Color.LIGHT_GRAY);

        //Bottom panel, message input and send button
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

    public void update() {
        activeChat = activeChat.getChatRoomObj();
        // Code to update the view when notified
        for (Message i : activeChat.getChatRoomObj().getMessages()) {
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
