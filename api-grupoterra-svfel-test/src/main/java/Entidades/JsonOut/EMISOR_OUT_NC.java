package Entidades.JsonOut;

import java.io.Serializable;

public class EMISOR_OUT_NC implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nit;
    private String nrc;
    private String numFacturador;
    private String nombre;
    private ACTIVIDAD_ECONOMICA_OUT actividad1;
    private ACTIVIDAD_ECONOMICA_OUT actividad2;
    private String nombreComercial;
    private DIRECCION_OUT direccion;
    private String telefono;
    private String correo;
    private Integer categoria;
    private Integer tipoEstablecimiento;
    private SUCURSAL_OUT sucursal;
    private String fecSujExcl;

    public EMISOR_OUT_NC(String nit, String nrc, String numFacturador, String nombre, ACTIVIDAD_ECONOMICA_OUT actividad1, ACTIVIDAD_ECONOMICA_OUT actividad2, String nombreComercial, DIRECCION_OUT direccion, String telefono, String correo, Integer categoria, Integer tipoEstablecimiento, SUCURSAL_OUT sucursal, String fecSujExcl) {
        this.nit = nit;
        this.nrc = nrc;
        this.numFacturador = numFacturador;
        this.nombre = nombre;
        this.actividad1 = actividad1;
        this.actividad2 = actividad2;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.categoria = categoria;
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.sucursal = sucursal;
        this.fecSujExcl = fecSujExcl;
    }

    public EMISOR_OUT_NC() {
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

    public String getNumFacturador() {
        return numFacturador;
    }

    public void setNumFacturador(String numFacturador) {
        this.numFacturador = numFacturador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ACTIVIDAD_ECONOMICA_OUT getActividad1() {
        return actividad1;
    }

    public void setActividad1(ACTIVIDAD_ECONOMICA_OUT actividad1) {
        this.actividad1 = actividad1;
    }

    public ACTIVIDAD_ECONOMICA_OUT getActividad2() {
        return actividad2;
    }

    public void setActividad2(ACTIVIDAD_ECONOMICA_OUT actividad2) {
        this.actividad2 = actividad2;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public DIRECCION_OUT getDireccion() {
        return direccion;
    }

    public void setDireccion(DIRECCION_OUT direccion) {
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

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(Integer tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public SUCURSAL_OUT getSucursal() {
        return sucursal;
    }

    public void setSucursal(SUCURSAL_OUT sucursal) {
        this.sucursal = sucursal;
    }

    public String getFecSujExcl() {
        return fecSujExcl;
    }

    public void setFecSujExcl(String fecSujExcl) {
        this.fecSujExcl = fecSujExcl;
    }

    @Override
    public String toString() {
        return "EMISOR_OUT_NC{" + "nit=" + nit + ", nrc=" + nrc + ", numFacturador=" + numFacturador + ", nombre=" + nombre + ", actividad1=" + actividad1 + ", actividad2=" + actividad2 + ", nombreComercial=" + nombreComercial + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", categoria=" + categoria + ", tipoEstablecimiento=" + tipoEstablecimiento + ", sucursal=" + sucursal + ", fecSujExcl=" + fecSujExcl + '}';
    }
    
}
