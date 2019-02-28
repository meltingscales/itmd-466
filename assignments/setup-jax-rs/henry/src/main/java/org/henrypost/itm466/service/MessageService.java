package org.henrypost.itm466.service;

import org.henrypost.itm466.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageService {


    public List<Message> getMessages() {
        return new ArrayList<Message>() {{
            new Message(1, "potato", new Date(), "henry");
        }};
    }
}
