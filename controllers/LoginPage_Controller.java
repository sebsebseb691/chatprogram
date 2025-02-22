package controllers;
import javax.swing.*;
import java.awt.event.*;
import views.LoginPage_View;
import models.ModelsFacade;


public class LoginPage_Controller implements ActionListener, Controller_Interface {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private LoginPage_View lp = new LoginPage_View();
    public void actionPerformed(ActionEvent e) {}
    public void addListeners() {}


    public void addPanelToFrame() {
        lp.createView();

        f.add(lp.getJPanel());
        f.setSize(300, 150);
        f.setVisible(true);

        addListener();
    }
    

    public void addListener() {
        lp.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Try to change username, if it fails show error message, if it succeeds remove login page
                try {
                    mf.getUser().changeName(lp.getJTextField().getText());
                    cf.openServerList(); //Name changed, now show server list
                    //lp.removeView(); //Remove elements from login panel
                    removePanelFromFrame(); //Remove login page from frame

                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }


    public void removePanelFromFrame() {
        f.remove(lp.getJPanel());
        f.setVisible(false);
    }
}
