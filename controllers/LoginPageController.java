package controllers;
import javax.swing.*;
import java.awt.event.*;
import views.LoginPageView;
import models.ModelsFacade;


public class LoginPageController extends JFrame implements ActionListener {
    private ModelsFacade modelsFacade = new ModelsFacade();
    private ControllersFacade controllersFacade = new ControllersFacade();
    private JFrame universalFrame = controllersFacade.getJFrame();
    private LoginPageView loginPageView = new LoginPageView();
    public void actionPerformed(ActionEvent e) {}


    public LoginPageController() {
        //Show login page if there is no username
        //Maybe edit later
        if (modelsFacade.getUser().getUsername().isEmpty()) createLoginPage();
    }


    public void createLoginPage() {
        loginPageView.createView();

        universalFrame.add(loginPageView.getJPanel());

        universalFrame.setSize(300, 150);
        universalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        universalFrame.setVisible(true);

        addListenerLoginPage();
    }


    //Add action listener to login page
    public void addListenerLoginPage() {
        loginPageView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Try to change username, if it fails show error message, if it succeeds remove login page
                try {
                    modelsFacade.getUser().changeName(loginPageView.getJTextField().getText());
                    ServerListController serverListController = new ServerListController(); //Goto controller for server list
                    loginPageView.removeView(); //Remove elements from login panel
                    removeLoginPage();
                } catch (RuntimeException exception) {
                    JOptionPane.showMessageDialog(universalFrame, exception.getMessage());
                }
            }
        });
        loginPageView.getJButton().removeActionListener(this);
    }


    public void removeLoginPage() {
        universalFrame.remove(loginPageView.getJPanel());
        universalFrame.setVisible(false);
    }
}
