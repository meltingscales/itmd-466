package org.henrypost.itm466.resources;

import org.henrypost.itm466.model.Message;
import org.henrypost.itm466.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/message")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Response.Status addMessage(Message message) {
        messageService.addMessage(message);

        return Response.Status.ACCEPTED;
        }

    @DELETE
    @Path("{id}")
    public Message deleteMessageByID(@PathParam("id") long id) {
        return messageService.removeMessage(id);
    }
}
