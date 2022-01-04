package Entidades.JsonOut;

import java.io.Serializable;
import java.util.List;

public class RESPUESTA_RECEPCIONDTE_MH implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Number version;
    private String ambiente;
    private Number versionApp;
    private String estado;
    private String codigoGeneracion;
    private String numValidacion;
    private String fhProcesamiento;
    private String codigoMsg; 
    private String descripcionMsg;
    private List<String> observaciones;

    public RESPUESTA_RECEPCIONDTE_MH(Number version, String ambiente, Number versionApp, String estado, String codigoGeneracion, String numValidacion, String fhProcesamiento, String codigoMsg, String descripcionMsg, List<String> observaciones) {
        this.version = version;
        this.ambiente = ambiente;
        this.versionApp = versionApp;
        this.estado = estado;
        this.codigoGeneracion = codigoGeneracion;
        this.numValidacion = numValidacion;
        this.fhProcesamiento = fhProcesamiento;
        this.codigoMsg = codigoMsg;
        this.descripcionMsg = descripcionMsg;
        this.observaciones = observaciones;
    }

    public RESPUESTA_RECEPCIONDTE_MH() {
    }

    public Number getVersion() {
        return version;
    }

    public void setVersion(Number version) {
        this.version = version;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Number getVersionApp() {
        return versionApp;
    }

    public void setVersionApp(Number versionApp) {
        this.versionApp = versionApp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoGeneracion() {
        return codigoGeneracion;
    }

    public void setCodigoGeneracion(String codigoGeneracion) {
        this.codigoGeneracion = codigoGeneracion;
    }

    public String getNumValidacion() {
        return numValidacion;
    }

    public void setNumValidacion(String numValidacion) {
        this.numValidacion = numValidacion;
    }

    public String getFhProcesamiento() {
        return fhProcesamiento;
    }

    public void setFhProcesamiento(String fhProcesamiento) {
        this.fhProcesamiento = fhProcesamiento;
    }

    public String getCodigoMsg() {
        return codigoMsg;
    }

    public void setCodigoMsg(String codigoMsg) {
        this.codigoMsg = codigoMsg;
    }

    public String getDescripcionMsg() {
        return descripcionMsg;
    }

    public void setDescripcionMsg(String descripcionMsg) {
        this.descripcionMsg = descripcionMsg;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "RESPUESTA_RECEPCIONDTE_MH{" + "version=" + version + ", ambiente=" + ambiente + ", versionApp=" + versionApp + ", estado=" + estado + ", codigoGeneracion=" + codigoGeneracion + ", numValidacion=" + numValidacion + ", fhProcesamiento=" + fhProcesamiento + ", codigoMsg=" + codigoMsg + ", descripcionMsg=" + descripcionMsg + ", observaciones=" + observaciones + '}';
    }
    
}
