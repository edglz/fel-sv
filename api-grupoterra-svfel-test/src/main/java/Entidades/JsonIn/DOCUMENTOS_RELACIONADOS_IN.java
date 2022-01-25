package Entidades.JsonIn;

import java.io.Serializable;

public class DOCUMENTOS_RELACIONADOS_IN implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String tipoDte;
    private Integer tipoGeneracion;
    private String codigoGeneracion;
    private String numeroCorrelativo;
    private String fechaEmision;

    public DOCUMENTOS_RELACIONADOS_IN(String tipoDte, Integer tipoGeneracion, String codigoGeneracion, String numeroCorrelativo, String fechaEmision) {
        this.tipoDte = tipoDte;
        this.tipoGeneracion = tipoGeneracion;
        this.codigoGeneracion = codigoGeneracion;
        this.numeroCorrelativo = numeroCorrelativo;
        this.fechaEmision = fechaEmision;
    }

    public DOCUMENTOS_RELACIONADOS_IN() {
    }

    public String getTipoDte() {
        return tipoDte;
    }

    public void setTipoDte(String tipoDte) {
        this.tipoDte = tipoDte;
    }

    public Integer getTipoGeneracion() {
        return tipoGeneracion;
    }

    public void setTipoGeneracion(Integer tipoGeneracion) {
        this.tipoGeneracion = tipoGeneracion;
    }

    public String getCodigoGeneracion() {
        return codigoGeneracion;
    }

    public void setCodigoGeneracion(String codigoGeneracion) {
        this.codigoGeneracion = codigoGeneracion;
    }

    public String getNumeroCorrelativo() {
        return numeroCorrelativo;
    }

    public void setNumeroCorrelativo(String numeroCorrelativo) {
        this.numeroCorrelativo = numeroCorrelativo;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "DOCUMENTOS_RELACIONADOS_IN{" + "tipoDte=" + tipoDte + ", tipoGeneracion=" + tipoGeneracion + ", codigoGeneracion=" + codigoGeneracion + ", numeroCorrelativo=" + numeroCorrelativo + ", fechaEmision=" + fechaEmision + '}';
    }
    
}
