package views;
import javax.swing.JPanel;

/**
 * Adds elements to different JPanels, adds itself to a observer 
 */
public interface View{
    /**
     * Create a view with JPanels and add components to one or more panels
     */
    public void createView();

    /**
     * Get the main JPanel created
     * @return the main JPanel that should be added to the frame
     */
    public JPanel getJPanel();
}
