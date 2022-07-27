package Controles;

import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.EXTENSION_OUT;
import Entidades.JsonOut.EXTENSION_OUT_NC;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

public class Control_EXTENSION implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_EXTENSION() {
    }

    public void registro_db_tabla_extension(Connection conn, DTE_IN dte_in, Long id_dte) {
        try {
            Long id_extension = Long.parseLong("1");

            String cadenasql = "INSERT INTO FEL_SV_TBL_EXTENSION ("
                    + "ID_DTE,"
                    + "ID_EXTENSION,"
                    + "TOTALITEMS,"
                    + "TOTALDESCU,"
                    + "NOMBENTREGA,"
                    + "DOCUENTREGA,"
                    + "CODEMPLEADO,"
                    + "NOMBRECIBE,"
                    + "DOCURECIBE,"
                    + "OBSERVACIONES,"
                    + "PLACAVEHICULO,"
                    + "AUTOFITOSANITARIA) VALUES ("
                    + id_dte + ","
                    + id_extension + ","
                    + dte_in.getExtension().getTotalItems() + ","
                    + dte_in.getExtension().getTotalDescu() + ",'"
                    + dte_in.getExtension().getNombEntrega() + "','"
                    + dte_in.getExtension().getDocuEntrega() + "','"
                    + dte_in.getExtension().getCodEmpleado() + "','"
                    + dte_in.getExtension().getNombRecibe() + "','"
                    + dte_in.getExtension().getDocuRecibe() + "','"
                    + dte_in.getExtension().getObservaciones() + "','"
                    + dte_in.getExtension().getPlacaVehiculo() + "','"
                    + dte_in.getExtension().getAutoFitoSanitaria() + "')";
            Statement stmt = conn.createStatement();
            // System.out.println("******************** FEL_SV_TBL_EXTENSION: " + cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_extension | Error: " + ex.toString());
        }
    }

    public EXTENSION_OUT registro_json_extension(Connection conn, Long id_dte) {
        EXTENSION_OUT resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new EXTENSION_OUT();
            resultado.setTotalItems(driver.ObtenerDouble("SELECT F.TOTALITEMS FROM FEL_SV_TBL_EXTENSION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalDescu(driver.ObtenerDouble("SELECT F.TOTALDESCU FROM FEL_SV_TBL_EXTENSION F WHERE F.ID_DTE=" + id_dte, conn));
            Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_DTE F WHERE F.ID_DTE=" + id_dte, conn);
            resultado.setNombEntrega(driver.ObtenerString("SELECT F.NOMBENTREGA FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setDocuEntrega(driver.ObtenerString("SELECT F.DOCUENTREGA FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setCodEmpleado(driver.ObtenerString("SELECT F.CODEMPLEADO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNombRecibe(driver.ObtenerString("SELECT F.NOMBRECIBE FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setDocuRecibe(driver.ObtenerString("SELECT F.DOCURECIBE FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setObservaciones(driver.ObtenerString("SELECT F.OBSERVACIONES FROM FEL_SV_TBL_EXTENSION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setPlacaVehiculo(null);
            resultado.setAutoFitoSanitaria(null);
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_extension | Error: " + ex.toString());
        }

        return resultado;
    }
    
    public EXTENSION_OUT_NC registro_json_extension_nc(Connection conn, Long id_dte) {
        EXTENSION_OUT_NC resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new EXTENSION_OUT_NC();
            resultado.setTotalItems(driver.ObtenerDouble("SELECT F.TOTALITEMS FROM FEL_SV_TBL_EXTENSION F WHERE F.ID_DTE=" + id_dte, conn));
            Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_DTE F WHERE F.ID_DTE=" + id_dte, conn);
            resultado.setNombEntrega(driver.ObtenerString("SELECT F.NOMBENTREGA FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setDocuEntrega(driver.ObtenerString("SELECT F.DOCUENTREGA FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setCodEmpleado(driver.ObtenerString("SELECT F.CODEMPLEADO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNombRecibe(driver.ObtenerString("SELECT F.NOMBRECIBE FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setDocuRecibe(driver.ObtenerString("SELECT F.DOCURECIBE FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setObservaciones(driver.ObtenerString("SELECT F.OBSERVACIONES FROM FEL_SV_TBL_EXTENSION F WHERE F.ID_DTE=" + id_dte, conn));
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_extension | Error: " + ex.toString());
        }

        return resultado;
    }

}
