package Entidades;

import java.io.Serializable;

public class Emisor_nc implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nit;
    private String nrc;
    private String nombre;
    private String codActividad;
    private String descActividad;
    private String nombreComercial;
    private String tipoEstablecimiento;
    private Direccion direccion;
    private String telefono;
    private String correo;

    public Emisor_nc(String nit, String nrc, String nombre, String codActividad, String descActividad, String nombreComercial, String tipoEstablecimiento, Direccion direccion, String telefono, String correo) {
        this.nit = nit;
        this.nrc = nrc;
        this.nombre = nombre;
        this.codActividad = codActividad;
        this.descActividad = descActividad;
        this.nombreComercial = nombreComercial;
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Emisor_nc() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
        return "Emisor_nc{" + "nit=" + nit + ", nrc=" + nrc + ", nombre=" + nombre + ", codActividad=" + codActividad + ", descActividad=" + descActividad + ", nombreComercial=" + nombreComercial + ", tipoEstablecimiento=" + tipoEstablecimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
}
