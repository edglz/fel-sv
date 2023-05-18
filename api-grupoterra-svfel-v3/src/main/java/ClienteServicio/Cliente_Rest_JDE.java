package ClienteServicio;

import java.io.Serializable;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class Cliente_Rest_JDE implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String BASE_URI = "http://JDE-REST-API:8017/jde/";
    private ClientConfig clientConfig;
    private Client client;

    public Cliente_Rest_JDE() {
        try {
            this.clientConfig = new ClientConfig();
            this.clientConfig.register(String.class);
            this.client = ClientBuilder.newClient(this.clientConfig);
        } catch (Exception ex) {
            System.out.println("CLASE: " + this.getClass().getName() + " METODO: Cliente_Rest_Menu ERROR: " + ex.toString());
        }
    }

    public String obetener_texto_encabezado_orden_ventas(String division, String ambiente, String DOCO_JDE, String DCTO_JDE, String KCOO_JDE) {
        String resultado = "";

        try {
            WebTarget webTarget = this.client.target(BASE_URI).path("obetener_texto_encabezado_orden_ventas/" + division + "/" + ambiente + "/" + DOCO_JDE + "/" + DCTO_JDE + "/" + KCOO_JDE);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            System.out.println("CONEXION JDE-REST-API" + response.getStatus());
            if (response.getStatus() == 200) {
                resultado = response.readEntity(String.class);
            } else {
                resultado = response.getStatus() + ": " + response.getStatusInfo();
            }
        } catch (Exception ex) {
            resultado = ex.toString();
        }

        return resultado;
    }

}
