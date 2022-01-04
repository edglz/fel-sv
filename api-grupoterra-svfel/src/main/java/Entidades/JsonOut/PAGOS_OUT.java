package Entidades.JsonOut;

import java.io.Serializable;

public class PAGOS_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String descripcion;
    private String referencia;
    private String plazo;
    private Number periodo;

    public PAGOS_OUT(String codigo, String descripcion, String referencia, String plazo, Number periodo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.plazo = plazo;
        this.periodo = periodo;
    }

    public PAGOS_OUT() {
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public Number getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Number periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "PAGOS_OUT{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", referencia=" + referencia + ", plazo=" + plazo + ", periodo=" + periodo + '}';
    }
    
}
