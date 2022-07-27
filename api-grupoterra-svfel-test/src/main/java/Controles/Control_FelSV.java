package Controles;

import ClienteServicio.Cliente_Rest_MH;
import Entidades.JsonDTE;
import Entidades.JsonIn.DOCUMENTO_JDE;
import Entidades.JsonIn.DOCUMENTOS_RELACIONADOS_IN;
import Entidades.JsonIn.RECEPTOR_IN;
import Entidades.Json_Firmado;
import Entidades.JsonIn.DTE_IN;
import Entidades.JsonIn.RESPUESTA_WS_RECEPCION_DTE;
import Entidades.JsonOut.DTE_OUT;
import Entidades.JsonOut.APENDICE_OUT;
import Entidades.JsonOut.CUERPO_DOCUMENTO_OUT;
import Entidades.JsonOut.CUERPO_DOCUMENTO_OUT_NC;
import Entidades.JsonOut.DOCUMENTOS_RELACIONADOS_OUT;
import Entidades.JsonOut.DTE_OUT_NC;
import Entidades.JsonOut.EMISOR_OUT;
import Entidades.JsonOut.EMISOR_OUT_NC;
import Entidades.JsonOut.EXTENSION_OUT;
import Entidades.JsonOut.EXTENSION_OUT_NC;
import Entidades.JsonOut.IDENTIFICACION_OUT;
import Entidades.JsonOut.RECEPTOR_OUT;
import Entidades.JsonOut.RESPUESTA_RECEPCIONDTE_MH;
import Entidades.JsonOut.RESUMEN_OUT;
import Entidades.JsonOut.RESUMEN_OUT_NC;
import Entidades.JsonOut.VENTA_TERCERO_OUT;
import Entidades.TokenMH;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.ArrayList;
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
        Driver driver = new Driver();

        RESPUESTA_WS_RECEPCION_DTE respuesta_ws_recepcion_dte = new RESPUESTA_WS_RECEPCION_DTE();

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
                driver.guardar_en_archivo(id_dte, "JSON-IN:: " + new Gson().toJson(dte_in));

                // RESPUESTA DEL SERVICIO RECEPCION-DTE.
                respuesta_ws_recepcion_dte.setKcoo_jde(dte_in.getKcoo_jde());
                respuesta_ws_recepcion_dte.setMcu_jde(dte_in.getMcu_jde());
                respuesta_ws_recepcion_dte.setDoco_jde(dte_in.getDoco_jde());
                respuesta_ws_recepcion_dte.setDcto_jde(dte_in.getDcto_jde());
                respuesta_ws_recepcion_dte.setDoc_jde(dte_in.getDoc_jde());
                respuesta_ws_recepcion_dte.setDct_jde(dte_in.getDct_jde());
                respuesta_ws_recepcion_dte.setAn8_jde(dte_in.getAn8_jde());
                respuesta_ws_recepcion_dte.setShan_jde(dte_in.getShan_jde());
                respuesta_ws_recepcion_dte.setCrcd_jde(dte_in.getCrcd_jde());
                respuesta_ws_recepcion_dte.setIvd_jde(dte_in.getIvd_jde());

                // REGISTRO TABLA IDENTIFICACION.
                Control_IDENTIFICACION control_identificacion = new Control_IDENTIFICACION();
                control_identificacion.registro_db_tabla_identificacion(conn, dte_in, ambiente, id_dte);

                // REGISTRO TABLA DOCUMENTOS_RELACIONADOS.
                Control_DOCUMENTOS_RELACIONADOS control_documentos_relacionados = new Control_DOCUMENTOS_RELACIONADOS();
                control_documentos_relacionados.registro_db_tabla_documentos_relacionados(conn, dte_in, id_dte);
                
                // REGISTRO TABLA EMISOR.
                Control_EMISOR control_emisor = new Control_EMISOR();

                // REGISTRO TABLA RECEPTOR.
                Control_RECEPTOR control_receptor = new Control_RECEPTOR();
                control_receptor.registro_db_tabla_receptor(conn, dte_in, id_dte);
                
                // REGISTRO TABLA VENTA_TERCERO.
                Control_VENTA_TERCERO control_venta_tercero = new Control_VENTA_TERCERO();

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

                // ******************** INSTANCIA DTE_OUT. ********************
                DTE_OUT json = new DTE_OUT();
                DTE_OUT_NC json_nc = new DTE_OUT_NC();
                
                // GENERAR JSON IDENTIFICACION.
                IDENTIFICACION_OUT identificacion = control_identificacion.registro_json_identificacion(conn, id_dte);
                json.setIdentificacion(identificacion);
                json_nc.setIdentificacion(identificacion);

                // GENERAR JSON DOCUMENTOS RELACIONADOS.
                DOCUMENTOS_RELACIONADOS_OUT documentoRelacionado = control_documentos_relacionados.registro_json_documentos_relacionados(conn, id_dte, identificacion.getTipoDte());
                json.setDocumentoRelacionado(documentoRelacionado);
                json_nc.setDocumentoRelacionado(documentoRelacionado);

                // GENERAR JSON EMISOR.
                EMISOR_OUT emisor = null;
                EMISOR_OUT_NC emisor_nc = null;
                if(dte_in.getDcto_jde().equals("S3")) {
                    emisor = control_emisor.registro_json_emisor(conn, id_dte, dte_in.getMcu_jde());
                    json.setEmisor(emisor);
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    emisor_nc = control_emisor.registro_json_emisor_nc(conn, id_dte, dte_in.getMcu_jde());
                    json_nc.setEmisor(emisor_nc);
                }
                
                // GENERAR JSON RECEPTOR.
                RECEPTOR_OUT receptor = control_receptor.registro_json_receptor(conn, id_dte);
                json.setReceptor(receptor);
                json_nc.setReceptor(receptor);

                // GENERAR JSON VENTA TERCERO.
                VENTA_TERCERO_OUT ventaTercero = control_venta_tercero.registro_json_venta_tercero(conn, id_dte);
                json.setVentaTercero(ventaTercero);
                json_nc.setVentaTercero(ventaTercero);

                // GENERAR JSON CUERPO DOCUMENTO.
                if(dte_in.getDcto_jde().equals("S3")) {
                    List<CUERPO_DOCUMENTO_OUT> cuerpoDocumento = control_cuerpo_documento.registro_json_cuerpo_documento(conn, id_dte);
                    json.setCuerpoDocumento(cuerpoDocumento);
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    List<CUERPO_DOCUMENTO_OUT_NC> cuerpoDocumento_nc = control_cuerpo_documento.registro_json_cuerpo_documento_nc(conn, id_dte);
                    json_nc.setCuerpoDocumento(cuerpoDocumento_nc);
                }
                
                // GENERAR JSON RESUMEN.
                if(dte_in.getDcto_jde().equals("S3")) {
                    RESUMEN_OUT resumen = control_resumen.registro_json_resumen(conn, id_dte);
                    json.setResumen(resumen);
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    RESUMEN_OUT_NC resumen_nc = control_resumen.registro_json_resumen_nc(conn, id_dte);
                    json_nc.setResumen(resumen_nc);
                }
                
                // GENERAR JSON EXTENSION.
                EXTENSION_OUT extension = null;
                EXTENSION_OUT_NC extension_nc = null;
                if(dte_in.getDcto_jde().equals("S3")) {
                    extension = control_extension.registro_json_extension(conn, id_dte);
                    json.setExtension(extension);
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    extension_nc = control_extension.registro_json_extension_nc(conn, id_dte);
                    json_nc.setExtension(extension_nc);
                }
                
                // GENERAR JSON APENDICE.
                APENDICE_OUT apendice = control_apendice.registro_json_apendice(conn, id_dte);
                json.setApendice(apendice);
                json_nc.setApendice(apendice);
                
                Json_Firmado json_firmado = null;
                Gson gson = new GsonBuilder().serializeNulls().create();
                if(dte_in.getDcto_jde().equals("S3")) {
                    driver.guardar_en_archivo(id_dte, "JSON-OUT:: " + gson.toJson(json));
                    Control_JSON_FIRMADO control_json_firmado = new Control_JSON_FIRMADO();
                    json_firmado = control_json_firmado.firmardocumento(emisor.getNit(), json);
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    driver.guardar_en_archivo(id_dte, "JSON-OUT:: " + gson.toJson(json_nc));
                    Control_JSON_FIRMADO control_json_firmado = new Control_JSON_FIRMADO();
                    json_firmado = control_json_firmado.firmardocumento_nc(emisor_nc.getNit(), json_nc);
                }
                // System.out.println("******************** JSON DTE-OUT: " + gson.toJson(json));
                // resultado = gson.toJson(json);

                // FIRMAR DOCUMENTO.
                driver.guardar_en_archivo(id_dte, "JSON-FIRMADO:: " + new Gson().toJson(json_firmado));
                // System.out.println("******************** JSON FIRMADO: " + new Gson().toJson(json_firmado));
                // resultado = new Gson().toJson(json_firmado);

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = "";
                if(dte_in.getDcto_jde().equals("S3")) {
                    token_autenticacion = cliente_rest_mh.autenticar(emisor.getNit(), "UNOSV2021*");
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    token_autenticacion = cliente_rest_mh.autenticar(emisor_nc.getNit(), "UNOSV2021*");
                }
                
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(id_dte, "JSON-TOKEN:: " + new Gson().toJson(token_mh));
                // System.out.println("******************** JSON TOKEN: " + new Gson().toJson(token_mh));
                // resultado = new Gson().toJson(token_mh);

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(identificacion.getVersion());
                json_dte.setAmbiente(identificacion.getAmbiente());
                json_dte.setTipoDte(identificacion.getTipoDte());
                json_dte.setIdEnvio(id_dte);
                json_dte.setDocumento(json_firmado.getBody());
                driver.guardar_en_archivo(id_dte, "JSON-DTE:: " + new Gson().toJson(json_dte));
                // System.out.println("******************** JSON DTE: " + new Gson().toJson(json_dte));
                // resultado = new Gson().toJson(json_dte);

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                control_dte.registro_db_respuesta_mh(conn, respuesta_recepciondte_mh, id_dte);
                driver.guardar_en_archivo(id_dte, "RESPUESTA-JSON-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
                // System.out.println("******************** RESPUESTA_RECEPCIONDTE_MH: " + new Gson().toJson(respuesta_recepciondte_mh));
                // resultado = new Gson().toJson(respuesta_recepciondte_mh);

                // RESPUESTA DEL SERVICIO RECEPCION-DTE.
                respuesta_ws_recepcion_dte.setVersion(respuesta_recepciondte_mh.getVersion());
                respuesta_ws_recepcion_dte.setAmbiente(respuesta_recepciondte_mh.getAmbiente());
                respuesta_ws_recepcion_dte.setVersionApp(respuesta_recepciondte_mh.getVersionApp());
                respuesta_ws_recepcion_dte.setEstado(respuesta_recepciondte_mh.getEstado());
                respuesta_ws_recepcion_dte.setNumeroControl(identificacion.getNumeroControl());
                respuesta_ws_recepcion_dte.setCodigoGeneracion(respuesta_recepciondte_mh.getCodigoGeneracion());
                respuesta_ws_recepcion_dte.setSelloRecibido(respuesta_recepciondte_mh.getSelloRecibido());
                respuesta_ws_recepcion_dte.setFhProcesamiento(respuesta_recepciondte_mh.getFhProcesamiento());
                respuesta_ws_recepcion_dte.setClasificaMsg(respuesta_recepciondte_mh.getClasificaMsg());
                respuesta_ws_recepcion_dte.setCodigoMsg(respuesta_recepciondte_mh.getCodigoMsg());
                respuesta_ws_recepcion_dte.setDescripcionMsg(respuesta_recepciondte_mh.getDescripcionMsg());
                respuesta_ws_recepcion_dte.setObservaciones(respuesta_recepciondte_mh.getObservaciones());
                if(dte_in.getDcto_jde().equals("S3")) {
                    respuesta_ws_recepcion_dte.setNombEntrega(extension.getNombEntrega());
                    respuesta_ws_recepcion_dte.setDocuEntrega(extension.getDocuEntrega());
                    respuesta_ws_recepcion_dte.setCodEmpleado(extension.getCodEmpleado());
                    respuesta_ws_recepcion_dte.setNombRecibe(extension.getNombRecibe());
                    respuesta_ws_recepcion_dte.setDocuRecibe(extension.getDocuRecibe());
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    respuesta_ws_recepcion_dte.setNombEntrega(extension_nc.getNombEntrega());
                    respuesta_ws_recepcion_dte.setDocuEntrega(extension_nc.getDocuEntrega());
                    respuesta_ws_recepcion_dte.setCodEmpleado(extension_nc.getCodEmpleado());
                    respuesta_ws_recepcion_dte.setNombRecibe(extension_nc.getNombRecibe());
                    respuesta_ws_recepcion_dte.setDocuRecibe(extension_nc.getDocuRecibe());
                }
                if(dte_in.getDcto_jde().equals("S3")) {
                    respuesta_ws_recepcion_dte.setNit_emisor(emisor.getNit());
                    respuesta_ws_recepcion_dte.setNrc_emisor(emisor.getNrc());
                    respuesta_ws_recepcion_dte.setNum_facturador_emisor(emisor.getNumFacturador());
                    respuesta_ws_recepcion_dte.setNombre_razon_social_emisor(emisor.getNombreComercial());
                    respuesta_ws_recepcion_dte.setCodigo_actividad_emisor(emisor.getActividad1().getCodActividad());
                    respuesta_ws_recepcion_dte.setNombre_actividad_emisor(emisor.getActividad1().getDescActividad());
                }
                if(dte_in.getDcto_jde().equals("C3")) {
                    respuesta_ws_recepcion_dte.setNit_emisor(emisor_nc.getNit());
                    respuesta_ws_recepcion_dte.setNrc_emisor(emisor_nc.getNrc());
                    respuesta_ws_recepcion_dte.setNum_facturador_emisor(emisor_nc.getNumFacturador());
                    respuesta_ws_recepcion_dte.setNombre_razon_social_emisor(emisor_nc.getNombreComercial());
                    respuesta_ws_recepcion_dte.setCodigo_actividad_emisor(emisor_nc.getActividad1().getCodActividad());
                    respuesta_ws_recepcion_dte.setNombre_actividad_emisor(emisor_nc.getActividad1().getDescActividad());
                }
                driver.guardar_en_archivo(id_dte, "RESPUESTA-RECEPCION-DTE:: " + gson.toJson(respuesta_ws_recepcion_dte));
                // System.out.println("******************** RESPUESTA_WS_RECEPCION_DTE: " + gson.toJson(respuesta_ws_recepcion_dte));
                resultado = gson.toJson(respuesta_ws_recepcion_dte);

                // APLICA CAMBIOS EN LA BASE DE DATOS.
                conn.commit();
            } else {
                resultado = result[1];
                List<String> linea_resultado = new ArrayList<>();
                linea_resultado.add(resultado);
                respuesta_ws_recepcion_dte.setCodigoMsg("123");
                respuesta_ws_recepcion_dte.setDescripcionMsg("Error interno servicio recepcion-det.");
                respuesta_ws_recepcion_dte.setObservaciones(linea_resultado);
                Gson gson = new GsonBuilder().serializeNulls().create();
                resultado = gson.toJson(respuesta_ws_recepcion_dte);
            }

            // TERMINA TRANSACCION EN LA BASE DE DATOS.
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);

                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte | Error: " + ex.toString();
                List<String> linea_resultado = new ArrayList<>();
                linea_resultado.add(resultado);
                respuesta_ws_recepcion_dte.setCodigoMsg("123");
                respuesta_ws_recepcion_dte.setDescripcionMsg("Error interno servicio recepcion-det.");
                respuesta_ws_recepcion_dte.setObservaciones(linea_resultado);
                Gson gson = new GsonBuilder().serializeNulls().create();
                resultado = gson.toJson(respuesta_ws_recepcion_dte);
            } catch (Exception ex1) {
                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - rollback | Error: " + ex1.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - rollback | Error: " + ex1.toString();
                List<String> linea_resultado = new ArrayList<>();
                linea_resultado.add(resultado);
                respuesta_ws_recepcion_dte.setCodigoMsg("123");
                respuesta_ws_recepcion_dte.setDescripcionMsg("Error interno servicio recepcion-det.");
                respuesta_ws_recepcion_dte.setObservaciones(linea_resultado);
                Gson gson = new GsonBuilder().serializeNulls().create();
                resultado = gson.toJson(respuesta_ws_recepcion_dte);
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - finally | Error: " + ex.toString());
                resultado = "Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: recepcion_dte - finally | Error: " + ex.toString();
                List<String> linea_resultado = new ArrayList<>();
                linea_resultado.add(resultado);
                respuesta_ws_recepcion_dte.setCodigoMsg("123");
                respuesta_ws_recepcion_dte.setDescripcionMsg("Error interno servicio recepcion-det.");
                respuesta_ws_recepcion_dte.setObservaciones(linea_resultado);
                Gson gson = new GsonBuilder().serializeNulls().create();
                resultado = gson.toJson(respuesta_ws_recepcion_dte);
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
