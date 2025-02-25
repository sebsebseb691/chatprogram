package controllers;

import javax.swing.*;
import java.awt.event.*;
import views.LoginPageView;
import models.ModelsFacade;

/**
 * The {@code LoginPageController} class manages user interactions with the login page.
 * It serves as the controller in the MVC pattern, handling user authentication
 * and navigating to the next appropriate view.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Displaying the login page if no username is set</li>
 *   <li>Handling user login attempts</li>
 *   <li>Managing transitions to the server list view upon successful login</li>
 * </ul>
 */
public class LoginPageController extends JFrame implements ActionListener {
    
    private ControllersFacade controllersFacade = new ControllersFacade();
    private ModelsFacade modelsFacade = new ModelsFacade();
    private LoginPageView loginPageView = new LoginPageView();
    
    /** The shared application frame used to display the login page. */
    private JFrame universalFrame = controllersFacade.getJFrame();
    
    /**
     * Handles action events for this controller.
     * 
     * @param e the action event triggered by user interaction
     */
    public void actionPerformed(ActionEvent e) {}

    /**
     * Constructs a {@code LoginPageController} and displays the login page
     * if the user has not yet set a username.
     */
    public LoginPageController() {
        if (modelsFacade.getUser().getUsername().isEmpty()) createLoginPage();
    }

    /**
     * Creates and displays the login page UI.
     * Sets up the login panel within the main application frame.
     */
    public void createLoginPage() {
        loginPageView.createView();
        universalFrame.add(loginPageView.getJPanel());
        universalFrame.setSize(300, 150);
        universalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        universalFrame.setVisible(true);
        addListenerLoginPage();
    }

    /**
     * Adds an action listener to the login button.
     * Handles user login attempts and transitions to the server list if successful.
     */
    public void addListenerLoginPage() {
        loginPageView.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    modelsFacade.getUser().changeName(loginPageView.getJTextField().getText());
                    ServerListController serverListController = new ServerListController();
                    loginPageView.removeView();
                    removeLoginPage();
                } catch (RuntimeException exception) {
                    JOptionPane.showMessageDialog(universalFrame, exception.getMessage());
                }
            }
        });
        loginPageView.getJButton().removeActionListener(this);
    }

    /**
     * Removes the login page from the display and hides the window.
     */
    public void removeLoginPage() {
        universalFrame.remove(loginPageView.getJPanel());
        universalFrame.setVisible(false);
    }
}