package org.henrypost.itm466.resources;

import org.henrypost.itm466.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessages() {
        return messageService.getMessages().toString();
    }

}
