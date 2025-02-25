package controllers;

public interface Controller_Interface {
    /**
     * Create a view and add the view's JPanel to a JFrame, also the JFrame visible
     */
    public void addPanelToFrame();

    public void initalize();

    /**
     * Add a listener to a JButton
     */
    public void addListener();
}
