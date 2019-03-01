package org.henrypost.itm466.resources;

import org.henrypost.itm466.model.Message;
import org.henrypost.itm466.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/message")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

}
