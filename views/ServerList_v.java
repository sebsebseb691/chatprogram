package views;

import javax.swing.*;

public class ServerList_v extends JPanel implements View {
    private JPanel p = new JPanel();
    private JLabel chatname = new JLabel("Chatrooms:");
    private JButton joinButton = new JButton("Join");

    public ServerList_v() {
        p.add(chatname);
        p.add(joinButton);
        p.repaint();
    }

    public void RemoveServerList() {
        p.remove(chatname);
        p.remove(joinButton);
        p.repaint();
    }

    public JPanel getJPanel() {return p;}
    public JButton getJButton() {return joinButton;}
}
