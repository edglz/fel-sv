package Controles;

import ClienteServicio.Cliente_Rest_MH;
import Entidades.JsonDTE;
import Entidades.JsonIn.DOCUMENTO_JDE;
import Entidades.JsonIn.DOCUMENTOS_RELACIONADOS_IN;
import Entidades.JsonIn.RECEPTOR_IN;
import Entidades.Json_Firmado;
import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.DTE_OUT;
import Entidades.JsonOut.APENDICE_OUT;
import Entidades.JsonOut.CUERPO_DOCUMENTO_OUT;
import Entidades.JsonOut.DOCUMENTOS_RELACIONADOS_OUT;
import Entidades.JsonOut.EMISOR_OUT;
import Entidades.JsonOut.EXTENSION_OUT;
import Entidades.JsonOut.IDENTIFICACION_OUT;
import Entidades.JsonOut.RECEPTOR_OUT;
import Entidades.JsonOut.RESPUESTA_RECEPCIONDTE_MH;
import Entidades.JsonOut.RESUMEN_OUT;
import Entidades.JsonOut.VENTA_TERCERO_OUT;
import Entidades.TokenMH;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Control_FelSV implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_FelSV() {
    }

    public String recepcion_dte(String jsonString, String ambiente) {
        String resultado = "";
        Connection conn = null;

        try {
            // CONVERTIR JSONSTRING A LA CLASE DTE_IN
            Type listType = new TypeToken<DTE_IN>() {
            }.getType();
            DTE_IN dte_in = new Gson().fromJson(jsonString, listType);
            // System.out.println("******************** JSON DTE-IN: " + new Gson().toJson(dte_in));
            // resultado = new Gson().toJson(dte_in);

            // CONEXION HACIA LA BASE DE DATOS.
            String jndi_name = "";
            if (ambiente.equals("test")) {
                jndi_name = "java:/comp/env/fel_sv_test";
            } else {
                jndi_name = "java:/comp/env/fel_sv_prod";
            }

            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup(jndi_name);
            conn = ds.getConnection();

            // INICIA TRANSACCION EN LA BASE DE DATOS.
            conn.setAutoCommit(false);

            // REGISTRO TABLA DTE.
            Control_DTE control_dte = new Control_DTE();
            String[] result = control_dte.valida_campos_raiz_dte(conn, dte_in).split(",");
            Long id_dte = Long.parseLong("0");
            if (result[0].equals("0")) {
                id_dte = control_dte.registro_db_tabla_dte(conn, dte_in);
                // REGISTRO TABLA IDENTIFICACION.
                Control_IDENTIFICACION control_identificacion = new Control_IDENTIFICACION();
                control_identificacion.registro_db_tabla_identificacion(conn, dte_in, ambiente, id_dte);
                // REGISTRO TABLA DOCUMENTOS_RELACIONADOS.
                Control_DOCUMENTOS_RELACIONADOS control_documentos_relacionados = new Control_DOCUMENTOS_RELACIONADOS();
                control_documentos_relacionados.registro_db_tabla_documentos_relacionados(conn, dte_in, id_dte);
                // REGISTRO TABLA RECEPTOR.
                Control_RECEPTOR control_receptor = new Control_RECEPTOR();
                control_receptor.registro_db_tabla_receptor(conn, dte_in, id_dte);
                // REGISTRO TABLA CUERPO_DOCUMENTO.
                Control_CUERPO_DOCUMENTO control_cuerpo_documento = new Control_CUERPO_DOCUMENTO();
                control_cuerpo_documento.registro_db_tabla_cuerpo_documento(conn, dte_in, id_dte);
                // REGISTRO TABLA RESUMEN.
                Control_RESUMEN control_resumen = new Control_RESUMEN();
                control_resumen.registro_db_tabla_resumen(conn, dte_in, id_dte);
                // REGISTRO TABLA EXTENSION.
                Control_EXTENSION control_extension = new Control_EXTENSION();
                control_extension.registro_db_tabla_extension(conn, dte_in, id_dte);
                // REGISTRO TABLA APENDICE.
                Control_APENDICE control_apendice = new Control_APENDICE();
                control_apendice.registro_db_tabla_apendice(conn, dte_in, id_dte);

                // INSTANCIA DTE_OUT.
                DTE_OUT json = new DTE_OUT();

                // GENERAR JSON IDENTIFICACION.
                IDENTIFICACION_OUT identificacion = control_identificacion.registro_json_identificacion(conn, id_dte);
                json.setIdentificacion(identificacion);
                // GENERAR JSON DOCUMENTOS RELACIONADOS.
                DOCUMENTOS_RELACIONADOS_OUT documentoRelacionado = control_documentos_relacionados.registro_json_documentos_relacionados(conn, id_dte, identificacion.getTipoDte());
                json.setDocumentoRelacionado(documentoRelacionado);
                // GENERAR JSON EMISOR.
                Control_EMISOR control_emisor = new Control_EMISOR();
                EMISOR_OUT emisor = control_emisor.registro_json_emisor(conn, id_dte, dte_in.getMcu_jde());
                json.setEmisor(emisor);
                // GENERAR JSON RECEPTOR.
                RECEPTOR_OUT receptor = control_receptor.registro_json_receptor(conn, id_dte);
                json.setReceptor(receptor);
                // GENERAR JSON VENTA TERCERO.
                Control_VENTA_TERCERO control_venta_tercero = new Control_VENTA_TERCERO();
                VENTA_TERCERO_OUT ventaTercero = control_venta_tercero.registro_json_venta_tercero(conn, id_dte);
                json.setVentaTercero(ventaTercero);
                // GENERAR JSON CUERPO DOCUMENTO.
                List<CUERPO_DOCUMENTO_OUT> cuerpoDocumento = control_cuerpo_documento.registro_json_cuerpo_documento(conn, id_dte);
                json.setCuerpoDocumento(cuerpoDocumento);
                // GENERAR JSON RESUMEN.
                RESUMEN_OUT resumen = control_resumen.registro_json_resumen(conn, id_dte);
                json.setResumen(resumen);
                // GENERAR JSON EXTENSION.
                EXTENSION_OUT extension = control_extension.registro_json_extension(conn, id_dte);
                json.setExtension(extension);
                // GENERAR JSON APENDICE.
                APENDICE_OUT apendice = control_apendice.registro_json_apendice(conn, id_dte);
                json.setApendice(apendice);
                Gson gson = new GsonBuilder().serializeNulls().create();
                System.out.println("******************** JSON DTE-OUT: " + gson.toJson(json));
                resultado = gson.toJson(json);
                
            } else {
                resultado = result[1];
            }

            // FIRMAR DOCUMENTO.
//            Control_JSON_FIRMADO control_json_firmado = new Control_JSON_FIRMADO();
//            Json_Firmado json_firmado = control_json_firmado.firmardocumento(emisor.getNit(), json);
            // System.out.println("******************** JSON FIRMADO: " + new Gson().toJson(json_firmado));
            // resultado = new Gson().toJson(json_firmado);
            // GENERAR TOKEN MINISTERIO DE HACIENDA.
//            Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
//            String token_autenticacion = cliente_rest_mh.autenticar(emisor.getNit(), "UNOSV2021*");
//            Type listType1 = new TypeToken<TokenMH>() {
//            }.getType();
//            TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
            // System.out.println("******************** JSON TOKEN: " + new Gson().toJson(token_mh));
            // resultado = new Gson().toJson(token_mh);
            // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
//            JsonDTE json_dte = new JsonDTE();
//            json_dte.setVersion(identificacion.getVersion());
//            json_dte.setAmbiente(identificacion.getAmbiente());
//            json_dte.setTipoDte(identificacion.getTipoDte());
//            json_dte.setIdEnvio(id_dte);
//            json_dte.setDocumento(json_firmado.getBody());
            // System.out.println("******************** JSON DTE: " + new Gson().toJson(json_dte));
            // resultado = new Gson().toJson(json_dte);
            // RESPUESTA DEL MINISTERIO DE HACIENDA.
//            String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
//            Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
//            }.getType();
//            RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
            // System.out.println("******************** RESPUESTA_RECEPCIONDTE_MH: " + new Gson().toJson(respuesta_recepciondte_mh));
//            resultado = new Gson().toJson(respuesta_recepciondte_mh);
            // CLASE PARA LA RESPUESTA DEL SERVICIO.
//            RESPUESTA_WS_RECEPCION_DTE respuesta_ws_recepcion_dte = new RESPUESTA_WS_RECEPCION_DTE();
//            respuesta_ws_recepcion_dte.setKcoo_jde(dte_in.getKcoo_jde());
//            respuesta_ws_recepcion_dte.setMcu_jde(dte_in.getMcu_jde());
//            respuesta_ws_recepcion_dte.setDoco_jde(dte_in.getDoco_jde());
//            respuesta_ws_recepcion_dte.setDcto_jde(dte_in.getDcto_jde());
//            respuesta_ws_recepcion_dte.setDoc_jde(dte_in.getDoc_jde());
//            respuesta_ws_recepcion_dte.setDct_jde(dte_in.getDct_jde());
//            respuesta_ws_recepcion_dte.setAn8_jde(dte_in.getAn8_jde());
//            respuesta_ws_recepcion_dte.setShan_jde(dte_in.getShan_jde());
//            respuesta_ws_recepcion_dte.setCrcd_jde(dte_in.getCrcd_jde());
//            respuesta_ws_recepcion_dte.setIvd_jde(dte_in.getIvd_jde());
//            respuesta_ws_recepcion_dte.setVersion(respuesta_recepciondte_mh.getVersion());
//            respuesta_ws_recepcion_dte.setAmbiente(respuesta_recepciondte_mh.getAmbiente());
//            respuesta_ws_recepcion_dte.setVersionApp(respuesta_recepciondte_mh.getVersionApp());
//            respuesta_ws_recepcion_dte.setEstado(respuesta_recepciondte_mh.getEstado());
//            respuesta_ws_recepcion_dte.setCodigoGeneracion(respuesta_recepciondte_mh.getCodigoGeneracion());
//            respuesta_ws_recepcion_dte.setNumValidacion(respuesta_recepciondte_mh.getNumValidacion());
//            respuesta_ws_recepcion_dte.setFhProcesamiento(respuesta_recepciondte_mh.getFhProcesamiento());
//            respuesta_ws_recepcion_dte.setCodigoMsg(respuesta_recepciondte_mh.getCodigoMsg());
//            respuesta_ws_recepcion_dte.setDescripcionMsg(respuesta_recepciondte_mh.getDescripcionMsg());
//            respuesta_ws_recepcion_dte.setObservaciones(respuesta_recepciondte_mh.getObservaciones());
//            respuesta_ws_recepcion_dte.setNombEntrega(extension.getNombEntrega());
//            respuesta_ws_recepcion_dte.setDocuEntrega(extension.getDocuEntrega());
//            respuesta_ws_recepcion_dte.setCodEmpleado(extension.getCodEmpleado());
//            respuesta_ws_recepcion_dte.setNombRecibe(extension.getNombRecibe());
//            respuesta_ws_recepcion_dte.setDocuRecibe(extension.getDocuRecibe());
//            respuesta_ws_recepcion_dte.setNit_emisor(emisor.getNit());
//            respuesta_ws_recepcion_dte.setNrc_emisor(emisor.getNrc());
//            respuesta_ws_recepcion_dte.setNum_facturador_emisor(emisor.getNumFacturador());
//            respuesta_ws_recepcion_dte.setNombre_razon_social_emisor(emisor.getNombreComercial());
//            respuesta_ws_recepcion_dte.setCodigo_actividad_emisor(emisor.getActividad1().getCodActividad());
//            respuesta_ws_recepcion_dte.setNombre_actividad_emisor(emisor.getActividad1().getDescActividad());
            // System.out.println("******************** RESPUESTA_WS_RECEPCION_DTE: " + new Gson().toJson(respuesta_ws_recepcion_dte));
//            resultado = new Gson().toJson(respuesta_ws_recepcion_dte);
            // APLICA CAMBIOS EN LA BASE DE DATOS.
            conn.commit();

            // TERMINA TRANSACCION EN LA BASE DE DATOS.
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString();
            } catch (Exception ex1) {
                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - rollback | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - rollback | Error: " + ex.toString();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - finally | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - finally | Error: " + ex.toString();
            }
        }

        return resultado;
    }

    public String extraer_recepcion_dte(String jsonString, String ambiente) {
        String resultado = "";
        Connection conn = null;

        try {
            // CONVERTIR JSONSTRING A LA CLASE DTE_IN
            Type listType = new TypeToken<DOCUMENTO_JDE>() {
            }.getType();
            DOCUMENTO_JDE documento_jde = new Gson().fromJson(jsonString, listType);

            // CONEXION HACIA LA BASE DE DATOS.
            String jndi_name = "";
            if (ambiente.equals("test")) {
                jndi_name = "java:/comp/env/jdbc_oracle";
            } else {
                jndi_name = "java:/comp/env/jdbc_oracle_prod";
            }

            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup(jndi_name);
            conn = ds.getConnection();

            // INICIA TRANSACCION EN LA BASE DE DATOS.
            conn.setAutoCommit(false);

            DTE_IN dte_in = new DTE_IN();

            dte_in.setKcoo_jde(documento_jde.getKcoo_jde());
            dte_in.setMcu_jde(documento_jde.getMcu_jde());
            dte_in.setDoco_jde(documento_jde.getDoco_jde());
            dte_in.setDcto_jde(documento_jde.getDcto_jde());
            dte_in.setDoc_jde(documento_jde.getDoc_jde());
            dte_in.setDct_jde(documento_jde.getDct_jde());
            dte_in.setAn8_jde(documento_jde.getAn8_jde());
            dte_in.setShan_jde(documento_jde.getShan_jde());
            dte_in.setCrcd_jde(documento_jde.getCrcd_jde());
            dte_in.setIvd_jde(documento_jde.getIvd_jde());

            Control_DOCUMENTOS_RELACIONADOS control_documentos_relacionados = new Control_DOCUMENTOS_RELACIONADOS();
            DOCUMENTOS_RELACIONADOS_IN documentos_relacionados_in = control_documentos_relacionados.extraer_documento_relacionado_jde(conn, ambiente, dte_in.getDcto_jde());
            dte_in.setDocumentoRelacionado(documentos_relacionados_in);

            Control_RECEPTOR control_receptor = new Control_RECEPTOR();
            RECEPTOR_IN receptor_in = control_receptor.extraer_receptor_jde(conn, ambiente, dte_in.getDcto_jde(), dte_in.getShan_jde());
            dte_in.setReceptor(receptor_in);

            // System.out.println("******************** JSON DTE_IN: " + new Gson().toJson(dte_in));
            resultado = new Gson().toJson(dte_in);

            // APLICA CAMBIOS EN LA BASE DE DATOS.
            conn.commit();

            // TERMINA TRANSACCION EN LA BASE DE DATOS.
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: extraer_recepcion_dte | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: extraer_recepcion_dte | Error: " + ex.toString();
            } catch (Exception ex1) {
                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: extraer_recepcion_dte - rollback | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: extraer_recepcion_dte - rollback | Error: " + ex.toString();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - finally | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - finally | Error: " + ex.toString();
            }
        }

        return resultado;
    }

}
