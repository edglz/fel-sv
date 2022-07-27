package Entidades;

import java.io.Serializable;

public class Pagos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private Number montoPago;
    private String referencia;
    private String plazo;
    private Number periodo;

    public Pagos(String codigo, Number montoPago, String referencia, String plazo, Number periodo) {
        this.codigo = codigo;
        this.montoPago = montoPago;
        this.referencia = referencia;
        this.plazo = plazo;
        this.periodo = periodo;
    }

    public Pagos() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Number getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Number montoPago) {
        this.montoPago = montoPago;
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
        return "Pagos_ccf{" + "codigo=" + codigo + ", montoPago=" + montoPago + ", referencia=" + referencia + ", plazo=" + plazo + ", periodo=" + periodo + '}';
    }
    
}
