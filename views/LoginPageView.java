package views;

import javax.swing.*;

public class LoginPageView extends JPanel implements View {
    private JPanel mainP = new JPanel();
    private JLabel enterUsername = new JLabel("Username: ");
    private JTextField userNameF = new JTextField(20);
    private JButton loginButton = new JButton("Set username");
    
    @Override
    public void createView() {
        mainP.add(enterUsername);
        mainP.add(userNameF);
        mainP.add(loginButton);
        this.repaint();
    }

    @Override
    public JPanel getJPanel() {return mainP;}
    public JButton getJButton() {return loginButton;}
    public JTextField getJTextField() {return userNameF;}
}
