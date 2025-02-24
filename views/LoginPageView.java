package views;

import javax.swing.*;

public class LoginPageView extends JPanel implements View {
    private JPanel loginPanel = new JPanel();
    private JLabel enterUsername = new JLabel("Username: ");
    private JTextField userNameF = new JTextField(20);
    private JButton loginButton = new JButton("Set username");
    

    public void createView() {
        loginPanel.add(enterUsername);
        loginPanel.add(userNameF);
        loginPanel.add(loginButton);
        loginPanel.repaint();
    }


    public void removeView() {
        loginPanel.removeAll();
        loginPanel.repaint();
    }


    public JPanel getJPanel() {return loginPanel;}
    public JButton getJButton() {return loginButton;}
    public JTextField getJTextField() {return userNameF;}
    
}
