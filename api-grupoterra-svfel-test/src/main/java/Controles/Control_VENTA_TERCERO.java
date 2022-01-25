package Controles;

import Entidades.JsonOut.VENTA_TERCERO_OUT;
import java.io.Serializable;
import java.sql.Connection;

public class Control_VENTA_TERCERO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_VENTA_TERCERO() {
    }

    public VENTA_TERCERO_OUT registro_json_venta_tercero(Connection conn, Long id_dte) {
        VENTA_TERCERO_OUT resultado = null;

        try {

        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_venta_tercero | Error: " + ex.toString());
        }

        return resultado;
    }

}
