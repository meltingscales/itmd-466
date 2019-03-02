package org.henrypost.itm466;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.henrypost.itm466.model.Message;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import java.util.List;

public class CoolTest extends JerseyTest {

    @Test
    public void testGetMessages() {

        WebTarget target = target("/message");

        System.out.println(target.getUri());

        final List<Message> hello = target.request().get(List.class);

        assert (hello.get(0).getMessage().equals("1st :)"));

    }

    @Override
    protected Application configure() {

        return new ResourceConfig(CoolTest.class);
    }
}
