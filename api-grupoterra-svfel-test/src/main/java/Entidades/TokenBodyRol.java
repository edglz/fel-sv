package Entidades;

import java.io.Serializable;

public class TokenBodyRol  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String codigo;
    private String descripcion;
    private String rolSuperior;
    private String nivel;
    private String activo;
    private String permisos;

    public TokenBodyRol(String nombre, String codigo, String descripcion, String rolSuperior, String nivel, String activo, String permisos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.rolSuperior = rolSuperior;
        this.nivel = nivel;
        this.activo = activo;
        this.permisos = permisos;
    }

    public TokenBodyRol() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRolSuperior() {
        return rolSuperior;
    }

    public void setRolSuperior(String rolSuperior) {
        this.rolSuperior = rolSuperior;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "TokenBodyRol{" + "nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", rolSuperior=" + rolSuperior + ", nivel=" + nivel + ", activo=" + activo + ", permisos=" + permisos + '}';
    }
    
}
