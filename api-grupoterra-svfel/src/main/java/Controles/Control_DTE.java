package Controles;

import Entidades.JsonIn.DTE_IN;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

public class Control_DTE implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_DTE() {
    }

    public Long registro_db_tabla_dte(Connection conn, DTE_IN dte_in) {
        Long resultado = Long.parseLong("0");
        Driver driver = new Driver();

        try {
            Long id_dte = driver.ObtenerLong("SELECT NVL(MAX(F.ID_DTE), 0) + 1 MAXIMO FROM FEL_SV_TBL_DTE F", conn);
            Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_EMISOR_KCOO F WHERE TRIM(F.KCOO_JDE) = '" + dte_in.getKcoo_jde() + "'", conn);

            String cadenasql = "INSERT INTO FEL_SV_TBL_DTE ("
                    + "ID_DTE, "
                    + "KCOO_JDE, "
                    + "MCU_JDE, "
                    + "DOCO_JDE, "
                    + "DCTO_JDE, "
                    + "DOC_JDE, "
                    + "DCT_JDE, "
                    + "AN8_JDE, "
                    + "SHAN_JDE, "
                    + "CRCD_JDE, "
                    + "IVD_JDE, "
                    + "ID_EMISOR, "
                    + "RESPONSE_VERSION, "
                    + "RESPONSE_AMBIENTE, "
                    + "RESPONSE_VERSIONAPP, "
                    + "RESPONSE_ESTADO, "
                    + "RESPONSE_CODIGOGENERACION, "
                    + "RESPONSE_NUMVALIDACION, "
                    + "RESPONSE_FHPROCESAMIENTO, "
                    + "RESPONSE_CODIGOMSG, "
                    + "RESPONSE_DESCRIPCIONMSG, "
                    + "RESPONSE_OBSERVACIONES) VALUES ("
                    + id_dte + ",'"
                    + dte_in.getKcoo_jde() + "','"
                    + dte_in.getMcu_jde() + "','"
                    + dte_in.getDoco_jde() + "','"
                    + dte_in.getDcto_jde() + "','"
                    + dte_in.getDoc_jde() + "','"
                    + dte_in.getDct_jde() + "','"
                    + dte_in.getAn8_jde() + "','"
                    + dte_in.getShan_jde() + "','"
                    + dte_in.getCrcd_jde() + "','"
                    + dte_in.getIvd_jde() + "',"
                    + id_emisor + ","
                    + "0" + ",'"
                    + "-" + "',"
                    + "0" + ",'"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "')";
            Statement stmt = conn.createStatement();
            // System.out.println("******************** FEL_SV_TBL_DTE: " + cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();

            resultado = id_dte;
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_dte | Error: " + ex.toString());
        }

        return resultado;
    }

}
