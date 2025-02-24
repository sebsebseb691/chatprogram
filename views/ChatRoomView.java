package views;
import javax.swing.*;

//Lägg till observer som interface
//Implementera observer i chat
//Ska få uppdateringar

public class ChatRoomView extends JPanel implements View {
    private JPanel chatPanel = new JPanel();
    private JLabel chatname = new JLabel("Chatroom name");
    private JTextField messageField = new JTextField(30);
    private JButton sendButton = new JButton("Send");


    public void createView() {
        chatPanel.add(chatname);
        chatPanel.add(messageField);
        chatPanel.add(sendButton);
        chatPanel.repaint();
    }


    public void removeView() {
        chatPanel.removeAll();
        chatPanel.repaint();
    }


    public JPanel getJPanel() {return chatPanel;}
    public JButton getJButton() {return sendButton;}
    public JTextField getJTextField() {return messageField;}
}
