package controllers;

/**
 * Interface that every controller implements. Adds JPanel to the JFrame and adds listeners on buttons from view
 */
public interface ControllerInterface {
    /**
     * Create a view and add the view's JPanel to a JFrame, also the JFrame visible
     */
    public void addPanelToFrame();

    /**
     * Add a listener to a JButton
     */
    public void addListener();

    /**
     * Add listeners to many JButtons
     */
    public void addListeners();
}
