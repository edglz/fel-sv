package Entidades;

import java.io.Serializable;
import java.util.List;

public class RESPUESTA_RECEPCIONDTE_MH implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Number version;
    private String ambiente;
    private Number versionApp;
    private String estado;
    private String codigoGeneracion;
    private String selloRecibido;
    private String fhProcesamiento;
    private String clasificaMsg;
    private String codigoMsg;
    private String descripcionMsg;
    private List<String> observaciones;

    public RESPUESTA_RECEPCIONDTE_MH(Number version, String ambiente, Number versionApp, String estado, String codigoGeneracion, String selloRecibido, String fhProcesamiento, String clasificaMsg, String codigoMsg, String descripcionMsg, List<String> observaciones) {
        this.version = version;
        this.ambiente = ambiente;
        this.versionApp = versionApp;
        this.estado = estado;
        this.codigoGeneracion = codigoGeneracion;
        this.selloRecibido = selloRecibido;
        this.fhProcesamiento = fhProcesamiento;
        this.clasificaMsg = clasificaMsg;
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

    public String getSelloRecibido() {
        return selloRecibido;
    }

    public void setSelloRecibido(String selloRecibido) {
        this.selloRecibido = selloRecibido;
    }

    public String getFhProcesamiento() {
        return fhProcesamiento;
    }

    public void setFhProcesamiento(String fhProcesamiento) {
        this.fhProcesamiento = fhProcesamiento;
    }

    public String getClasificaMsg() {
        return clasificaMsg;
    }

    public void setClasificaMsg(String clasificaMsg) {
        this.clasificaMsg = clasificaMsg;
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
        return "RESPUESTA_RECEPCIONDTE_MH{" + "version=" + version + ", ambiente=" + ambiente + ", versionApp=" + versionApp + ", estado=" + estado + ", codigoGeneracion=" + codigoGeneracion + ", selloRecibido=" + selloRecibido + ", fhProcesamiento=" + fhProcesamiento + ", clasificaMsg=" + clasificaMsg + ", codigoMsg=" + codigoMsg + ", descripcionMsg=" + descripcionMsg + ", observaciones=" + observaciones + '}';
    }
    
}
