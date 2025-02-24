package controllers;

import javax.swing.JFrame;

public class ControllersFacade {
    private JFrame universalFrame;
    
    public ControllersFacade() {
        universalFrame = new JFrame("Chat program");
        universalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        universalFrame.setVisible(true);
    }

    public JFrame getJFrame() {return universalFrame;}
}
