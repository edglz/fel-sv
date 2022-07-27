package Controladores;

import Entidades.DTE_CCF_V3;
import Entidades.RESPUESTA_RECEPCIONDTE_MH;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_DTE_CCF_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_DTE_CCF_V3() {
    }

    public List<Long> extraer_documento_jde_ccf_v3(String ambiente) {
        List<Long> resultado = new ArrayList<>();
        Connection conn = null;

        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            conn = ctrl_base_datos.obtener_conexion(ambiente);
            
            String esquema;
            String dblink;
            if(ambiente.equals("PY")) {
                esquema = "CRPDTA";
                dblink = "JDEPY";
            } else {
                esquema = "PRODDTA";
                dblink = "JDEPD";
            }
            
            conn.setAutoCommit(false);
            
            String cadenasql = "SELECT "
                    + "F.FEKCOO, "
                    + "F.FEMCU, "
                    + "F.FEDOCO, "
                    + "F.FEDCTO, "
                    + "F.FEDOC, "
                    + "F.FEDCT, "
                    + "F.FEAN8, "
                    + "F.FESHAN, "
                    + "F.FECRCD, "
                    + "F.FEIVD "
                    + "FROM "
                    + esquema + ".F5542FEL@" + dblink + " F "
                    + "WHERE "
                    + "F.FESTCD='000' AND "
                    + "F.FEDCTO='S3'";
            Statement stmt = conn.createStatement();
            System.out.println(cadenasql);
            ResultSet rs = stmt.executeQuery(cadenasql);
            while(rs.next()) {
                Long ID_DTE = ctrl_base_datos.ObtenerLong("SELECT NVL(MAX(F.ID_DTE), 0) + 1 MAXIMO FROM DTE_CCF_V3 F", conn);
                String KCOO_JDE = rs.getString(1);
                String MCU_JDE = rs.getString(2);
                String DOCO_JDE = rs.getString(3);
                String DCTO_JDE = rs.getString(4);
                String DOC_JDE = rs.getString(5);
                String DCT_JDE = rs.getString(6);
                String AN8_JDE = rs.getString(7);
                String SHAN_JDE = rs.getString(8);
                String CRCD_JDE = rs.getString(9);
                String IVD_JDE = rs.getString(10);
                Long ID_EMISOR = ctrl_base_datos.ObtenerLong("SELECT F.ID_EMISOR FROM EMISOR_ESTABLECIMIENTO_V3 F WHERE F.CODPUNTOVENTA='" + MCU_JDE.trim() + "'", conn);
                
                cadenasql = "INSERT INTO DTE_CCF_V3 ("
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
                        + "RESPONSE_OBSERVACIONES,"
                        + "RESPONSE_CLASIFICAMSG) VALUES ("
                        + ID_DTE + ",'"
                        + KCOO_JDE.trim() + "','"
                        + MCU_JDE.trim() + "','"
                        + DOCO_JDE.trim() + "','"
                        + DCTO_JDE.trim() + "','"
                        + DOC_JDE.trim() + "','"
                        + DCT_JDE.trim() + "','"
                        + AN8_JDE.trim() + "','"
                        + SHAN_JDE.trim() + "','"
                        + CRCD_JDE.trim() + "','"
                        + IVD_JDE + "',"
                        + ID_EMISOR + ","
                        + "null, null, null, null, null, null, null, null, null, null, null)";
                Statement stmt1 = conn.createStatement();
                System.out.println(cadenasql);
                stmt1.executeUpdate(cadenasql);
                stmt1.close();
                
                cadenasql = "UPDATE " + esquema + ".F5542FEL@" + dblink + " "
                        + "SET FESTCD='999' "
                        + "WHERE FEKCOO='" + KCOO_JDE + "' AND FEDOCO=" + DOCO_JDE + " AND FEDCTO='" + DCTO_JDE + "' AND FEDOC=" + DOC_JDE + " AND FEDCT='" + DCT_JDE + "'";
                stmt1 = conn.createStatement();
                System.out.println(cadenasql);
                stmt1.executeUpdate(cadenasql);
                stmt1.close();
                
                Ctrl_Identificacion_CCF_V3 ctrl_identificacion_ccf_v3 = new Ctrl_Identificacion_CCF_V3();
                String result_edentificacion = ctrl_identificacion_ccf_v3.extraer_identificacion_jde_ccf_v3(ID_DTE, ambiente, DCTO_JDE.trim(), MCU_JDE.trim(), CRCD_JDE.trim(), conn);
                
                Ctrl_Receptor_CCF_V3 ctrl_receptor_ccf_v3 = new Ctrl_Receptor_CCF_V3();
                String result_recepor = ctrl_receptor_ccf_v3.extraer_receptor_jde_ccf_v3(ID_DTE, ambiente, SHAN_JDE.trim(), conn);
                
                Ctrl_CuerpoDocumento_CCF_V3 ctrl_cuerpo_documento_ccf_v3 = new Ctrl_CuerpoDocumento_CCF_V3();
                String result_cuerpo_documento = ctrl_cuerpo_documento_ccf_v3.extraer_cuerpo_documento_jde_ccf_v3(ID_DTE, ambiente, KCOO_JDE.trim(), DOCO_JDE.trim(), DCTO_JDE.trim(), conn);
                
                Ctrl_Resumen_CCF_V3 ctrl_resumen_ccf_v3 = new Ctrl_Resumen_CCF_V3();
                String result_resumen = ctrl_resumen_ccf_v3.extraer_resumen_jde_ccf_v3(ID_DTE, ambiente, conn);
                
                Ctrl_Extension_CCF_V3 ctrl_extension_ccf_v3 = new Ctrl_Extension_CCF_V3();
                String result_extension = ctrl_extension_ccf_v3.extraer_extension_jde_ccf_v3(ID_DTE, ambiente, conn);
                
                Ctrl_Apendice_CCF_V3 ctrl_apendice_ccf_v3 = new Ctrl_Apendice_CCF_V3();
                String result_apendice = ctrl_apendice_ccf_v3.extraer_apendice_jde_ccf_v3(ID_DTE, ambiente, DOCO_JDE.trim(), DCTO_JDE.trim(), MCU_JDE.trim(), conn);
                
                resultado.add(ID_DTE);
            }
            rs.close();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_ccf_v3()|ERROR:" + ex.toString());
                resultado.clear();
            } catch (Exception ex1) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_ccf_v3()-rollback|ERROR:" + ex1.toString());
                resultado.clear();
            }

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_ccf_v3()-finally|ERROR:" + ex.toString());
                resultado.clear();
            }
        }

        return resultado;
    }
    
    public DTE_CCF_V3 generar_json_dte_ccf_v3(String ambiente, Long id_dte) {
        DTE_CCF_V3 resultado = new DTE_CCF_V3();
        Connection conn = null;

        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            conn = ctrl_base_datos.obtener_conexion(ambiente);
            
            conn.setAutoCommit(false);

            Ctrl_Identificacion_CCF_V3 ctrl_identificacion_ccf_v3 = new Ctrl_Identificacion_CCF_V3();
            resultado.setIdentificacion(ctrl_identificacion_ccf_v3.obtener_identificacion_ccf_v3(id_dte, conn));
            
            resultado.setDocumentoRelacionado(null);
            
            Ctrl_Emisor_CCF_V3 ctrl_emisor_ccf_v3 = new Ctrl_Emisor_CCF_V3();
            resultado.setEmisor(ctrl_emisor_ccf_v3.obtener_emisor_ccf_v3(id_dte, conn));
            
            Ctrl_Receptor_CCF_V3 ctrl_receptor_ccf_v3 = new Ctrl_Receptor_CCF_V3();
            resultado.setReceptor(ctrl_receptor_ccf_v3.obtener_receptor_ccf_v3(id_dte, conn));
            
            resultado.setOtrosDocumentos(null);
            
            resultado.setVentaTercero(null);
            
            Ctrl_CuerpoDocumento_CCF_V3 ctrl_cuerpo_documento_ccf_v3 = new Ctrl_CuerpoDocumento_CCF_V3();
            resultado.setCuerpoDocumento(ctrl_cuerpo_documento_ccf_v3.obtener_cuerpo_documento_ccf_v3(id_dte, conn));

            Ctrl_Resumen_CCF_V3 ctrl_resumen_ccf_v3 = new Ctrl_Resumen_CCF_V3();
            resultado.setResumen(ctrl_resumen_ccf_v3.obtener_resumen_ccf_v3(id_dte, conn));
            
            Ctrl_Extension_CCF_V3 ctrl_extension_ccf_v3 = new Ctrl_Extension_CCF_V3();
            resultado.setExtension(ctrl_extension_ccf_v3.obtener_extension_ccf_v3(id_dte, conn));
            
            Ctrl_Apendice_CCF_V3 ctrl_apendice_ccf_v3 = new Ctrl_Apendice_CCF_V3();
            resultado.setApendice(ctrl_apendice_ccf_v3.obtener_apendice_ccf_v3(id_dte, conn));
            
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:generar_dte_ccf_v3()|ERROR:" + ex.toString());;
            } catch (Exception ex1) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:generar_dte_ccf_v3()-rollback|ERROR:" + ex.toString());
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:generar_dte_ccf_v3()-finally|ERROR:" + ex.toString());
            }
        }

        return resultado;
    }
    
    public void registro_db_respuesta_mh(String ambiente, RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh, Long id_dte) {
        Connection conn = null;
        
        try {
            Ctrl_Base_Datos ctrl_base_datos = new Ctrl_Base_Datos();
            conn = ctrl_base_datos.obtener_conexion(ambiente);
            
            String esquema;
            String dblink;
            if(ambiente.equals("PY")) {
                esquema = "CRPDTA";
                dblink = "JDEPY";
            } else {
                esquema = "PRODDTA";
                dblink = "JDEPD";
            }
            
            conn.setAutoCommit(false);
            
            String cadenasql = "UPDATE DTE_CCF_V3 SET "
                    + "RESPONSE_VERSION=" + respuesta_recepciondte_mh.getVersion() + ", "
                    + "RESPONSE_AMBIENTE='" + respuesta_recepciondte_mh.getAmbiente() + "', "
                    + "RESPONSE_VERSIONAPP=" + respuesta_recepciondte_mh.getVersionApp() + ", "
                    + "RESPONSE_ESTADO='" + respuesta_recepciondte_mh.getEstado() + "', "
                    + "RESPONSE_CODIGOGENERACION='" + respuesta_recepciondte_mh.getCodigoGeneracion() + "', "
                    + "RESPONSE_NUMVALIDACION='" + respuesta_recepciondte_mh.getSelloRecibido() + "', "
                    + "RESPONSE_FHPROCESAMIENTO='" + respuesta_recepciondte_mh.getFhProcesamiento() + "', "
                    + "RESPONSE_CODIGOMSG='" + respuesta_recepciondte_mh.getCodigoMsg() + "', "
                    + "RESPONSE_DESCRIPCIONMSG='" + respuesta_recepciondte_mh.getDescripcionMsg() + "', "
                    + "RESPONSE_OBSERVACIONES='" + respuesta_recepciondte_mh.getObservaciones().toString() + "', "
                    + "RESPONSE_CLASIFICAMSG='" + respuesta_recepciondte_mh.getClasificaMsg() + "' "
                    + "WHERE "
                    + "ID_DTE=" + id_dte;
            Statement stmt = conn.createStatement();
            System.out.println(cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
            
            String NUMEROCONTROL = ctrl_base_datos.ObtenerString("SELECT F.NUMEROCONTROL FROM IDENTIFICACION_CCF_V3 F WHERE F.ID_DTE=" + id_dte, conn);
            String KCOO_JDE = ctrl_base_datos.ObtenerString("SELECT F.KCOO_JDE FROM DTE_CCF_V3 F WHERE F.ID_DTE=" + id_dte, conn);
            String DOCO_JDE = ctrl_base_datos.ObtenerString("SELECT F.DOCO_JDE FROM DTE_CCF_V3 F WHERE F.ID_DTE=" + id_dte, conn);
            String DCTO_JDE = ctrl_base_datos.ObtenerString("SELECT F.DCTO_JDE FROM DTE_CCF_V3 F WHERE F.ID_DTE=" + id_dte, conn);
            String DOC_JDE = ctrl_base_datos.ObtenerString("SELECT F.DOC_JDE FROM DTE_CCF_V3 F WHERE F.ID_DTE=" + id_dte, conn);
            String DCT_JDE = ctrl_base_datos.ObtenerString("SELECT F.DCT_JDE FROM DTE_CCF_V3 F WHERE F.ID_DTE=" + id_dte, conn);
            
            cadenasql = "UPDATE " + esquema + ".F5542FEL@" + dblink + " SET "
                    + "FESTCD='" + respuesta_recepciondte_mh.getCodigoMsg().trim() + "', "
                    + "FECRSREF01='" + NUMEROCONTROL.trim() + "', "
                    + "FECRSREF02='" + respuesta_recepciondte_mh.getCodigoGeneracion() + "', "
                    + "FECRSREF03='" + respuesta_recepciondte_mh.getSelloRecibido() + "'"
                    + "WHERE FEKCOO='" + KCOO_JDE + "' AND FEDOCO=" + DOCO_JDE + " AND FEDCTO='" + DCTO_JDE + "' AND FEDOC=" + DOC_JDE + " AND FEDCT='" + DCT_JDE + "'";
            stmt = conn.createStatement();
            System.out.println(cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:registro_db_respuesta_mh()|ERROR:" + ex.toString());;
            } catch (Exception ex1) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:registro_db_respuesta_mh()-rollback|ERROR:" + ex.toString());
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:registro_db_respuesta_mh()-finally|ERROR:" + ex.toString());
            }
        }
    }
    
}
