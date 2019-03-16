package org.henrypost.itm466.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

    @GET
    public String test() {
        return "test";
    }

    @GET
    @Path("/{commentId}")
    public String test2(@PathParam("commentId") long commentId) {
        return String.format("test2 %d", commentId);
    }
}
