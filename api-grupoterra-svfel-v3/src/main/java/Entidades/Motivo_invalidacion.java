package Entidades;

import java.io.Serializable;

public class Motivo_invalidacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Number tipoAnulacion;
    private String motivoAnulacion;
    private String nombreResponsable;
    private String tipDocResponsable;
    private String numDocResponsable;
    private String nombreSolicita;
    private String tipDocSolicita;
    private String numDocSolicita;

    public Motivo_invalidacion(Number tipoAnulacion, String motivoAnulacion, String nombreResponsable, String tipDocResponsable, String numDocResponsable, String nombreSolicita, String tipDocSolicita, String numDocSolicita) {
        this.tipoAnulacion = tipoAnulacion;
        this.motivoAnulacion = motivoAnulacion;
        this.nombreResponsable = nombreResponsable;
        this.tipDocResponsable = tipDocResponsable;
        this.numDocResponsable = numDocResponsable;
        this.nombreSolicita = nombreSolicita;
        this.tipDocSolicita = tipDocSolicita;
        this.numDocSolicita = numDocSolicita;
    }

    public Motivo_invalidacion() {
    }

    public Number getTipoAnulacion() {
        return tipoAnulacion;
    }

    public void setTipoAnulacion(Number tipoAnulacion) {
        this.tipoAnulacion = tipoAnulacion;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getTipDocResponsable() {
        return tipDocResponsable;
    }

    public void setTipDocResponsable(String tipDocResponsable) {
        this.tipDocResponsable = tipDocResponsable;
    }

    public String getNumDocResponsable() {
        return numDocResponsable;
    }

    public void setNumDocResponsable(String numDocResponsable) {
        this.numDocResponsable = numDocResponsable;
    }

    public String getNombreSolicita() {
        return nombreSolicita;
    }

    public void setNombreSolicita(String nombreSolicita) {
        this.nombreSolicita = nombreSolicita;
    }

    public String getTipDocSolicita() {
        return tipDocSolicita;
    }

    public void setTipDocSolicita(String tipDocSolicita) {
        this.tipDocSolicita = tipDocSolicita;
    }

    public String getNumDocSolicita() {
        return numDocSolicita;
    }

    public void setNumDocSolicita(String numDocSolicita) {
        this.numDocSolicita = numDocSolicita;
    }

    @Override
    public String toString() {
        return "Motivo_invalidacion{" + "tipoAnulacion=" + tipoAnulacion + ", motivoAnulacion=" + motivoAnulacion + ", nombreResponsable=" + nombreResponsable + ", tipDocResponsable=" + tipDocResponsable + ", numDocResponsable=" + numDocResponsable + ", nombreSolicita=" + nombreSolicita + ", tipDocSolicita=" + tipDocSolicita + ", numDocSolicita=" + numDocSolicita + '}';
    }
    
}
