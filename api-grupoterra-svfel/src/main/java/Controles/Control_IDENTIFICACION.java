package Controles;

import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.IDENTIFICACION_OUT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Control_IDENTIFICACION implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_IDENTIFICACION() {
    }

    public void registro_db_tabla_identificacion(Connection conn, DTE_IN dte_in, String ambiente, Long id_dte) {
        Driver driver = new Driver();

        try {
            Long id_identificacion = Long.parseLong("1");
            Long dte_version = Long.parseLong("2");
            Long id_ambiente_destino = driver.ObtenerLong("SELECT F.ID_AMBIENTE_DESTINO FROM FEL_SV_TBL_AMBIENTE_DESTINO F WHERE TRIM(F.VALOR_JDE) = '" + ambiente + "'", conn);
            Long id_tipo_documento = driver.ObtenerLong("SELECT F.ID_TIPO_DOCUMENTO FROM FEL_SV_TBL_TIPO_DOCUMENTO F WHERE TRIM(F.VALOR_JDE) = '" + dte_in.getDcto_jde() + "'", conn);
            String campo_correlativo = "";
            if (dte_in.getDcto_jde().equals("S3")) {
                campo_correlativo = "CORRELATIVO_CCF";
            }
            if (dte_in.getDcto_jde().equals("C3")) {
                campo_correlativo = "CORRELATIVO_NC";
            }
            if (dte_in.getDcto_jde().equals("SD")) {
                campo_correlativo = "CORRELATIVO_ND";
            }
            String numerocontrol = "DTE-"
                    + driver.ObtenerString("SELECT F.CODIGO FROM FEL_SV_TBL_TIPO_DOCUMENTO F WHERE TRIM(F.VALOR_JDE) = '" + dte_in.getDcto_jde() + "'", conn) + "-"
                    + driver.ObtenerString("SELECT F.CODIGO || F.PUNTOVENTA FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE TRIM(F.MCU_JDE) LIKE '%" + dte_in.getMcu_jde() + "%'", conn) + "-"
                    + driver.ObtenerString("SELECT LPAD(F." + campo_correlativo + " + 1, 15, '0') FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE TRIM(F.MCU_JDE) LIKE '%" + dte_in.getMcu_jde() + "%'", conn);

            String cadenasql = "UPDATE FEL_EMISOR_ESTABLECIMIENTO SET " + campo_correlativo + "=" + campo_correlativo + "+1 WHERE TRIM(MCU_JDE) LIKE '%" + dte_in.getMcu_jde() + "%'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cadenasql);
            stmt.close();

            String codigogeneracio = UUID.randomUUID().toString().toUpperCase();
            Integer id_modelo_facturacion = 1;
            Integer id_tipo_transmision = 1;
            String id_tipo_contingencia = "null";
            String motivocontin = "null";
            Date fecha_actual = new Date();
            SimpleDateFormat dateFormat_fecemi = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat_horemi = new SimpleDateFormat("kk:mm:ss");
            String fecemi = dateFormat_fecemi.format(fecha_actual);
            String horemi = dateFormat_horemi.format(fecha_actual);

            cadenasql = "INSERT INTO FEL_SV_TBL_IDENTIFICACION ("
                    + "ID_DTE, "
                    + "ID_IDENTIFICACION, "
                    + "DTE_VERSION, "
                    + "ID_AMBIENTE_DESTINO, "
                    + "ID_TIPO_DOCUMENTO, "
                    + "NUMEROCONTROL, "
                    + "CODIGOGENERACION, "
                    + "ID_MODELO_FACTURACION, "
                    + "ID_TIPO_TRANSMISION, "
                    + "ID_TIPO_CONTINGENCIA, "
                    + "MOTIVOCONTIN, "
                    + "FECEMI, "
                    + "HOREMI, "
                    + "TIPOMONEDA) VALUES ("
                    + id_dte + ","
                    + id_identificacion + ","
                    + dte_version + ","
                    + id_ambiente_destino + ","
                    + id_tipo_documento + ",'"
                    + numerocontrol + "','"
                    + codigogeneracio + "','"
                    + id_modelo_facturacion + "','"
                    + id_tipo_transmision + "',"
                    + id_tipo_contingencia + ","
                    + motivocontin + ",'"
                    + fecemi + "','"
                    + horemi + "','"
                    + dte_in.getCrcd_jde() + "')";
            stmt = conn.createStatement();
            // System.out.println("******************** FEL_SV_TBL_IDENTIFICACION: " + cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_identificacion | Error: " + ex.toString());
        }
    }

    public IDENTIFICACION_OUT registro_json_identificacion(Connection conn, Long id_dte) {
        IDENTIFICACION_OUT resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new IDENTIFICACION_OUT();
            resultado.setVersion(driver.ObtenerEntero("SELECT F.DTE_VERSION FROM FEL_SV_TBL_IDENTIFICACION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setAmbiente(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_IDENTIFICACION F LEFT JOIN FEL_SV_TBL_AMBIENTE_DESTINO G ON (F.ID_AMBIENTE_DESTINO=G.ID_AMBIENTE_DESTINO) WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTipoDte(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_IDENTIFICACION F LEFT JOIN FEL_SV_TBL_TIPO_DOCUMENTO G ON (F.ID_TIPO_DOCUMENTO=G.ID_TIPO_DOCUMENTO) WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setNumeroControl(driver.ObtenerString("SELECT F.NUMEROCONTROL FROM FEL_SV_TBL_IDENTIFICACION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setCodigoGeneracion(driver.ObtenerString("SELECT F.CODIGOGENERACION FROM FEL_SV_TBL_IDENTIFICACION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTipoModelo(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_IDENTIFICACION F LEFT JOIN FEL_SV_TBL_MODELO_FACTURACION G ON (F.ID_MODELO_FACTURACION=G.ID_MODELO_FACTURACION) WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTipoOperacion(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_IDENTIFICACION F LEFT JOIN FEL_SV_TBL_TIPO_TRANSMISION G ON (F.ID_TIPO_TRANSMISION=G.ID_TIPO_TRANSMISION) WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setFecEmi(driver.ObtenerString("SELECT F.FECEMI FROM FEL_SV_TBL_IDENTIFICACION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setHorEmi(driver.ObtenerString("SELECT F.HOREMI FROM FEL_SV_TBL_IDENTIFICACION F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTipoMoneda(driver.ObtenerString("SELECT F.TIPOMONEDA FROM FEL_SV_TBL_IDENTIFICACION F WHERE F.ID_DTE=" + id_dte, conn));
        } catch (Exception ex) {
            resultado = null;
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_identificacion | Error: " + ex.toString());
        }

        return resultado;
    }

}
