package servicio;

import ClienteServicio.Cliente_Rest_MH;
import Controladores.Ctrl_DTE_CCF_V3;
import Controladores.Ctrl_DTE_FEX_V3;
import Controladores.Ctrl_DTE_NC_V3;
import Controladores.Ctrl_DTE_ND_V3;
import Controladores.Ctrl_DTE_F_V3;
import Controladores.Ctrl_DTE_INVALIDACION_V3;
import Controladores.Ctrl_DTE_NR_V3;
import Controladores.Ctrl_DTE_V3;
import Controladores.Ctrl_Firmar_Documento_JWT;
import Controladores.Driver;
import Entidades.DTE_CCF_V3;
import Entidades.DTE_FEX_V3;
import Entidades.DTE_NC_V3;
import Entidades.DTE_ND_V3;
import Entidades.DTE_F_V3;
import Entidades.DTE_INVALIDACION_V3;
import Entidades.DTE_NR_V3;
import Entidades.JsonDTE;
import Entidades.Json_Firmado;
import Entidades.RESPUESTA_RECEPCIONDTE_MH;
import Entidades.TokenMH;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("felsv")
public class MyResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it! (CAMBIO).";
    }

    @Path("selecionar-documentos-v3/{ambiente}/{fecha}/{modo}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Integer selecionar_documentos_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {
        
        Integer resultado = 0;

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            resultado = ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:selecionar_documentos_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }

    @Path("extraer-documento-jde-ccf-v3/{ambiente}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String extraer_documento_jde_ccf_v3(@PathParam("ambiente") String ambiente) {
        String resultado = "";

        try {
            Ctrl_DTE_CCF_V3 ctrl_dte_ccf_v3 = new Ctrl_DTE_CCF_V3();
            List<Long> no_dtes = ctrl_dte_ccf_v3.extraer_documento_jde_ccf_v3(ambiente);
            resultado = "No. de Documentos procesados: " + no_dtes.size();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_ccf_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }

    @Path("certificar-ccf-v3/{ambiente}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String certificar_ccf_v3(
            @PathParam("ambiente") String ambiente) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_CCF_V3 ctrl_dte_ccf_v3 = new Ctrl_DTE_CCF_V3();
            List<Long> no_dtes = ctrl_dte_ccf_v3.extraer_documento_jde_ccf_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_CCF_V3 dte_ccf_v3 = ctrl_dte_ccf_v3.generar_json_dte_ccf_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_ccf_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_ccf_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "ccf", gson.toJson(dte_ccf_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_ccf_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_ccf_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_ccf_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_ccf_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_ccf_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_ccf_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_ccf_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("recepciondte-ccf-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recepciondte_ccf_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_CCF_V3 ctrl_dte_ccf_v3 = new Ctrl_DTE_CCF_V3();
            List<Long> no_dtes = ctrl_dte_ccf_v3.extraer_documento_jde_ccf_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_CCF_V3 dte_ccf_v3 = ctrl_dte_ccf_v3.generar_json_dte_ccf_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_ccf_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_ccf_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "ccf", gson.toJson(dte_ccf_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_ccf_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_ccf_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_ccf_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_ccf_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_ccf_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_ccf_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "ccf", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_ccf_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("extraer-documento-jde-nc-v3/{ambiente}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String extraer_documento_jde_nc_v3(@PathParam("ambiente") String ambiente) {
        String resultado = "";

        try {
            Ctrl_DTE_NC_V3 ctrl_dte_nc_v3 = new Ctrl_DTE_NC_V3();
            List<Long> no_dtes = ctrl_dte_nc_v3.extraer_documento_jde_nc_v3(ambiente);
            resultado = "No. de Documentos procesados: " + no_dtes.size();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_nc_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("certificar-nc-v3/{ambiente}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String certificar_nc_v3(
            @PathParam("ambiente") String ambiente) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_NC_V3 ctrl_dte_nc_v3 = new Ctrl_DTE_NC_V3();
            List<Long> no_dtes = ctrl_dte_nc_v3.extraer_documento_jde_nc_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_NC_V3 dte_nc_v3 = ctrl_dte_nc_v3.generar_json_dte_nc_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_nc_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_nc_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "nc", gson.toJson(dte_nc_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_nc_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_nc_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_nc_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_nc_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_nc_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_nc_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_nc_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("recepciondte-nc-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recepciondte_nc_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_NC_V3 ctrl_dte_nc_v3 = new Ctrl_DTE_NC_V3();
            List<Long> no_dtes = ctrl_dte_nc_v3.extraer_documento_jde_nc_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_NC_V3 dte_nc_v3 = ctrl_dte_nc_v3.generar_json_dte_nc_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_nc_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_nc_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "nc", gson.toJson(dte_nc_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_nc_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_nc_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_nc_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_nc_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_nc_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_nc_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "nc", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_nc_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("extraer-documento-jde-nd-v3/{ambiente}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String extraer_documento_jde_nd_v3(@PathParam("ambiente") String ambiente) {
        String resultado = "";

        try {
            Ctrl_DTE_ND_V3 ctrl_dte_nd_v3 = new Ctrl_DTE_ND_V3();
            List<Long> no_dtes = ctrl_dte_nd_v3.extraer_documento_jde_nd_v3(ambiente);
            resultado = "No. de Documentos procesados: " + no_dtes.size();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_nd_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("certificar-nd-v3/{ambiente}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String certificar_nd_v3(
            @PathParam("ambiente") String ambiente) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_ND_V3 ctrl_dte_nd_v3 = new Ctrl_DTE_ND_V3();
            List<Long> no_dtes = ctrl_dte_nd_v3.extraer_documento_jde_nd_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_ND_V3 dte_nd_v3 = ctrl_dte_nd_v3.generar_json_dte_nd_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_nd_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_nd_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "nd", gson.toJson(dte_nd_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_nd_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_nd_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_nd_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_nd_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_nd_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_nd_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_nd_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("recepciondte-nd-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recepciondte_nd_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_ND_V3 ctrl_dte_nd_v3 = new Ctrl_DTE_ND_V3();
            List<Long> no_dtes = ctrl_dte_nd_v3.extraer_documento_jde_nd_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_ND_V3 dte_nd_v3 = ctrl_dte_nd_v3.generar_json_dte_nd_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_nd_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_nd_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "nd", gson.toJson(dte_nd_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_nd_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_nd_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_nd_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_nd_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_nd_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_nd_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "nd", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_nd_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("extraer-documento-jde-f-v3/{ambiente}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String extraer_documento_jde_f_v3(@PathParam("ambiente") String ambiente) {
        String resultado = "";

        try {
            Ctrl_DTE_F_V3 ctrl_dte_f_v3 = new Ctrl_DTE_F_V3();
            List<Long> no_dtes = ctrl_dte_f_v3.extraer_documento_jde_f_v3(ambiente);
            resultado = "No. de Documentos procesados: " + no_dtes.size();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_f_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }

    @Path("certificar-f-v3/{ambiente}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String certificar_f_v3(
            @PathParam("ambiente") String ambiente) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_F_V3 ctrl_dte_f_v3 = new Ctrl_DTE_F_V3();
            List<Long> no_dtes = ctrl_dte_f_v3.extraer_documento_jde_f_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_F_V3 dte_f_v3 = ctrl_dte_f_v3.generar_json_dte_f_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_f_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_f_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "f", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "f", gson.toJson(dte_f_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_f_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "f", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_f_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_f_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_f_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "f", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_f_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "f", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_f_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "f", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_f_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("recepciondte-f-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recepciondte_f_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_F_V3 ctrl_dte_f_v3 = new Ctrl_DTE_F_V3();
            List<Long> no_dtes = ctrl_dte_f_v3.extraer_documento_jde_f_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_F_V3 dte_f_v3 = ctrl_dte_f_v3.generar_json_dte_f_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_f_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_f_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "f", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "f", gson.toJson(dte_f_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_f_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "f", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_f_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_f_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_f_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "f", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_f_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "f", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_f_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "f", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_f_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("extraer-documento-jde-fex-v3/{ambiente}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String extraer_documento_jde_fex_v3(@PathParam("ambiente") String ambiente) {
        String resultado = "";

        try {
            Ctrl_DTE_FEX_V3 ctrl_dte_fex_v3 = new Ctrl_DTE_FEX_V3();
            List<Long> no_dtes = ctrl_dte_fex_v3.extraer_documento_jde_fex_v3(ambiente);
            resultado = "No. de Documentos procesados: " + no_dtes.size();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_fex_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }

    @Path("certificar-fex-v3/{ambiente}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String certificar_fex_v3(
            @PathParam("ambiente") String ambiente) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_FEX_V3 ctrl_dte_fex_v3 = new Ctrl_DTE_FEX_V3();
            List<Long> no_dtes = ctrl_dte_fex_v3.extraer_documento_jde_fex_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_FEX_V3 dte_fex_v3 = ctrl_dte_fex_v3.generar_json_dte_fex_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_fex_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_fex_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "fex", gson.toJson(dte_fex_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_fex_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_fex_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_fex_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_fex_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_fex_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_fex_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_fex_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("recepciondte-fex-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recepciondte_fex_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_FEX_V3 ctrl_dte_fex_v3 = new Ctrl_DTE_FEX_V3();
            List<Long> no_dtes = ctrl_dte_fex_v3.extraer_documento_jde_fex_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_FEX_V3 dte_fex_v3 = ctrl_dte_fex_v3.generar_json_dte_fex_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_fex_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_fex_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "fex", gson.toJson(dte_fex_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_fex_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_fex_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_fex_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_fex_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_fex_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_fex_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "fex", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_fex_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("extraer-documento-jde-nr-v3/{ambiente}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String extraer_documento_jde_nr_v3(@PathParam("ambiente") String ambiente) {
        String resultado = "";

        try {
            Ctrl_DTE_NR_V3 ctrl_dte_nr_v3 = new Ctrl_DTE_NR_V3();
            List<Long> no_dtes = ctrl_dte_nr_v3.extraer_documento_jde_nr_v3(ambiente);
            resultado = "No. de Documentos procesados: " + no_dtes.size();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:extraer_documento_jde_nr_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }

    @Path("certificar-nr-v3/{ambiente}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String certificar_nr_v3(
            @PathParam("ambiente") String ambiente) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_NR_V3 ctrl_dte_nr_v3 = new Ctrl_DTE_NR_V3();
            List<Long> no_dtes = ctrl_dte_nr_v3.extraer_documento_jde_nr_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_NR_V3 dte_nr_v3 = ctrl_dte_nr_v3.generar_json_dte_nr_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_nr_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_nr_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "nr", gson.toJson(dte_nr_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_nr_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_nr_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_nr_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_nr_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_nr_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_nr_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_nr_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("recepciondte-nr-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recepciondte_nr_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_NR_V3 ctrl_dte_nr_v3 = new Ctrl_DTE_NR_V3();
            List<Long> no_dtes = ctrl_dte_nr_v3.extraer_documento_jde_nr_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_NR_V3 dte_nr_v3 = ctrl_dte_nr_v3.generar_json_dte_nr_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_nr_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_nr_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "nr", gson.toJson(dte_nr_v3));

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_nr_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_nr_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_nr_v3.getIdentificacion().getAmbiente());
                json_dte.setTipoDte(dte_nr_v3.getIdentificacion().getTipoDte());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_nr_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_nr_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "nr", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:recepciondte_nr_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
    @Path("anulardte-v3/{ambiente}/{fecha}/{modo}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String anulardte_v3(
            @PathParam("ambiente") String ambiente,
            @PathParam("fecha") String fecha,
            @PathParam("modo") Integer modo) {

        Driver driver = new Driver();
        String resultado = "";

        try {
            Ctrl_DTE_V3 ctrl_dte_v3 = new Ctrl_DTE_V3();
            ctrl_dte_v3.selecionar_documentos_v3(ambiente, fecha, modo);
            
            // EXTRAER DOCUMENTOS DESDE JDE HACIA FEL_TEST.
            Ctrl_DTE_INVALIDACION_V3 ctrl_dte_invalidacion_v3 = new Ctrl_DTE_INVALIDACION_V3();
            List<Long> no_dtes = ctrl_dte_invalidacion_v3.extraer_documento_jde_invalidacion_v3(ambiente);

            for (Integer d = 0; d < no_dtes.size(); d++) {
                // GENERAR JSON SIN FIRMAR.
                DTE_INVALIDACION_V3 dte_invalidacion_v3 = ctrl_dte_invalidacion_v3.generar_json_dte_invalidacion_v3(ambiente, no_dtes.get(d));
                Gson gson = new GsonBuilder().serializeNulls().create();
                String dte_sin_firmar = "{"
                        + "\"nit\":\"" + dte_invalidacion_v3.getEmisor().getNit() + "\","
                        + "\"activo\":true,"
                        + "\"passwordPri\":\"UNOSV2021*\","
                        + "\"dteJson\":" + gson.toJson(dte_invalidacion_v3)
                        + "}";
                driver.guardar_en_archivo(no_dtes.get(d), "anulardte", "JSON-NO-FIRMADO:: " + dte_sin_firmar);
                driver.guardar_en_archivo_json(no_dtes.get(d), "anulardte", dte_sin_firmar);

                // FIRMAR JSON CON JWT.
                Ctrl_Firmar_Documento_JWT ctrl_firmar_documento_jwt = new Ctrl_Firmar_Documento_JWT();
                Json_Firmado dte_firmado = ctrl_firmar_documento_jwt.firmardocumento(dte_invalidacion_v3.getEmisor().getNit(), dte_sin_firmar);
                driver.guardar_en_archivo(no_dtes.get(d), "anulardte", "JSON-FIRMADO:: " + new Gson().toJson(dte_firmado));

                // ENVIAR DOCUMENTO AL MINISTERIO DE HACIENDA.
                JsonDTE json_dte = new JsonDTE();
                json_dte.setVersion(dte_invalidacion_v3.getIdentificacion().getVersion().intValue());
                json_dte.setAmbiente(dte_invalidacion_v3.getIdentificacion().getAmbiente());
                json_dte.setIdEnvio(no_dtes.get(d));
                json_dte.setDocumento(dte_firmado.getBody());
                driver.guardar_en_archivo(no_dtes.get(d), "anulardte", "JSON-DTE:: " + new Gson().toJson(json_dte));

                // GENERAR TOKEN MINISTERIO DE HACIENDA.
                Cliente_Rest_MH cliente_rest_mh = new Cliente_Rest_MH();
                String token_autenticacion = cliente_rest_mh.autenticar(dte_invalidacion_v3.getEmisor().getNit(), "UNOSV2021*");
                Type listType1 = new TypeToken<TokenMH>() {
                }.getType();
                TokenMH token_mh = new Gson().fromJson(token_autenticacion, listType1);
                driver.guardar_en_archivo(no_dtes.get(d), "anulardte", "AUTH-TOKEN-MH:: " + new Gson().toJson(token_mh));

                // RESPUESTA DEL MINISTERIO DE HACIENDA.
                String respuesta_mh = cliente_rest_mh.recepciondte(token_mh.getBody().getToken(), new Gson().toJson(json_dte));
                Type listType2 = new TypeToken<RESPUESTA_RECEPCIONDTE_MH>() {
                }.getType();
                RESPUESTA_RECEPCIONDTE_MH respuesta_recepciondte_mh = new Gson().fromJson(respuesta_mh, listType2);
                ctrl_dte_invalidacion_v3.registro_db_respuesta_mh(ambiente, respuesta_recepciondte_mh, no_dtes.get(d));
                driver.guardar_en_archivo(no_dtes.get(d), "anulardte", "RESPUESTA-DTE-MH:: " + new Gson().toJson(respuesta_recepciondte_mh));
            }

            resultado = "ID-DTE PROCESADOS: " + no_dtes.toString();
        } catch (Exception ex) {
            System.out.println("PROYECTO:api-grupoterra-svfel-v3|CLASE:" + this.getClass().getName() + "|METODO:anulardte_v3()|ERROR:" + ex.toString());
        }

        return resultado;
    }
    
}
