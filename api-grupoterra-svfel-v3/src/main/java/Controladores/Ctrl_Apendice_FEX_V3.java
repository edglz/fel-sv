package Controladores;

import Entidades.Apendice_fex;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Apendice_FEX_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_Apendice_FEX_V3() {
    }

    public List<Apendice_fex> obtener_apendice_fex_v3(Long id_dte, Connection conn) {
        List<Apendice_fex> resultado = new ArrayList<>();

        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            
            String cadenasql = "SELECT F.ID_APENDICE FROM APENDICE_FEX_V3 F WHERE F.ID_DTE=" + id_dte + " ORDER BY F.ID_APENDICE"; 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while(rs.next()) {
                Long id_apendice = rs.getLong(1);
                Apendice_fex apendice_fex = new Apendice_fex();
                apendice_fex.setCampo(ctrl_base_datos.ObtenerString("SELECT F.CAMPO FROM APENDICE_FEX_V3 F WHERE F.ID_DTE=" + id_dte + " AND F.ID_APENDICE=" + id_apendice, conn));
                apendice_fex.setEtiqueta(ctrl_base_datos.ObtenerString("SELECT F.ETIQUETA FROM APENDICE_FEX_V3 F WHERE F.ID_DTE=" + id_dte + " AND F.ID_APENDICE=" + id_apendice, conn));
                apendice_fex.setValor(ctrl_base_datos.ObtenerString("SELECT F.VALOR FROM APENDICE_FEX_V3 F WHERE F.ID_DTE=" + id_dte + " AND F.ID_APENDICE=" + id_apendice, conn));
                resultado.add(apendice_fex);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:obtener_apendice_fex_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    public String extraer_apendice_jde_fex_v3(Long id_dte, String ambiente, String DOCO_JDE, String DCTO_JDE, String MCU_JDE, Connection conn) {
        String resultado = "";

        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();

            String esquema;
            String dblink;
            if (ambiente.equals("PY")) {
                esquema = "CRPDTA";
                dblink = "JDEPY";
            } else {
                esquema = "PRODDTA";
                dblink = "JDEPD";
            }
            
            Long ID_DTE = id_dte;
            Long ID_APENDICE = Long.valueOf("1");
            String CAMPO = "SELLOS";
            String ETIQUETA = "SELLOS DE SEGURIDAD";
            String TDLDNM = ctrl_base_datos.ObtenerString("SELECT DISTINCT F.TDLDNM FROM " + esquema + ".F49621@" + dblink + " F WHERE F.TDDCTO='" + DCTO_JDE + "' AND F.TDDOCO=" + DOCO_JDE + " AND TRIM(F.TDVMCU)='" + MCU_JDE + "'", conn);
            if(TDLDNM == null) {
                TDLDNM = "0";
            }
            String VALOR = ctrl_base_datos.ObtenerString("SELECT DISTINCT T.SELLOS FROM (SELECT (LISTAGG(F.SUSLN, ', ') WITHIN GROUP (ORDER BY F.SUSLN) OVER (PARTITION BY F.SULDNM, F.SUVMCU)) SELLOS FROM " + esquema + ".F49380@" + dblink + " F  WHERE F.SULDNM='" + TDLDNM + "' AND TRIM(F.SUVMCU)='" + MCU_JDE + "') T", conn);
            if(VALOR == null) {
                VALOR = "-";
            }
            
            String cadenasql = "INSERT INTO APENDICE_FEX_V3 ("
                    + "ID_DTE, "
                    + "ID_APENDICE, "
                    + "CAMPO, "
                    + "ETIQUETA, "
                    + "VALOR) VALUES ("
                    + ID_DTE + ","
                    + ID_APENDICE + ",'"
                    + CAMPO + "','"
                    + ETIQUETA + "','"
                    + VALOR + "')";
            Statement stmt = conn.createStatement();
            System.out.println(cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
            
            ID_APENDICE = Long.valueOf("2");
            CAMPO = "NO_CONTRATO";
            ETIQUETA = "NO CONTRATO";
            String AN8_JDE = ctrl_base_datos.ObtenerString("SELECT F.AN8_JDE FROM DTE_FEX_V3 F WHERE F.ID_DTE=" + ID_DTE, conn);
            VALOR = ctrl_base_datos.ObtenerString("SELECT TRIM(F.WWATTL) FROM " + esquema + ".F0111@" + dblink + " F WHERE F.WWAN8=" + AN8_JDE + " AND TRIM(F.WWTYC)='S'", conn);
            if(VALOR == null) {
                VALOR = "-";
            }
            
            cadenasql = "INSERT INTO APENDICE_FEX_V3 ("
                    + "ID_DTE, "
                    + "ID_APENDICE, "
                    + "CAMPO, "
                    + "ETIQUETA, "
                    + "VALOR) VALUES ("
                    + ID_DTE + ","
                    + ID_APENDICE + ",'"
                    + CAMPO + "','"
                    + ETIQUETA + "','"
                    + VALOR + "')";
            stmt = conn.createStatement();
            System.out.println(cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
            
            ID_APENDICE = Long.valueOf("3");
            CAMPO = "BOLETAS";
            ETIQUETA = "BOLETAS";
            String KCOO_JDE = ctrl_base_datos.ObtenerString("SELECT F.KCOO_JDE FROM DTE_FEX_V3 F WHERE F.ID_DTE=" + ID_DTE, conn);
            VALOR = obtener_texto_encabezado(ambiente, DOCO_JDE, DCTO_JDE, KCOO_JDE);
            if(VALOR == null) {
                VALOR = "-";
            }
            
            cadenasql = "INSERT INTO APENDICE_FEX_V3 ("
                    + "ID_DTE, "
                    + "ID_APENDICE, "
                    + "CAMPO, "
                    + "ETIQUETA, "
                    + "VALOR) VALUES ("
                    + ID_DTE + ","
                    + ID_APENDICE + ",'"
                    + CAMPO + "','"
                    + ETIQUETA + "','"
                    + VALOR + "')";
            stmt = conn.createStatement();
            System.out.println(cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
            
            resultado = "0,TRANSACCIONES PROCESADAS.";
        } catch (Exception ex) {
            resultado = "1," + ex.toString();
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_apendice_jde_fex_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    private String obtener_texto_encabezado(String ambiente, String DOCO_JDE, String DCTO_JDE, String KCOO_JDE) {
        String resultado = "";
        
        try {
            String host_ip;
            String sid;
            String user_db;
            String pass_db;
            String esquema_db;
            if (ambiente.equals("PY")) {
                host_ip = "10.252.7.207";
                sid = "jdepy";
                user_db = "CRPDTA";
                pass_db = "CRPDTA";
                esquema_db = "CRPDTA";
            } else {
                host_ip = "10.252.7.201";
                sid = "jdepd";
                user_db = "PRODDTA";
                pass_db = "PRODDTA";
                esquema_db = "PRODDTA";
            }
            
            // EXTRAER LAS OBSERVACIONES DE JDE.
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn_jde = DriverManager.getConnection("jdbc:oracle:thin:@//" + host_ip + ":1521/" + sid, user_db, pass_db);
            
            String cadenasql = "SELECT REPLACE(REGEXP_REPLACE(REPLACE(UTL_RAW.CAST_TO_VARCHAR2(DBMS_LOB.SUBSTR(D.GDTXFT,DBMS_LOB.GETLENGTH(D.GDTXFT),1)),CHR(0),''), '<.+?>|(' || '&' || 'nbsp;)'), CHR(13) || CHR(10) ) DESCRIPCION "
                    + "FROM " + esquema_db + ".F00165 D "
                    + "WHERE D.GDOBNM = 'GT4201A   ' AND D.GDTXKY = '" + DOCO_JDE + "|" + DCTO_JDE + "|" + KCOO_JDE + "' AND D.GDMOSEQN=1";
            Statement stmt_jde = conn_jde.createStatement();
            ResultSet rs_jde = stmt_jde.executeQuery(cadenasql);
            while (rs_jde.next()) {
                resultado = rs_jde.getString(1);
            }
            rs_jde.close();
            stmt_jde.close();
            
            conn_jde.close();
        } catch (Exception ex) {
            resultado = "PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:obtener_texto_encabezado()|ERROR:" + ex.toString();
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:obtener_texto_encabezado()|ERROR:" + ex.toString());
        }
        
        return resultado;
    }

}
