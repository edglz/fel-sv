package Controles;

import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.APENDICE_OUT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

public class Control_APENDICE implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_APENDICE() {
    }

    public void registro_db_tabla_apendice(Connection conn, DTE_IN dte_in, Long id_dte) {
        try {
            for (Integer i = 0; i < dte_in.getApendice().getItems().size(); i++) {
                Long id_apendice = Long.parseLong(i.toString());
                id_apendice++;

                String cadenasql = "INSERT INTO FEL_SV_TBL_APENDICE ("
                        + "ID_DTE,"
                        + "ID_APENDICE,"
                        + "ITEM) VALUES ("
                        + id_dte + ","
                        + id_apendice + ",'"
                        + dte_in.getApendice().getItems().get(i) + "')";
                Statement stmt = conn.createStatement();
                // System.out.println("******************** FEL_SV_TBL_APENDICE: " + cadenasql);
                stmt.executeUpdate(cadenasql);
                stmt.close();
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_apendice | Error: " + ex.toString());
        }
    }

    public APENDICE_OUT registro_json_apendice(Connection conn, Long id_dte) {
        APENDICE_OUT resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new APENDICE_OUT();
            resultado.setItems(driver.ObtenerVectorString("SELECT F.ITEM FROM FEL_SV_TBL_APENDICE F WHERE F.ID_DTE=" + id_dte, conn));
            resultado = null;
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_apendice | Error: " + ex.toString());
        }

        return resultado;
    }

}
