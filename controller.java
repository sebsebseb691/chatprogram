import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import views.LoginPage;
import views.ChatRoom;


public class Controller extends JFrame implements ActionListener {
    private User u = new User();
    private JFrame f;
    private LoginPage lp;
    private ChatRoom cr;
    public void actionPerformed(ActionEvent e) {}

    public Controller() {
        //Show login page if first time starting
        if (u.getUsername().isEmpty()) createLoginPage();
    }


    //Create frame for login page and create login page object
    public void createLoginPage() {
        f = new JFrame("Chatprogram");
        lp = new LoginPage();

        f.add(lp.getJPanel());

        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        addListenerLoginPage();
    }

    //Add action listener to login page
    public void addListenerLoginPage() {
        lp.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Try to change username, if it fails show error message, if it succeeds remove login page
                try {
                    u.changeName(lp.getJTextField().getText());
                    lp.RemoveLoginPage();
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
                createChatRoom(); //temp
            }
        });
        lp.getJButton().removeActionListener(this);
    }


    public void createChatRoom() {
        //Code to get all messages and send to chatroom

        f.setSize(600, 300);
        cr = new ChatRoom();
        f.add(cr.getJPanel());

        addListenerChatRoom();
    }


    public void addListenerChatRoom() {
        cr.getJButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message m = new Message(cr.getJTextField().getText());
                } catch (RuntimeException exc) {
                    JOptionPane.showMessageDialog(f, exc.getMessage());
                }
            }
        });
        cr.getJButton().removeActionListener(this);
    }

}
