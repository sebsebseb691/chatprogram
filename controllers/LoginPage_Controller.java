package controllers;
import javax.swing.*;
import java.awt.event.*;
import views.LoginPage_View;
import models.ModelsFacade;


public class LoginPage_Controller implements ActionListener, Controller_Interface {
    private ModelsFacade modelsFacade = ModelsFacade.getInstance();
    private ControllersFacade controllersFacade = new ControllersFacade();
    private JFrame frame = controllersFacade.getJFrame();
    private LoginPage_View loginPageView = new LoginPage_View();
    public void actionPerformed(ActionEvent e) {}


    public void addPanelToFrame() {
        loginPageView.createView();

        frame.add(loginPageView.getJPanel());
        frame.setSize(300, 150);
        frame.setVisible(true);

        addListener();
    }
    

    public void addListener() {
        loginPageView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Try to change username, if it fails show error message, if it succeeds remove login page
                try {
                    modelsFacade.getUser().changeName(loginPageView.getJTextField().getText());
                    controllersFacade.openServerList(); //Name changed, now show server list

                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(frame, exc.getMessage());
                }
            }
        });
    }
}
