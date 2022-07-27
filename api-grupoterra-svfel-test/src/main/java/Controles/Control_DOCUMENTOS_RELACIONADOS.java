package Controles;

import Entidades.JsonIn.DOCUMENTOS_RELACIONADOS_IN;
import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.DOCUMENTOS_RELACIONADOS_OUT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Control_DOCUMENTOS_RELACIONADOS implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_DOCUMENTOS_RELACIONADOS() {
    }

    public void registro_db_tabla_documentos_relacionados(Connection conn, DTE_IN dte_in, Long id_dte) {
        Driver driver = new Driver();

        try {
            if (!dte_in.getDocumentoRelacionado().getTipoDte().trim().equals("-")) {
                Long id_documentos_relacionados = Long.parseLong("1");
                Long id_tipo_relacion_documento = Long.parseLong("1");
                Long id_tipo_documento_relacionado = driver.ObtenerLong("SELECT F.ID_TIPO_DOCUMENTO FROM FEL_SV_TBL_TIPO_DOCUMENTO F WHERE F.CODIGO='" + dte_in.getDocumentoRelacionado().getTipoDte().trim() + "'", conn);
                Long id_tipo_generacion_documnto = driver.ObtenerLong("SELECT F.ID_TIPO_GENERACION_DOCUMENTO FROM FEL_TIPO_GENERACION_DOCUMENTO F WHERE F.CODIGO='" + dte_in.getDocumentoRelacionado().getTipoGeneracion() + "'", conn);
                SimpleDateFormat dateFormat_fechaemision1 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat dateFormat_fechaemision2 = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaemision_date = dateFormat_fechaemision1.parse(dte_in.getDocumentoRelacionado().getFechaEmision());
                String fechaemision_string = dateFormat_fechaemision2.format(fechaemision_date);

                String cadenasql = "INSERT INTO FEL_DOCUMENTOS_RELACIONADOS ("
                        + "ID_DTE,"
                        + "ID_DOCUMENTOS_RELACIONADOS,"
                        + "ID_TIPO_RELACION_DOCUMENTO,"
                        + "ID_TIPO_DOCUMENTO,"
                        + "ID_TIPO_GENERACION_DOCUMENTO,"
                        + "CODIGOGENERACION,"
                        + "NUMEROCORRELATIVO,"
                        + "FECHAEMISION) VALUES ("
                        + id_dte + ","
                        + id_documentos_relacionados + ","
                        + id_tipo_relacion_documento + ","
                        + id_tipo_documento_relacionado + ","
                        + id_tipo_generacion_documnto + ",'"
                        + dte_in.getDocumentoRelacionado().getCodigoGeneracion() + "','"
                        + dte_in.getDocumentoRelacionado().getNumeroCorrelativo() + "','"
                        + fechaemision_string + "')";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(cadenasql);
                stmt.close();
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_documentos_relacionados | Error: " + ex.toString());
        }
    }

    public DOCUMENTOS_RELACIONADOS_OUT registro_json_documentos_relacionados(Connection conn, Long id_dte, String tipoDte) {
        DOCUMENTOS_RELACIONADOS_OUT resultado = null;
        Driver driver = new Driver();

        try {
            if (!tipoDte.trim().equals("01")) {
                resultado = new DOCUMENTOS_RELACIONADOS_OUT();
                resultado.setTipoRelacion(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_DOCUMENTOS_RELACIONADOS F LEFT JOIN FEL_TIPO_RELACION_DOCUMENTO G ON (F.ID_TIPO_RELACION_DOCUMENTO=G.ID_TIPO_RELACION_DOCUMENTO) WHERE F.ID_DTE=" + id_dte, conn));
                resultado.setTipoDte(driver.ObtenerString("SELECT G.CODIGO FROM FEL_DOCUMENTOS_RELACIONADOS F LEFT JOIN FEL_SV_TBL_TIPO_DOCUMENTO G ON (F.ID_TIPO_DOCUMENTO=G.ID_TIPO_DOCUMENTO) WHERE F.ID_DTE=" + id_dte, conn));
                resultado.setTipoGeneracion(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_DOCUMENTOS_RELACIONADOS F LEFT JOIN FEL_TIPO_GENERACION_DOCUMENTO G ON (F.ID_TIPO_GENERACION_DOCUMENTO=G.ID_TIPO_GENERACION_DOCUMENTO) WHERE F.ID_DTE=" + id_dte, conn));
                resultado.setCodigoGeneracion(driver.ObtenerString("SELECT DECODE(F.CODIGOGENERACION,'-',NULL,F.CODIGOGENERACION) FROM FEL_DOCUMENTOS_RELACIONADOS F WHERE F.ID_DTE=" + id_dte, conn));
                resultado.setNumeroCorrelativo(driver.ObtenerString("SELECT DECODE(F.NUMEROCORRELATIVO,'-',NULL,F.NUMEROCORRELATIVO) FROM FEL_DOCUMENTOS_RELACIONADOS F WHERE F.ID_DTE=" + id_dte, conn));
                resultado.setFechaEmision(driver.ObtenerString("SELECT TO_CHAR(F.FECHAEMISION,'yyyy-MM-dd') FROM FEL_DOCUMENTOS_RELACIONADOS F WHERE F.ID_DTE=" + id_dte, conn));
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_documentos_relacionados | Error: " + ex.toString());
        }

        return resultado;
    }

    public DOCUMENTOS_RELACIONADOS_IN extraer_documento_relacionado_jde(Connection conn, String ambiente, String dcto_jde) {
        DOCUMENTOS_RELACIONADOS_IN resultado = new DOCUMENTOS_RELACIONADOS_IN();
        Driver driver = new Driver();

        try {
            String esquema_jde = "";
            String esquema_jde_udc = "";
            String dblink_jde = "";
            if (ambiente.equals("test")) {
                esquema_jde = "CRPDTA";
                esquema_jde_udc = "CRPCTL";
                dblink_jde = "JDEPY";
            } else {
                esquema_jde = "PRODDTA";
                esquema_jde_udc = "PRODCTL";
                dblink_jde = "JDEPD";
            }

            if (dcto_jde.trim().equals("S3")) {
                resultado.setTipoDte("-");
                resultado.setTipoGeneracion(0);
                resultado.setCodigoGeneracion("-");
                resultado.setNumeroCorrelativo("-");
                resultado.setFechaEmision("-");
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: extraer_documento_relacionado_jde | Error: " + ex.toString());
        }

        return resultado;
    }

}
