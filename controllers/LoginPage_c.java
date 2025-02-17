package controllers;
import javax.swing.*;
import java.awt.event.*;
import views.LoginPage_v;
import models.ModelsFacade;
import models.User;


public class LoginPage_c extends JFrame implements ActionListener {
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = ControllersFacade.getJFrame();
    private User u = ModelsFacade.getUser();
    private LoginPage_v lp;
    
    public void actionPerformed(ActionEvent e) {}

    public LoginPage_c() {
        //Show login page if there is noo username
        if (u.getUsername().isEmpty()) createLoginPage();
    }


    //Create frame for login page and create login page object
    public void createLoginPage() {
        lp = new LoginPage_v();

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
        lp.getJButton().removeActionListener(this);
    }
}
