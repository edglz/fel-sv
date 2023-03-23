package Entidades;

import java.io.Serializable;

public class OtrosDocumentos_f implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer codDocAsociado;
    private String descDocumento;
    private String detalleDocumento;
    private String nombre;
    private String nit;
    private String docIdentificacion;
    private Number tipoServicio;

    public OtrosDocumentos_f(Integer codDocAsociado, String descDocumento, String detalleDocumento, String nombre, String nit, String docIdentificacion, Number tipoServicio) {
        this.codDocAsociado = codDocAsociado;
        this.descDocumento = descDocumento;
        this.detalleDocumento = detalleDocumento;
        this.nombre = nombre;
        this.nit = nit;
        this.docIdentificacion = docIdentificacion;
        this.tipoServicio = tipoServicio;
    }

    public OtrosDocumentos_f() {
    }

    public Integer getCodDocAsociado() {
        return codDocAsociado;
    }

    public void setCodDocAsociado(Integer codDocAsociado) {
        this.codDocAsociado = codDocAsociado;
    }

    public String getDescDocumento() {
        return descDocumento;
    }

    public void setDescDocumento(String descDocumento) {
        this.descDocumento = descDocumento;
    }

    public String getDetalleDocumento() {
        return detalleDocumento;
    }

    public void setDetalleDocumento(String detalleDocumento) {
        this.detalleDocumento = detalleDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDocIdentificacion() {
        return docIdentificacion;
    }

    public void setDocIdentificacion(String docIdentificacion) {
        this.docIdentificacion = docIdentificacion;
    }

    public Number getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Number tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "OtrosDocumentos_f{" + "codDocAsociado=" + codDocAsociado + ", descDocumento=" + descDocumento + ", detalleDocumento=" + detalleDocumento + ", nombre=" + nombre + ", nit=" + nit + ", docIdentificacion=" + docIdentificacion + ", tipoServicio=" + tipoServicio + '}';
    }
    
}
