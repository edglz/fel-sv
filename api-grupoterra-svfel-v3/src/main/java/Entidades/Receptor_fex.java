package Entidades;

import java.io.Serializable;

public class Receptor_fex implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String tipoDocumento;
    private String numDocumento;
    private String nombreComercial;
    private String codPais;
    private String nombrePais;
    private String complemento;
    private Number tipoPersona;
    private String descActividad;
    private String telefono;
    private String correo;

    public Receptor_fex(String nombre, String tipoDocumento, String numDocumento, String nombreComercial, String codPais, String nombrePais, String complemento, Number tipoPersona, String descActividad, String telefono, String correo) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombreComercial = nombreComercial;
        this.codPais = codPais;
        this.nombrePais = nombrePais;
        this.complemento = complemento;
        this.tipoPersona = tipoPersona;
        this.descActividad = descActividad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Receptor_fex() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Number getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Number tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
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
        return "Receptor_fex{" + "nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", nombreComercial=" + nombreComercial + ", codPais=" + codPais + ", nombrePais=" + nombrePais + ", complemento=" + complemento + ", tipoPersona=" + tipoPersona + ", descActividad=" + descActividad + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
}
