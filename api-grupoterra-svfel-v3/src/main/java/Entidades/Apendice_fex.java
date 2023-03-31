package Entidades;

import java.io.Serializable;

public class Apendice_fex implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String campo;
    private String etiqueta;
    private String valor;

    public Apendice_fex(String campo, String etiqueta, String valor) {
        this.campo = campo;
        this.etiqueta = etiqueta;
        this.valor = valor;
    }

    public Apendice_fex() {
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Apendice_f{" + "campo=" + campo + ", etiqueta=" + etiqueta + ", valor=" + valor + '}';
    }
    
}
