import java.awt.*; 
import javax.swing.*;
import views.LoginPage;
import java.awt.event.*;
import java.lang.*;


public class Controller extends JFrame implements ActionListener {
    private User u = new User();
    private JFrame f;
    private LoginPage lp;

    public Controller() {
        //Show login page if first time starting
        if (u.getUsername().isEmpty()) createLoginPage();
    }

    public void actionPerformed(ActionEvent e) {}

    //Create frame for login page and create login page object
    public void createLoginPage() {
        f = new JFrame("Login Page");
        lp = new LoginPage();

        f.add(lp.getJPanel());

        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        addListenerLoginPage();
    }

    //Add action listener to login page
    public void addListenerLoginPage() {
        lp.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Try to change username, if it fails show error message, if it succeeds remove login page
                try {
                    u.changeName(lp.getJTextField().getText());
                    lp.RemoveLoginPage();
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }

}
