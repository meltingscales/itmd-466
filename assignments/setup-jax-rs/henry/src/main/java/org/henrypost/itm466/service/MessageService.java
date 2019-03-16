package org.henrypost.itm466.service;

import org.henrypost.itm466.database.DatabaseClass;
import org.henrypost.itm466.model.Message;

import java.util.*;

public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        if (messages.values().size() <= 0) {
            addMessage(new Message(-1L, "Hello there!", "HenryFBP"));
            addMessage(new Message(-1L, "I am the Java Master!", "JavaMaster"));
            addMessage(new Message(-1L, "2016 was so lame!", "HenryFBP", new Date(1458093627L * 1000)));
            addMessage(new Message(-1L, "I liked 2016.", "JavaMaster", new Date(1458093627L * 1000)));
            addMessage(new Message(-1L, "2017 is awesome!", "HenryFBP", new Date(1489629627L * 1000)));
            addMessage(new Message(-1L, ":(", "Dave", new Date(1552701627L * 1000)));
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

    public ArrayList<Message> getAllMessagesForYear(int year) {

        ArrayList<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for (Message message : messages.values()) {
            calendar.setTime(Objects.requireNonNull(message.getCreated()));

            if (calendar.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }

        }
        return messagesForYear;
    }

    public List<Message> getAllMessagePaginated(int start, int size) {
        ArrayList<Message> list = new ArrayList<>(messages.values());

        if (start + size > list.size()) {
            return new ArrayList<>();
        }

        return list.subList(start, start + size);
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
