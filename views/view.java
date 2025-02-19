package views;

public interface View {
    /**
     * Create a view and add components to one or more panels
     */
    public void createView();
    /**
     * Remove all components from one or more panels and repaint
     */
    public void removeView();
}
