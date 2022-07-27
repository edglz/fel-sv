package servicio;

import org.glassfish.grizzly.http.server.HttpServer;

import java.io.Serializable;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();

        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testGetIt() {
        String responseMsg = target.path("felsv").request().get(String.class);
        assertEquals("Got it! (CAMBIO).", responseMsg);
    }

}
