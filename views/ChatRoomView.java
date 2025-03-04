package views;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import models.ModelsFacade;
import models.MessageInterface;


public class ChatRoomView extends JPanel implements View, observers.ViewObserver {
    private JPanel mainP = new JPanel(new BorderLayout());
    private JPanel messageP = new JPanel(new BorderLayout()); //Messages panel
    private JTextField messageF = new JTextField(30);
    private JButton sendB = new JButton("Send");
    private JButton sendImageB = new JButton("Send Image");
    private JButton backB = new JButton("Back");
    private ModelsFacade mf = ModelsFacade.getInstance();


    public void createView() {
        createView("No chat name");
    }


    public void createView(String chatName) {
        //Add panels to main panel
        mainP.add(createTopPanel(chatName), BorderLayout.NORTH);
        mainP.add(createBottomPanel(), BorderLayout.SOUTH);
        mainP.add(createMessagePanel(), BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainP, BorderLayout.CENTER);
        this.repaint();

        mf.getChatRoom().addObserver(this); //Add self to observer list
        update(); //Update to see messages
    }


    public JPanel createTopPanel(String chatName) {
        JLabel chatNameL = new JLabel();
        chatNameL.setText("Connected to Chat Room: " + chatName);
        chatNameL.setFont(new Font("Calibri", Font.BOLD, 30));
        chatNameL.setAlignmentX(LEFT_ALIGNMENT);

        JLabel usernameL = new JLabel();
        usernameL.setText("Username: " + mf.getUser().getUsername());
        usernameL.setFont(new Font("Calibri", Font.BOLD, 20));
        usernameL.setAlignmentX(LEFT_ALIGNMENT);

        //Panel for chatname and username
        JPanel labelsP = new JPanel();
        labelsP.setLayout(new BoxLayout(labelsP, BoxLayout.Y_AXIS));
        labelsP.add(chatNameL);
        labelsP.add(usernameL);
        labelsP.setBackground(Color.LIGHT_GRAY);

        //Top panel
        JPanel topP = new JPanel(); 
        topP.setLayout(new BorderLayout());
        topP.add(labelsP, BorderLayout.WEST);
        topP.setBackground(Color.LIGHT_GRAY);

        //Panel for back button
        JPanel backP = new JPanel();
        backP.setBackground(Color.LIGHT_GRAY);
        backP.add(backB);
        topP.add(backP, BorderLayout.EAST);

        return topP;
    }


    //Bottom panel, message input and send button
    public JPanel createBottomPanel() {
        JPanel bottomP = new JPanel(new FlowLayout()); //Panel for message input
        bottomP.add(messageF, BorderLayout.WEST);
        sendB.setPreferredSize(new Dimension(80, 18));
        bottomP.add(sendB, BorderLayout.EAST);
        bottomP.add(sendImageB, BorderLayout.EAST);  

        return bottomP;
    }


    public JScrollPane createMessagePanel() {
        messageP.setLayout(new BoxLayout(messageP, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(messageP);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return scroll;
    }


    public void displayMessage(String username, String msg) {
        JLabel message = new JLabel(username + ": " + msg);
        message.setOpaque(true);
        message.setBackground(Color.WHITE);
        Border b = new LineBorder(Color.LIGHT_GRAY, 2);
        message.setBorder(b);
        messageP.add(message);
    }

    public void displayImage(String username, BufferedImage image) {
           System.out.println("Displaying image for user: ");
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.WHITE);
            Border b = new LineBorder(Color.LIGHT_GRAY, 2);
            imageLabel.setBorder(b);
            messageP.add(imageLabel);
    }

    public void update() {
        messageP.removeAll();

        for (MessageInterface i : mf.getChatRoom().getMessages()) {
            displayMessage(i.getUser(), i.getMsg());
             if (i.getImage() != null) {
                System.out.println("Image found for user: ");
               displayImage(i.getUser(), i.getImage());
            }
        }
    
        messageP.revalidate();
        messageP.repaint();
    }
    

    public JPanel getJPanel() {return mainP;}
    public JButton getJButton() {return sendB;}
    public JButton getBackButton() {return backB;}
    public JTextField getJTextField() {return messageF;}
    public JButton getSendImageButton() {return sendImageB;}
}
