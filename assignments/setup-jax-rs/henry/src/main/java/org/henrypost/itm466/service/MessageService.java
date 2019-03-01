package org.henrypost.itm466.service;

import org.henrypost.itm466.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    private List<Message> messages = new ArrayList<Message>() {{
        add(new Message(1L, "1st :)", "henry"));
    }};

    /***
     * @return A list of messages.
     */
    public List<Message> getMessages() {
        return messages;
    }

    /***
     * Adds a message to the list of messages.
     * @param message a message.
     */
    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
