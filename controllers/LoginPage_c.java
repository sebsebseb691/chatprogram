package controllers;
import javax.swing.*;
import java.awt.event.*;
import views.LoginPage_v;
import models.ModelsFacade;


public class LoginPage_c extends JFrame implements ActionListener {
    private ModelsFacade mf = new ModelsFacade();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private LoginPage_v lp = new LoginPage_v();
    public void actionPerformed(ActionEvent e) {}


    public LoginPage_c() {
        //Show login page if there is no username
        //Maybe edit later
        if (mf.getUser().getUsername().isEmpty()) createLoginPage();
    }


    public void createLoginPage() {
        lp.createView();

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
                    mf.getUser().changeName(lp.getJTextField().getText());
                    ServerList_c sl = new ServerList_c(); //Name changed, now show server list
                    lp.removeView(); //Remove elements from login panel
                    removeLoginPage(); //Remove login page from frame
                    
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
        lp.getJButton().removeActionListener(this);
    }


    public void removeLoginPage() {
        f.remove(lp.getJPanel());
        f.setVisible(false);
    }
}
