package Entidades;

import java.io.Serializable;

public class CuerpoDocumento_cr implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number numItem;
    private String tipoDte;
    private Number tipoDoc;
    private String numDocumento;
    private String fechaEmision;
    private Number montoSujetoGrav;
    private String codigoRetencionMH;
    private Number ivaRetenido;
    private String descripcion;

    public CuerpoDocumento_cr(Number numItem, String tipoDte, Number tipoDoc, String numDocumento, String fechaEmision, Number montoSujetoGrav, String codigoRetencionMH, Number ivaRetenido, String descripcion) {
        this.numItem = numItem;
        this.tipoDte = tipoDte;
        this.tipoDoc = tipoDoc;
        this.numDocumento = numDocumento;
        this.fechaEmision = fechaEmision;
        this.montoSujetoGrav = montoSujetoGrav;
        this.codigoRetencionMH = codigoRetencionMH;
        this.ivaRetenido = ivaRetenido;
        this.descripcion = descripcion;
    }

    public CuerpoDocumento_cr() {
    }

    public Number getNumItem() {
        return numItem;
    }

    public void setNumItem(Number numItem) {
        this.numItem = numItem;
    }

    public String getTipoDte() {
        return tipoDte;
    }

    public void setTipoDte(String tipoDte) {
        this.tipoDte = tipoDte;
    }

    public Number getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Number tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Number getMontoSujetoGrav() {
        return montoSujetoGrav;
    }

    public void setMontoSujetoGrav(Number montoSujetoGrav) {
        this.montoSujetoGrav = montoSujetoGrav;
    }

    public String getCodigoRetencionMH() {
        return codigoRetencionMH;
    }

    public void setCodigoRetencionMH(String codigoRetencionMH) {
        this.codigoRetencionMH = codigoRetencionMH;
    }

    public Number getIvaRetenido() {
        return ivaRetenido;
    }

    public void setIvaRetenido(Number ivaRetenido) {
        this.ivaRetenido = ivaRetenido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CuerpoDocumento_cr{" + "numItem=" + numItem + ", tipoDte=" + tipoDte + ", tipoDoc=" + tipoDoc + ", numDocumento=" + numDocumento + ", fechaEmision=" + fechaEmision + ", montoSujetoGrav=" + montoSujetoGrav + ", codigoRetencionMH=" + codigoRetencionMH + ", ivaRetenido=" + ivaRetenido + ", descripcion=" + descripcion + '}';
    }
    
}
