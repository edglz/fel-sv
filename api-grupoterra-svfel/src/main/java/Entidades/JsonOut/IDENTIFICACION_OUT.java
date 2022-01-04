package Entidades.JsonOut;

import java.io.Serializable;

public class IDENTIFICACION_OUT implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer version;
    private String ambiente;
    private String tipoDte;
    private String numeroControl;
    private String codigoGeneracion;
    private Integer tipoModelo;
    private Integer tipoOperacion;
    private Integer tipoContingencia;
    private String motivoContin;
    private String fecEmi;
    private String horEmi;
    private String tipoMoneda;

    public IDENTIFICACION_OUT(Integer version, String ambiente, String tipoDte, String numeroControl, String codigoGeneracion, Integer tipoModelo, Integer tipoOperacion, Integer tipoContingencia, String motivoContin, String fecEmi, String horEmi, String tipoMoneda) {
        this.version = version;
        this.ambiente = ambiente;
        this.tipoDte = tipoDte;
        this.numeroControl = numeroControl;
        this.codigoGeneracion = codigoGeneracion;
        this.tipoModelo = tipoModelo;
        this.tipoOperacion = tipoOperacion;
        this.tipoContingencia = tipoContingencia;
        this.motivoContin = motivoContin;
        this.fecEmi = fecEmi;
        this.horEmi = horEmi;
        this.tipoMoneda = tipoMoneda;
    }

    public IDENTIFICACION_OUT() {
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getTipoDte() {
        return tipoDte;
    }

    public void setTipoDte(String tipoDte) {
        this.tipoDte = tipoDte;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getCodigoGeneracion() {
        return codigoGeneracion;
    }

    public void setCodigoGeneracion(String codigoGeneracion) {
        this.codigoGeneracion = codigoGeneracion;
    }

    public Integer getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(Integer tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    public Integer getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Integer tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Integer getTipoContingencia() {
        return tipoContingencia;
    }

    public void setTipoContingencia(Integer tipoContingencia) {
        this.tipoContingencia = tipoContingencia;
    }

    public String getMotivoContin() {
        return motivoContin;
    }

    public void setMotivoContin(String motivoContin) {
        this.motivoContin = motivoContin;
    }

    public String getFecEmi() {
        return fecEmi;
    }

    public void setFecEmi(String fecEmi) {
        this.fecEmi = fecEmi;
    }

    public String getHorEmi() {
        return horEmi;
    }

    public void setHorEmi(String horEmi) {
        this.horEmi = horEmi;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    @Override
    public String toString() {
        return "Identificacion{" + "version=" + version + ", ambiente=" + ambiente + ", tipoDte=" + tipoDte + ", numeroControl=" + numeroControl + ", codigoGeneracion=" + codigoGeneracion + ", tipoModelo=" + tipoModelo + ", tipoOperacion=" + tipoOperacion + ", tipoContingencia=" + tipoContingencia + ", motivoContin=" + motivoContin + ", fecEmi=" + fecEmi + ", horEmi=" + horEmi + ", tipoMoneda=" + tipoMoneda + '}';
    }
    
}
