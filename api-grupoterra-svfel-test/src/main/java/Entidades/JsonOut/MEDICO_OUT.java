package Entidades.JsonOut;

import java.io.Serializable;

public class MEDICO_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String nit;
    private String docIdenificacion;
    private Integer tipoServicio;

    public MEDICO_OUT(String nombre, String nit, String docIdenificacion, Integer tipoServicio) {
        this.nombre = nombre;
        this.nit = nit;
        this.docIdenificacion = docIdenificacion;
        this.tipoServicio = tipoServicio;
    }

    public MEDICO_OUT() {
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

    public String getDocIdenificacion() {
        return docIdenificacion;
    }

    public void setDocIdenificacion(String docIdenificacion) {
        this.docIdenificacion = docIdenificacion;
    }

    public Integer getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Integer tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "MEDICO_OUT{" + "nombre=" + nombre + ", nit=" + nit + ", docIdenificacion=" + docIdenificacion + ", tipoServicio=" + tipoServicio + '}';
    }
    
}
