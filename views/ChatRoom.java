package views;

import javax.swing.*;

public class ChatRoom extends JPanel implements View {
    private JPanel p = new JPanel();
    private JLabel chatname = new JLabel("Chatroom name");
    private JTextField messageF = new JTextField(30);
    private JButton sendButton = new JButton("Send");

    public ChatRoom() {
        p.add(chatname);
        p.add(messageF);
        p.add(sendButton);
        p.repaint();
    }

    public void RemoveChatRoom() {
        p.remove(chatname);
        p.remove(messageF);
        p.remove(sendButton);
        p.repaint();
    }

    public JPanel getJPanel() {return p;}
    public JButton getJButton() {return sendButton;}
    public JTextField getJTextField() {return messageF;}
}
