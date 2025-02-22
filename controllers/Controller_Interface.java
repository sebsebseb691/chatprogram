package controllers;

public interface Controller_Interface {
    /**
     * Create a view and add the view's JPanel to a JFrame, also the JFrame visible
     */
    public void addPanelToFrame();

    /**
     * Remove a view's JPanel from the JFrame and set the JFrame to not visible
     */
    public void removePanelFromFrame();

    /**
     * Add a listener to a JButton
     */
    public void addListener();

    /**
     * Add listeners to many JButtons
     */
    public void addListeners();
}
