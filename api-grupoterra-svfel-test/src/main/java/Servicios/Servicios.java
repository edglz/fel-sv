package Servicios;

import Controles.Control_FelSV;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("felsv")
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;

    @POST
    @Path("recepcion-dte")
    @Produces({"application/json"})
    public String recepcion_dte(
            String jsonString) {
        
        String resultado = "";

        try {
            String ambiente = "test";
            Control_FelSV control_felsv = new Control_FelSV();
            resultado = control_felsv.recepcion_dte(jsonString, ambiente);
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString());
            resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString();
        }

        return resultado;
    }
    
    @POST
    @Path("extraer-recepcion-dte")
    @Produces({"application/json"})
    public String extraer_recepcion_dte(
            String jsonString) {
        
        String resultado = "";

        try {
            String ambiente = "test";
            Control_FelSV control_felsv = new Control_FelSV();
            resultado = control_felsv.extraer_recepcion_dte(jsonString, ambiente);
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString());
            resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString();
        }

        return resultado;
    }
    
}
