package controllers;

import javax.swing.JFrame;

public class ControllersFascade {
    private static JFrame f; //Funkar bara om man har static
    
    public ControllersFascade() {
        f = new JFrame("Chatprogram");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static JFrame getJFrame() {return f;}
}
