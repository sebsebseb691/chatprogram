package views;

import javax.swing.*;

public class LoginPage extends JPanel{
    JPanel p;
    JLabel enterUsername = new JLabel("Username: ");
    JTextField userNameF = new JTextField(20);
    JButton loginButton = new JButton("Accept");

    public LoginPage(JFrame j) {
        p = new JPanel();
        p.add(enterUsername);
        p.add(userNameF);   
        p.add(loginButton);
    }

    public void RemoveLoginPage(JFrame j) {
        
    }
    
}
