package Entidades.JsonOut;

import java.io.Serializable;

public class RECEPTOR_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nit;
    private String nrc;
    private String numFacturador;
    private String nombre;
    private ACTIVIDAD_ECONOMICA_OUT actividad;
    private String nombreComercial;
    private DIRECCION_OUT direccion;
    private Integer categoria;
    private String telefono;
    private String correo;
    private String fecSujExcl;

    public RECEPTOR_OUT(String nit, String nrc, String numFacturador, String nombre, ACTIVIDAD_ECONOMICA_OUT actividad, String nombreComercial, DIRECCION_OUT direccion, Integer categoria, String telefono, String correo, String fecSujExcl) {
        this.nit = nit;
        this.nrc = nrc;
        this.numFacturador = numFacturador;
        this.nombre = nombre;
        this.actividad = actividad;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.categoria = categoria;
        this.telefono = telefono;
        this.correo = correo;
        this.fecSujExcl = fecSujExcl;
    }

    public RECEPTOR_OUT() {
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

    public ACTIVIDAD_ECONOMICA_OUT getActividad() {
        return actividad;
    }

    public void setActividad(ACTIVIDAD_ECONOMICA_OUT actividad) {
        this.actividad = actividad;
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

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
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

    public String getFecSujExcl() {
        return fecSujExcl;
    }

    public void setFecSujExcl(String fecSujExcl) {
        this.fecSujExcl = fecSujExcl;
    }

    @Override
    public String toString() {
        return "RECEPTOR_OUT{" + "nit=" + nit + ", nrc=" + nrc + ", numFacturador=" + numFacturador + ", nombre=" + nombre + ", actividad=" + actividad + ", nombreComercial=" + nombreComercial + ", direccion=" + direccion + ", categoria=" + categoria + ", telefono=" + telefono + ", correo=" + correo + ", fecSujExcl=" + fecSujExcl + '}';
    }
    
}
