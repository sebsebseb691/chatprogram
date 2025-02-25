package controllers;

import javax.swing.JFrame;

/**
 * The {@code ControllersFacade} class provides a central access point for managing
 * the application's main frame.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Initializing the main application window</li>
 *   <li>Providing access to the shared JFrame instance</li>
 * </ul>
 */
public class ControllersFacade {
    
    /** The main application frame shared across different controllers. */
    private JFrame universalFrame;
    
    /**
     * Constructs a {@code ControllersFacade} and initializes the main application frame.
     * The frame is set with a default title and close operation.
     */
    public ControllersFacade() {
        universalFrame = new JFrame("Chat program");
        universalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        universalFrame.setVisible(true);
    }

    /**
     * Returns the shared application frame.
     * 
     * @return the main {@code JFrame} instance
     */
    public JFrame getJFrame() {
        return universalFrame;
    }
}
