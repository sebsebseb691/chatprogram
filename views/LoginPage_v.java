package views;

import javax.swing.*;

public class LoginPage_v extends JPanel implements View {
    private JPanel p = new JPanel();
    private JLabel enterUsername = new JLabel("Username: ");
    private JTextField userNameF = new JTextField(20);
    private JButton loginButton = new JButton("Set username");
    

    public void createView() {
        p.add(enterUsername);
        p.add(userNameF);
        p.add(loginButton);
        p.repaint();
    }


    public void removeView() {
        p.removeAll();
        p.repaint();
    }


    public JPanel getJPanel() {return p;}
    public JButton getJButton() {return loginButton;}
    public JTextField getJTextField() {return userNameF;}
    
}
