package Entidades;

import java.io.Serializable;

public class Identificacion_invalidacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Number version;
    private String ambiente;
    private String codigoGeneracion;
    private String fecAnula;
    private String horAnula;

    public Identificacion_invalidacion(Number version, String ambiente, String codigoGeneracion, String fecAnula, String horAnula) {
        this.version = version;
        this.ambiente = ambiente;
        this.codigoGeneracion = codigoGeneracion;
        this.fecAnula = fecAnula;
        this.horAnula = horAnula;
    }

    public Identificacion_invalidacion() {
    }

    public Number getVersion() {
        return version;
    }

    public void setVersion(Number version) {
        this.version = version;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getCodigoGeneracion() {
        return codigoGeneracion;
    }

    public void setCodigoGeneracion(String codigoGeneracion) {
        this.codigoGeneracion = codigoGeneracion;
    }

    public String getFecAnula() {
        return fecAnula;
    }

    public void setFecAnula(String fecAnula) {
        this.fecAnula = fecAnula;
    }

    public String getHorAnula() {
        return horAnula;
    }

    public void setHorAnula(String horAnula) {
        this.horAnula = horAnula;
    }

    @Override
    public String toString() {
        return "Identificacion_invalidacion{" + "version=" + version + ", ambiente=" + ambiente + ", codigoGeneracion=" + codigoGeneracion + ", fecAnula=" + fecAnula + ", horAnula=" + horAnula + '}';
    }
    
}
