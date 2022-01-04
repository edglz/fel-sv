package Entidades.JsonIn;

import java.io.Serializable;

public class RECEPTOR_IN implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nit;
    private Integer tipoDocumento;
    private String numDocumento;
    private String nrc;
    private String numFacturador;
    private String nombre;
    private String codActividad;
    private String nombreComercial;
    private String departamento;
    private String municipio;
    private String complemento;
    private Integer categoria;
    private String telefono;
    private String correo;
    private String fecSujExcl;
    private String numExencion;
    private String bienTitulo;

    public RECEPTOR_IN(String nit, Integer tipoDocumento, String numDocumento, String nrc, String numFacturador, String nombre, String codActividad, String nombreComercial, String departamento, String municipio, String complemento, Integer categoria, String telefono, String correo, String fecSujExcl, String numExencion, String bienTitulo) {
        this.nit = nit;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nrc = nrc;
        this.numFacturador = numFacturador;
        this.nombre = nombre;
        this.codActividad = codActividad;
        this.nombreComercial = nombreComercial;
        this.departamento = departamento;
        this.municipio = municipio;
        this.complemento = complemento;
        this.categoria = categoria;
        this.telefono = telefono;
        this.correo = correo;
        this.fecSujExcl = fecSujExcl;
        this.numExencion = numExencion;
        this.bienTitulo = bienTitulo;
    }

    public RECEPTOR_IN() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
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

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getNumExencion() {
        return numExencion;
    }

    public void setNumExencion(String numExencion) {
        this.numExencion = numExencion;
    }

    public String getBienTitulo() {
        return bienTitulo;
    }

    public void setBienTitulo(String bienTitulo) {
        this.bienTitulo = bienTitulo;
    }

    @Override
    public String toString() {
        return "RECEPTOR_IN{" + "nit=" + nit + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", nrc=" + nrc + ", numFacturador=" + numFacturador + ", nombre=" + nombre + ", codActividad=" + codActividad + ", nombreComercial=" + nombreComercial + ", departamento=" + departamento + ", municipio=" + municipio + ", complemento=" + complemento + ", categoria=" + categoria + ", telefono=" + telefono + ", correo=" + correo + ", fecSujExcl=" + fecSujExcl + ", numExencion=" + numExencion + ", bienTitulo=" + bienTitulo + '}';
    }
    
}
