package Entidades;

import java.io.Serializable;

public class JsonDTE implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer version;
    private String ambiente;
    private String tipoDte;
    private Number idEnvio;
    private String documento;

    public JsonDTE(Integer version, String ambiente, String tipoDte, Number idEnvio, String documento) {
        this.version = version;
        this.ambiente = ambiente;
        this.tipoDte = tipoDte;
        this.idEnvio = idEnvio;
        this.documento = documento;
    }

    public JsonDTE() {
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

    public Number getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Number idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "JsonDTE{" + "version=" + version + ", ambiente=" + ambiente + ", tipoDte=" + tipoDte + ", idEnvio=" + idEnvio + ", documento=" + documento + '}';
    }

}
