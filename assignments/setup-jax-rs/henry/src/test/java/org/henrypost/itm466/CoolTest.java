package org.henrypost.itm466;

import junit.framework.TestCase;
import org.henrypost.itm466.model.Message;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.valid4j.matchers.http.HttpResponseMatchers.hasEntity;
import static org.valid4j.matchers.http.HttpResponseMatchers.hasStatus;

// Statically import the library entry point:

public class CoolTest extends TestCase {

    static int port = 8080;
    static String scheme = "http";
    static String host = "localhost";
    static String endpoint = "henry/webapi";

    static String baseURL = String.format("%s://%s:%d/%s", scheme, host, port, endpoint);

    @Test
    public void testSimple() {
        Client client = ClientBuilder.newClient();

        Response response = client.target(String.format("%s/myresource", baseURL)).request(MediaType.TEXT_PLAIN).get();

        assertThat(response, hasStatus(Response.Status.OK));
        assertThat(response, hasEntity(equalTo("Got it!")));

    }

    @Test
    public void testInsertMessage() {
        Client client = ClientBuilder.newClient();

        Message message = new Message(-1L, "Testing!", "tester");

        Entity<Message> messageEntity = Entity.json(message);

        Response response = client.target(String.format("%s/message", baseURL)).request(MediaType.APPLICATION_JSON).post(messageEntity);

        assertThat(response, hasEntity());
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }

}
