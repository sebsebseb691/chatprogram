package models;

import java.util.LinkedList;

/**
 * The {@code ChatroomModel} class represents a chat room where users can join
 * and exchange messages.
 * 
 * <p>This class is responsible for:</p>
 * <ul>
 *   <li>Storing chat room details such as its name</li>
 *   <li>Managing a list of messages sent in the chat room</li>
 *   <li>Keeping track of users who have joined the chat room</li>
 * </ul>
 */
public class ChatroomModel {
    
    /** The name of the chat room. */
    private String chatName;
    
    /** The list of messages exchanged in the chat room. */
    private LinkedList<Message> messageList = new LinkedList<Message>(); 
    
    /** The list of users who have joined the chat room. */
    private LinkedList<User> userList = new LinkedList<User>();

    /**
     * Constructs a {@code ChatroomModel} with the specified chat room name.
     * 
     * @param chatName the name of the chat room
     * @throws RuntimeException if the chat name is empty
     */
    public ChatroomModel(String chatName) {
        if (chatName.isEmpty()) {
            throw new RuntimeException("Chatname cannot be empty");
        } else {
            this.chatName = chatName;
        }
    }

    /**
     * Adds a message to the chat room's message list.
     * 
     * @param message the message to be added
     */
    public void addMessage(Message message) {
        messageList.add(message);
    }

    /**
     * Adds the current user to the chat room if they are not already present.
     */
    public void joinChatRoom() {
        ModelsFacade modelsFacade = new ModelsFacade();
        if (!userList.contains(modelsFacade.getUser())) {
            userList.add(modelsFacade.getUser());
        }
    }

    /**
     * Returns the name of the chat room.
     * 
     * @return the chat room name
     */
    public String getChatName() {
        return chatName;
    }

    /**
     * Returns the current chat room instance.
     * 
     * @return this chat room model instance
     */
    public ChatroomModel getChatRoom() {
        return this;
    }
}
