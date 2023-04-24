package Controladores;

import Entidades.Apendice_nr;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Apendice_NR_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_Apendice_NR_V3() {
    }

    public List<Apendice_nr> obtener_apendice_nr_v3(Long id_dte, Connection conn) {
        List<Apendice_nr> resultado = new ArrayList<>();

        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            
            String cadenasql = "SELECT F.ID_APENDICE FROM APENDICE_NR_V3 F WHERE F.ID_DTE=" + id_dte + " ORDER BY F.ID_APENDICE"; 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while(rs.next()) {
                Long id_apendice = rs.getLong(1);
                Apendice_nr apendice_nr = new Apendice_nr();
                apendice_nr.setCampo(ctrl_base_datos.ObtenerString("SELECT F.CAMPO FROM APENDICE_NR_V3 F WHERE F.ID_DTE=" + id_dte + " AND F.ID_APENDICE=" + id_apendice, conn));
                apendice_nr.setEtiqueta(ctrl_base_datos.ObtenerString("SELECT F.ETIQUETA FROM APENDICE_NR_V3 F WHERE F.ID_DTE=" + id_dte + " AND F.ID_APENDICE=" + id_apendice, conn));
                apendice_nr.setValor(ctrl_base_datos.ObtenerString("SELECT F.VALOR FROM APENDICE_NR_V3 F WHERE F.ID_DTE=" + id_dte + " AND F.ID_APENDICE=" + id_apendice, conn));
                resultado.add(apendice_nr);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:obtener_apendice_nr_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    public String extraer_apendice_jde_nr_v3(Long id_dte, String ambiente, String DOCO_JDE, String DCTO_JDE, String MCU_JDE, Connection conn) {
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
            
            String cadenasql = "INSERT INTO APENDICE_NR_V3 ("
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
            
            resultado = "0,TRANSACCIONES PROCESADAS.";
        } catch (Exception ex) {
            resultado = "1," + ex.toString();
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_apendice_jde_nr_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }

}
