package Entidades;

import java.io.Serializable;

public class Resumen_cr implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number totalSujetoRetencion;
    private Number totalIVAretenido;
    private String totalIVAretenidoLetras;

    public Resumen_cr(Number totalSujetoRetencion, Number totalIVAretenido, String totalIVAretenidoLetras) {
        this.totalSujetoRetencion = totalSujetoRetencion;
        this.totalIVAretenido = totalIVAretenido;
        this.totalIVAretenidoLetras = totalIVAretenidoLetras;
    }

    public Resumen_cr() {
    }

    public Number getTotalSujetoRetencion() {
        return totalSujetoRetencion;
    }

    public void setTotalSujetoRetencion(Number totalSujetoRetencion) {
        this.totalSujetoRetencion = totalSujetoRetencion;
    }

    public Number getTotalIVAretenido() {
        return totalIVAretenido;
    }

    public void setTotalIVAretenido(Number totalIVAretenido) {
        this.totalIVAretenido = totalIVAretenido;
    }

    public String getTotalIVAretenidoLetras() {
        return totalIVAretenidoLetras;
    }

    public void setTotalIVAretenidoLetras(String totalIVAretenidoLetras) {
        this.totalIVAretenidoLetras = totalIVAretenidoLetras;
    }

    @Override
    public String toString() {
        return "Resumen_cr{" + "totalSujetoRetencion=" + totalSujetoRetencion + ", totalIVAretenido=" + totalIVAretenido + ", totalIVAretenidoLetras=" + totalIVAretenidoLetras + '}';
    }
    
}
