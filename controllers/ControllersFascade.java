package controllers;

import javax.swing.JFrame;

public class ControllersFascade {
    private JFrame f;
    
    public ControllersFascade() {
        f = new JFrame("Chatprogram");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public JFrame getJFrame() {return f;}
}
