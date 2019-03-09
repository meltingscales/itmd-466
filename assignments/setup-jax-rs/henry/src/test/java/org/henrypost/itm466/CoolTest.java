package org.henrypost.itm466;

import junit.framework.TestCase;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.valid4j.matchers.http.HttpResponseMatchers.hasEntity;
import static org.valid4j.matchers.http.HttpResponseMatchers.hasStatus;

// Statically import the library entry point:

public class CoolTest extends TestCase {


    static String baseURL = "http://localhost:8080/henry/webapi";

    @Override
    protected void setUp() {

    }

    @Test
    public void testSimple() {

        // Invoke your web service using plain JAX-RS. E.g:
        Client client = ClientBuilder.newClient();
        Response response = client.target(String.format("%s/myresource", baseURL)).request("text/plain").get();

        // Verify the response
        assertThat(response, hasStatus(Response.Status.OK));
        assertThat(response, hasEntity(equalTo("Got it!")));

    }

}
