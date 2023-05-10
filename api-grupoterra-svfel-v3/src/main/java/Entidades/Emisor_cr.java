package Entidades;

import java.io.Serializable;

public class Emisor_cr implements Serializable {
    
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
    private String codigoMH;
    private String codigo;
    private String puntoVentaMH;
    private String puntoVenta;
    private String correo;

    public Emisor_cr(String nit, String nrc, String nombre, String codActividad, String descActividad, String nombreComercial, String tipoEstablecimiento, Direccion direccion, String telefono, String codigoMH, String codigo, String puntoVentaMH, String puntoVenta, String correo) {
        this.nit = nit;
        this.nrc = nrc;
        this.nombre = nombre;
        this.codActividad = codActividad;
        this.descActividad = descActividad;
        this.nombreComercial = nombreComercial;
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigoMH = codigoMH;
        this.codigo = codigo;
        this.puntoVentaMH = puntoVentaMH;
        this.puntoVenta = puntoVenta;
        this.correo = correo;
    }

    public Emisor_cr() {
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

    public String getCodigoMH() {
        return codigoMH;
    }

    public void setCodigoMH(String codigoMH) {
        this.codigoMH = codigoMH;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPuntoVentaMH() {
        return puntoVentaMH;
    }

    public void setPuntoVentaMH(String puntoVentaMH) {
        this.puntoVentaMH = puntoVentaMH;
    }

    public String getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(String puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Emisor_cr{" + "nit=" + nit + ", nrc=" + nrc + ", nombre=" + nombre + ", codActividad=" + codActividad + ", descActividad=" + descActividad + ", nombreComercial=" + nombreComercial + ", tipoEstablecimiento=" + tipoEstablecimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", codigoMH=" + codigoMH + ", codigo=" + codigo + ", puntoVentaMH=" + puntoVentaMH + ", puntoVenta=" + puntoVenta + ", correo=" + correo + '}';
    }
    
}
