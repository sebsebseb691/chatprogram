package views;

import javax.swing.*;

public class LoginPage_View extends JPanel implements View {
    private JPanel p = new JPanel();
    private JLabel enterUsername = new JLabel("Username: ");
    private JTextField userNameF = new JTextField(20);
    private JButton loginButton = new JButton("Set username");
    

    public void createView() {
        p.add(enterUsername);
        p.add(userNameF);
        p.add(loginButton);
        this.repaint();
    }


    public JPanel getJPanel() {return p;}
    public JButton getJButton() {return loginButton;}
    public JTextField getJTextField() {return userNameF;}
    
}
