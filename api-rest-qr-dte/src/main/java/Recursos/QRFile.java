package Recursos;

import ClienteServicio.Cliente_Rest_Jasper;
import Controladores.Ctrl_Base_Datos;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("qr-file")
public class QRFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @GET
    @Path("get-it")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        System.out.println("Got it!");
        return "Got it!";
    }

    @GET
    @Path("{ambiente}/{numvalidacion}/{codigogeneracion}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response qr_dte(
            @PathParam("ambiente") String ambiente,
            @PathParam("numvalidacion") String numvalidacion,
            @PathParam("codigogeneracion") String codigogeneracion) {
        
        Connection conn = null;
        
        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            conn = ctrl_base_datos.obtener_conexion(ambiente);
            
            conn.setAutoCommit(false);
            
            Long id_dte = ctrl_base_datos.ObtenerLong("SELECT F.ID_DTE FROM DTE_CCF_V3 F WHERE F.RESPONSE_NUMVALIDACION='" + numvalidacion + "' AND F.RESPONSE_CODIGOGENERACION='" + codigogeneracion + "'", conn);
            
            Cliente_Rest_Jasper cliente_rest_jasper = new Cliente_Rest_Jasper();
            InputStream inputstream = cliente_rest_jasper.reporte_pdf(id_dte.toString());
            ResponseBuilder responseBuilder = Response.ok(inputstream);
            responseBuilder.header("Content-Disposition", "filename=dte" + id_dte + ".pdf");
            return responseBuilder.build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:selecionar_documentos_v3()-finally|ERROR:" + ex.toString());
            }
        }
    }
    
}
