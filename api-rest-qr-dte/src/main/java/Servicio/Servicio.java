package Servicio;

import ClienteServicio.Cliente_Rest_Jasper;
import java.io.InputStream;
import java.io.Serializable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("servicio")
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @GET
    @Path("get-it")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        System.out.println("Got it!");
        return "Got it!";
    }

    @GET
    @Path("qr-dte/{id_dte}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response qr_dte(@PathParam("id_dte") Long id_dte) {
        try {
            Cliente_Rest_Jasper cliente_rest_jasper = new Cliente_Rest_Jasper();
            InputStream inputstream = cliente_rest_jasper.reporte_pdf(id_dte.toString());
            
            ResponseBuilder responseBuilder = Response.ok(inputstream);
            responseBuilder.header("Content-Disposition", "filename=dte" + id_dte + ".pdf");
            return responseBuilder.build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
