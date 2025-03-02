package controllers;
import javax.swing.*;
import java.awt.event.*;
import views.LoginPageView;
import models.ModelsFacade;


public class LoginPageController implements ActionListener, ControllerInterface {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private ControllersFacade cf = new ControllersFacade();
    private JFrame f = cf.getJFrame();
    private LoginPageView lp = new LoginPageView();
    public void actionPerformed(ActionEvent e) {}


    @Override
    public void addPanelToFrame() {
        lp.createView();

        f.add(lp.getJPanel());
        f.setSize(300, 150);
        f.setVisible(true);

        addListener();
    }
    

    @Override
    public void addListener() {
        lp.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Try to change username, if it fails show error message, if it succeeds remove login page
                try {
                    mf.getUser().changeName(lp.getJTextField().getText());
                    cf.openServerList(); //Name changed, now show server list

                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
    }

    @Override
    public void initalize() {
        
    }
}
