package Controles;

import ClienteServicio.Cliente_Rest_Firma;
import Entidades.JsonOut.DTE_OUT;
import Entidades.JsonOut.DTE_OUT_NC;
import Entidades.Json_Firmado;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;

public class Control_JSON_FIRMADO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_JSON_FIRMADO() {
    }

    public Json_Firmado firmardocumento(String emisor_nit, DTE_OUT json) {
        Json_Firmado resultado = null;

        try {
            Gson gson = new GsonBuilder().serializeNulls().create();
            String json_sin_firmar = "{"
                    + "\"nit\":\"" + emisor_nit + "\","
                    + "\"activo\":true,"
                    + "\"passwordPri\":\"UNOSV2021*\","
                    + "\"dteJson\":" + gson.toJson(json)
                    + "}";
            
            Cliente_Rest_Firma cliente_rest = new Cliente_Rest_Firma();
            String json_firmado = cliente_rest.firmardocumento(json_sin_firmar);
            
            Type listType = new TypeToken<Json_Firmado>() {
            }.getType();
            resultado = new Gson().fromJson(json_firmado, listType);
        } catch (Exception ex) {
            resultado = null;
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: firmardocumento | Error: " + ex.toString());
        }

        return resultado;
    }
    
    public Json_Firmado firmardocumento_nc(String emisor_nit, DTE_OUT_NC json) {
        Json_Firmado resultado = null;

        try {
            Gson gson = new GsonBuilder().serializeNulls().create();
            String json_sin_firmar = "{"
                    + "\"nit\":\"" + emisor_nit + "\","
                    + "\"activo\":true,"
                    + "\"passwordPri\":\"UNOSV2021*\","
                    + "\"dteJson\":" + gson.toJson(json)
                    + "}";
            
            Cliente_Rest_Firma cliente_rest = new Cliente_Rest_Firma();
            String json_firmado = cliente_rest.firmardocumento(json_sin_firmar);
            
            Type listType = new TypeToken<Json_Firmado>() {
            }.getType();
            resultado = new Gson().fromJson(json_firmado, listType);
        } catch (Exception ex) {
            resultado = null;
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: firmardocumento | Error: " + ex.toString());
        }

        return resultado;
    }

}
