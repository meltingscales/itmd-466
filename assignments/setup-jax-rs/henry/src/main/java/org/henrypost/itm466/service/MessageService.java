package org.henrypost.itm466.service;

import org.henrypost.itm466.database.DatabaseClass;
import org.henrypost.itm466.model.Message;

import java.util.ArrayList;
import java.util.Map;

public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        if (getAllMessages().size() <= 0) {
            addMessage(new Message(-1L, "Hello there!", "HenryFBP"));
            addMessage(new Message(-1L, "I am the Java Master!", "JavaMaster"));
        }
    }

    /***
     * @return A list of messages.
     */
    public ArrayList<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId((long) (messages.size() + 1));
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {

        if (message.getId() <= 0) {
            return null;
        }

        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
