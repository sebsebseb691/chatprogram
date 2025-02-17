package views;

import javax.swing.*;
import java.awt.*; 

public class ServerList_v extends JPanel implements View {
    private JPanel p = new JPanel(new BorderLayout()); 
    private JPanel sp = new JPanel(new GridLayout(0, 1));
    private JLabel welcome = new JLabel("Welcome");
    private JLabel chatname = new JLabel("Press a Chat Room to join:");
    private JButton joinButton = new JButton("Join");
    private JButton createServerButton = new JButton("Create a new server");

    public void createView() {
        p.add(welcome, BorderLayout.NORTH);
        p.add(chatname, BorderLayout.CENTER);
        sp.add(joinButton, BorderLayout.SOUTH);
        p.add(createServerButton, BorderLayout.SOUTH);

        sp.repaint();
        p.repaint(); 
    }

    public void createView(String username) {
        welcome.setText(welcome.getText() + ": " + username); //Add username to welcome message
        p.add(welcome, BorderLayout.NORTH);
        p.add(chatname, BorderLayout.CENTER);
        sp.add(joinButton, BorderLayout.SOUTH);
        p.add(createServerButton, BorderLayout.SOUTH);

        sp.repaint();
        p.repaint();
    }


    public void removeView() {
        sp.removeAll();
        sp.repaint();
        p.removeAll();
        p.repaint();
    }


    public JPanel getJPanel() {return p;}
    public JPanel getServerPanel() {return sp;}
    public JButton getJoinButton() {return joinButton;}
    public JButton getCreateServerButton() {return createServerButton;}
}
