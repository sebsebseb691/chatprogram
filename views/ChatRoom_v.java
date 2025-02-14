package views;
import javax.swing.*;

//Lägg till observer som interface
//Implementera observer i chat
//Ska få uppdateringar



public class ChatRoom_v extends JPanel implements View {
    private JPanel p = new JPanel();
    private JLabel chatname = new JLabel("Chatroom name");
    private JTextField messageF = new JTextField(30);
    private JButton sendButton = new JButton("Send");

    public ChatRoom_v() {
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
