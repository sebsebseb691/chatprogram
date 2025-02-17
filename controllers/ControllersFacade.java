package controllers;

import javax.swing.JFrame;

public class ControllersFacade {
    private JFrame f;
    
    public ControllersFacade() {
        f = new JFrame("Chat program");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public JFrame getJFrame() {return f;}
}
