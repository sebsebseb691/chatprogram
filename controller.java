import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.lang.*;


public class Controller extends JFrame implements ActionListener {
    ClientModel cModel;
    LoginPage lp;
    JFrame f;
    JPanel p;

    public void actionPerformed(ActionEvent e) {}

    public void loginPage() {
        lp.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cModel.changeName(lp.userNameF.getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
                lp.loginPage(p);
                p.repaint();
            }
        });
    }

}
