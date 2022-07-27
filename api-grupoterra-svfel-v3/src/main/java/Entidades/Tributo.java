package Entidades;

import java.io.Serializable;

public class Tributo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String descripcion;
    private Number valor;

    public Tributo(String codigo, String descripcion, Number valor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Tributo() {
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

    public Number getValor() {
        return valor;
    }

    public void setValor(Number valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Tributo_ccf{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", valor=" + valor + '}';
    }
    
}
