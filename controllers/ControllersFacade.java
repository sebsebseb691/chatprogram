package controllers;

import javax.swing.JFrame;

public class ControllersFacade {
    private static JFrame f; //Funkar tydligen bara om man har static
    
    public ControllersFacade() {
        f = new JFrame("Chatprogram");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static JFrame getJFrame() {return f;}
}
