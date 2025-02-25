package views;

import javax.swing.*;

/**
 * The {@code LoginPageView} class represents the graphical user interface for the login page.
 * It extends {@code JPanel} and implements the {@code View} interface.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Creating and displaying the login interface</li>
 *   <li>Providing access to UI components for interaction</li>
 *   <li>Allowing removal of the login page view</li>
 * </ul>
 */
public class LoginPageView extends JPanel implements View {
    
    /** The main panel containing login elements. */
    private JPanel loginPanel = new JPanel();
    
    /** Label prompting the user to enter a username. */
    private JLabel enterUsername = new JLabel("Username: ");
    
    /** Text field for user input of the username. */
    private JTextField userNameF = new JTextField(20);
    
    /** Button to confirm and set the username. */
    private JButton loginButton = new JButton("Set username");
    
    /**
     * Creates the login page view by adding UI components to the panel.
     */
    public void createView() {
        loginPanel.add(enterUsername);
        loginPanel.add(userNameF);
        loginPanel.add(loginButton);
        loginPanel.repaint();
    }

    /**
     * Removes all components from the login panel and repaints it.
     */
    public void removeView() {
        loginPanel.removeAll();
        loginPanel.repaint();
    }

    /**
     * Returns the main login panel.
     * 
     * @return the login panel
     */
    public JPanel getJPanel() {
        return loginPanel;
    }

    /**
     * Returns the login button.
     * 
     * @return the login button component
     */
    public JButton getJButton() {
        return loginButton;
    }

    /**
     * Returns the username input field.
     * 
     * @return the username text field
     */
    public JTextField getJTextField() {
        return userNameF;
    }
}
