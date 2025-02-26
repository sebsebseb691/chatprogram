package views;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import models.Message;
import models.ModelsFacade;


public class ChatRoom_View extends JPanel implements View, observers.ViewObserver {
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel messagePanel = new JPanel(new BorderLayout()); //Messages panel

    private JTextField messageField = new JTextField(30);
    private JButton sendButton = new JButton("Send");
    private JButton backButton = new JButton("Back");
    private ModelsFacade modelsFacade = ModelsFacade.getInstance();


    public void createView() {
        createView("No chat name");
    }

    public void createView(String chatName) {
        JLabel chatNameL = new JLabel();
        chatNameL.setText("Connected to Chat Room: " + chatName);
        chatNameL.setFont(new Font("Calibri", Font.BOLD, 30));
        chatNameL.setAlignmentX(LEFT_ALIGNMENT);

        JLabel usernameL = new JLabel();
        usernameL.setText("Username: " + modelsFacade.getUser().getUsername());
        usernameL.setFont(new Font("Calibri", Font.BOLD, 20));
        usernameL.setAlignmentX(LEFT_ALIGNMENT);

        //Panel for chatname and username
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(chatNameL);
        labelsPanel.add(usernameL);
        labelsPanel.setBackground(Color.LIGHT_GRAY);

        //Top panel
        JPanel topPanel = new JPanel(); 
        topPanel.setLayout(new BorderLayout());
        topPanel.add(labelsPanel, BorderLayout.WEST);
        topPanel.setBackground(Color.LIGHT_GRAY);

        //Panel for back button
        JPanel backPanel = new JPanel();
        backPanel.setBackground(Color.LIGHT_GRAY);
        backPanel.add(backButton);
        topPanel.add(backPanel, BorderLayout.EAST);

        //Bottom panel, message input and send button
        JPanel bottomPanel = new JPanel(new FlowLayout()); //Panel for message input
        bottomPanel.add(messageField, BorderLayout.WEST);
        sendButton.setPreferredSize(new Dimension(80, 18));
        bottomPanel.add(sendButton, BorderLayout.EAST);

        //Scroll
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(messagePanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Add panels to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(scroll, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
        this.repaint();

        modelsFacade.getChatRoom().addObserver(this); //Add self to observer list
        update(); //Update to see messages
    }

    public void displayMessage(String username, String msg) {
        JLabel message = new JLabel(username + ": " + msg);
        message.setOpaque(true);
        message.setBackground(Color.WHITE);
        Border border = new LineBorder(Color.LIGHT_GRAY, 2);
        message.setBorder(border);
        messagePanel.add(message);
    }


    public void update() {
        messagePanel.removeAll();

        for (Message i : modelsFacade.getChatRoom().getMessages()) {
            displayMessage(i.getUser(), i.getMsg());
        }
    
        messagePanel.revalidate();
        messagePanel.repaint();
    }
    

    public JPanel getJPanel() {return mainPanel;}
    public JButton getJButton() {return sendButton;}
    public JButton getBackButton() {return backButton;}
    public JTextField getJTextField() {return messageField;}
}
