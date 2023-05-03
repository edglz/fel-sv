package Entidades;

import java.io.Serializable;

public class Documento_invalidacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tipoDte;
    private String codigoGeneracion;
    private String selloRecibido;
    private String numeroControl;
    private String fecEmi;
    private Number montoIva;
    private String codigoGeneracionR;
    private String tipoDocumento;
    private String numDocumento;
    private String nombre;
    private String telefono;
    private String correo;

    public Documento_invalidacion(String tipoDte, String codigoGeneracion, String selloRecibido, String numeroControl, String fecEmi, Number montoIva, String codigoGeneracionR, String tipoDocumento, String numDocumento, String nombre, String telefono, String correo) {
        this.tipoDte = tipoDte;
        this.codigoGeneracion = codigoGeneracion;
        this.selloRecibido = selloRecibido;
        this.numeroControl = numeroControl;
        this.fecEmi = fecEmi;
        this.montoIva = montoIva;
        this.codigoGeneracionR = codigoGeneracionR;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Documento_invalidacion() {
    }

    public String getTipoDte() {
        return tipoDte;
    }

    public void setTipoDte(String tipoDte) {
        this.tipoDte = tipoDte;
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

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getFecEmi() {
        return fecEmi;
    }

    public void setFecEmi(String fecEmi) {
        this.fecEmi = fecEmi;
    }

    public Number getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(Number montoIva) {
        this.montoIva = montoIva;
    }

    public String getCodigoGeneracionR() {
        return codigoGeneracionR;
    }

    public void setCodigoGeneracionR(String codigoGeneracionR) {
        this.codigoGeneracionR = codigoGeneracionR;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Documento_invalidacion{" + "tipoDte=" + tipoDte + ", codigoGeneracion=" + codigoGeneracion + ", selloRecibido=" + selloRecibido + ", numeroControl=" + numeroControl + ", fecEmi=" + fecEmi + ", montoIva=" + montoIva + ", codigoGeneracionR=" + codigoGeneracionR + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
}
