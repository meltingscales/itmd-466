package org.henrypost.itm466.resources;

import org.henrypost.itm466.model.Message;
import org.henrypost.itm466.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public ArrayList<Message> getAllMessages(@QueryParam("year") int year) {

        if (year > 0) {
            return messageService.getAllMessagesForYear(year);
        }

        return new ArrayList<>(messageService.getAllMessages());
    }


    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId) {
        return messageService.getMessage(messageId);
    }

    @DELETE
    @Path("/{messageId}")
    public Message deleteMessage(@PathParam("messageId") long messageId) {
        return messageService.removeMessage(messageId);
    }
}
