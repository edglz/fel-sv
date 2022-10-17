package Entidades;

import java.io.Serializable;

public class DocumentoRelacionado_nd implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String tipoDocumento;
    private Number tipoGeneracion;
    private String numeroDocumento;
    private String fechaEmision;

    public DocumentoRelacionado_nd(String tipoDocumento, Number tipoGeneracion, String numeroDocumento, String fechaEmision) {
        this.tipoDocumento = tipoDocumento;
        this.tipoGeneracion = tipoGeneracion;
        this.numeroDocumento = numeroDocumento;
        this.fechaEmision = fechaEmision;
    }

    public DocumentoRelacionado_nd() {
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Number getTipoGeneracion() {
        return tipoGeneracion;
    }

    public void setTipoGeneracion(Number tipoGeneracion) {
        this.tipoGeneracion = tipoGeneracion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "DocumentoRelacionado_ccf{" + "tipoDocumento=" + tipoDocumento + ", tipoGeneracion=" + tipoGeneracion + ", numeroDocumento=" + numeroDocumento + ", fechaEmision=" + fechaEmision + '}';
    }
    
}
