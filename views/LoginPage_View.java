package views;

import javax.swing.*;

public class LoginPage_View extends JPanel implements View {
    private JPanel panel = new JPanel();
    private JLabel enterUsername = new JLabel("Username: ");
    private JTextField userNameField = new JTextField(20);
    private JButton loginButton = new JButton("Set username");
    

    public void createView() {
        panel.add(enterUsername);
        panel.add(userNameField);
        panel.add(loginButton);
        this.repaint();
    }


    public JPanel getJPanel() {return panel;}
    public JButton getJButton() {return loginButton;}
    public JTextField getJTextField() {return userNameField;}
    
}
