package ClienteServicio;

import java.io.InputStream;
import java.io.Serializable;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class Cliente_Rest_Jasper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String j_username = "jasperadmin";
    private String j_password = "jasperadmin";

    private static final String BASE_URI = "http://10.254.7.203:9292/jasperserver/rest_v2";
    private ClientConfig clientConfig;
    private Client client;

    public Cliente_Rest_Jasper() {
        try {
            this.clientConfig = new ClientConfig();
            this.clientConfig.register(String.class);
            this.client = ClientBuilder.newClient(this.clientConfig);
        } catch (Exception ex) {
            System.out.println("CLASE: " + this.getClass().getName() + " METODO: Cliente_Rest_Jasper ERROR: " + ex.toString());
        }
    }

    public InputStream reporte_ccf_pdf(String id_dte) {
        InputStream resultado;

        try {
            WebTarget webTarget = this.client.target(BASE_URI)
                    .path("reports/FELSV/DTEs/Formato_CCF.pdf")
                    .queryParam("id_dte", id_dte)
                    .queryParam("j_username", j_username)
                    .queryParam("j_password", j_password);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
            Response response = invocationBuilder.get();
            System.out.println("Cliente JasperRest: " + response.getStatus());
            if (response.getStatus() == 200) {
                resultado = response.readEntity(InputStream.class);
            } else {
                resultado = null;
            }
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR (" + this.getClass().getName() + " - reporte_ccf_pdf):" + ex.toString());
        }

        return resultado;
    }
    
    public InputStream reporte_nc_pdf(String id_dte) {
        InputStream resultado;

        try {
            WebTarget webTarget = this.client.target(BASE_URI)
                    .path("reports/FELSV/DTEs/Formato_NC.pdf")
                    .queryParam("id_dte", id_dte)
                    .queryParam("j_username", j_username)
                    .queryParam("j_password", j_password);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
            Response response = invocationBuilder.get();
            System.out.println("Cliente JasperRest: " + response.getStatus());
            if (response.getStatus() == 200) {
                resultado = response.readEntity(InputStream.class);
            } else {
                resultado = null;
            }
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR (" + this.getClass().getName() + " - reporte_nc_pdf):" + ex.toString());
        }

        return resultado;
    }
    
    public InputStream reporte_nd_pdf(String id_dte) {
        InputStream resultado;

        try {
            WebTarget webTarget = this.client.target(BASE_URI)
                    .path("reports/FELSV/DTEs/Formato_ND.pdf")
                    .queryParam("id_dte", id_dte)
                    .queryParam("j_username", j_username)
                    .queryParam("j_password", j_password);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
            Response response = invocationBuilder.get();
            System.out.println("Cliente JasperRest: " + response.getStatus());
            if (response.getStatus() == 200) {
                resultado = response.readEntity(InputStream.class);
            } else {
                resultado = null;
            }
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR (" + this.getClass().getName() + " - reporte_nd_pdf):" + ex.toString());
        }

        return resultado;
    }

}
