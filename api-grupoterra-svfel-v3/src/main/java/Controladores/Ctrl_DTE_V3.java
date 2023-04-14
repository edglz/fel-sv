package Controladores;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ctrl_DTE_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_DTE_V3() {
    }

    public Integer selecionar_documentos_v3(String ambiente, String fecha, Integer modo) {
        Integer resultado = 0;
        String tabla_sales_orders;
        Connection conn = null;

        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            conn = ctrl_base_datos.obtener_conexion(ambiente);

            String esquema;
            String dblink;
            if (ambiente.equals("PY")) {
                esquema = "CRPDTA";
                dblink = "JDEPY";
            } else {
                esquema = "PRODDTA";
                dblink = "JDEPD";
            }

            conn.setAutoCommit(false);

            // System.out.println("SELECT TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE('" + fecha + "','YYYYMMDD'),'ccYYddd'),2,6)) IVD FROM DUAL");
            Long ivd = ctrl_base_datos.ObtenerLong("SELECT TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE('" + fecha + "','YYYYMMDD'),'ccYYddd'),2,6)) IVD FROM DUAL", conn);

            String STCD;
            if (modo == 1) {
                tabla_sales_orders = "F4211";
                STCD = "000";
            } else {
                tabla_sales_orders = "F42119";
                STCD = "999";
            }
            
            String cadenasql = "SELECT DISTINCT F.SDKCOO, F.SDDOCO, F.SDDCTO, F.SDDOC, F.SDDCT, F.SDMCU, F.SDAN8, F.SDSHAN, F.SDCRCD, F.SDIVD, '" + STCD + "' STCD, '-' CRSREF01, '-' CRSREF02, '-' CRSREF03, '-' CRSREF04, '-' CRSREF05, '" + tabla_sales_orders + "' TABLA, TRIM(F.SDTXA1) SDTXA1, NVL(TRIM(G.ABAC30),'-') ABAC30 "
                    + "FROM " + esquema + "." + tabla_sales_orders + "@" + dblink + " F LEFT JOIN " + esquema + ".F0101@" + dblink + " G ON (F.SDAN8=G.ABAN8) "
                    + "WHERE (TRIM(F.SDKCO) IN (SELECT C.KCOO_JDE FROM EMISOR_KCOO_V3 C)) AND (F.SDDOC > 0) AND (TRIM(F.SDLTTR) NOT IN ('904','902','900','980')) AND (TRIM(F.SDDCTO) IN ('S3','C3','SD')) AND (TRIM(F.SDCRMD) IS NULL) AND (F.SDIVD = " + ivd + ")";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                String TXA1 = rs.getString(18);
                String DCTO = rs.getString(3);
                String AC30 = rs.getString(19);
                
                if (DCTO.equals("S3")) {
                    switch (AC30) {
                        case "EXP":
                            DCTO = "EX";
                            break;
                        case "FCF":
                            DCTO = "FE";
                            break;
                    }
                }
                
                cadenasql = "INSERT INTO " + esquema + ".F5542FEL@" + dblink + " ("
                        + "FEKCOO, "
                        + "FEDOCO, "
                        + "FEDCTO, "
                        + "FEDOC, "
                        + "FEDCT, "
                        + "FEMCU, "
                        + "FEAN8, "
                        + "FESHAN, "
                        + "FECRCD,"
                        + "FEIVD, "
                        + "FESTCD, "
                        + "FECRSREF01, "
                        + "FECRSREF02, "
                        + "FECRSREF03, "
                        + "FECRSREF04, "
                        + "FECRSREF05,"
                        + "FEJEVER) VALUES ('"
                        + rs.getString(1) + "','"
                        + rs.getString(2) + "','"
                        + DCTO + "','"
                        + rs.getString(4) + "','"
                        + rs.getString(5) + "','"
                        + rs.getString(6) + "','"
                        + rs.getString(7) + "','"
                        + rs.getString(8) + "','"
                        + rs.getString(9) + "','"
                        + rs.getString(10) + "','"
                        + rs.getString(11) + "','"
                        + rs.getString(12) + "','"
                        + rs.getString(13) + "','"
                        + rs.getString(14) + "','"
                        + rs.getString(15) + "','"
                        + rs.getString(16) + "','"
                        + rs.getString(17) + "')";
                Statement stmt1 = conn.createStatement();
                // System.out.println(cadenasql);
                stmt1.executeUpdate(cadenasql);
                stmt1.close();

                cadenasql = "UPDATE " + esquema + "." + rs.getString(17) + "@" + dblink + " "
                        + "SET SDCRMD='4' "
                        + "WHERE SDKCOO='" + rs.getString(1) + "' AND SDDOCO=" + rs.getString(2) + " AND SDDCTO='" + rs.getString(3) + "' AND SDDOC=" + rs.getString(4) + " AND SDDCT='" + rs.getString(5) + "'";
                stmt1 = conn.createStatement();
                // System.out.println(cadenasql);
                stmt1.executeUpdate(cadenasql);
                stmt1.close();
                resultado++;
            }
            rs.close();
            stmt.close();

            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:selecionar_documentos_v3()|ERROR:" + ex.toString());
                resultado = 0;
            } catch (Exception ex1) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:selecionar_documentos_v3()-rollback|ERROR:" + ex1.toString());
                resultado = 0;
            }

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:selecionar_documentos_v3()-finally|ERROR:" + ex.toString());
            }
        }

        return resultado;
    }

}
