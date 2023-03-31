package Entidades;

import java.io.Serializable;

public class Resumen_fex implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number totalGravada;
    private Number descuento;
    private Number porcentajeDescuento;
    private Number totalDescu;
    private Number seguro;
    private Number flete;
    private Number montoTotalOperacion;
    private Number totalNoGravado;
    private Number totalPagar;
    private String totalLetras;
    private Number condicionOperacion;
    private Pagos pagos;
    private String codIncoterms;
    private String descIncoterms;
    private String numPagoElectronico;
    private String observaciones;

    public Resumen_fex(Number totalGravada, Number descuento, Number porcentajeDescuento, Number totalDescu, Number seguro, Number flete, Number montoTotalOperacion, Number totalNoGravado, Number totalPagar, String totalLetras, Number condicionOperacion, Pagos pagos, String codIncoterms, String descIncoterms, String numPagoElectronico, String observaciones) {
        this.totalGravada = totalGravada;
        this.descuento = descuento;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalDescu = totalDescu;
        this.seguro = seguro;
        this.flete = flete;
        this.montoTotalOperacion = montoTotalOperacion;
        this.totalNoGravado = totalNoGravado;
        this.totalPagar = totalPagar;
        this.totalLetras = totalLetras;
        this.condicionOperacion = condicionOperacion;
        this.pagos = pagos;
        this.codIncoterms = codIncoterms;
        this.descIncoterms = descIncoterms;
        this.numPagoElectronico = numPagoElectronico;
        this.observaciones = observaciones;
    }

    public Resumen_fex() {
    }

    public Number getTotalGravada() {
        return totalGravada;
    }

    public void setTotalGravada(Number totalGravada) {
        this.totalGravada = totalGravada;
    }

    public Number getDescuento() {
        return descuento;
    }

    public void setDescuento(Number descuento) {
        this.descuento = descuento;
    }

    public Number getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Number porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Number getTotalDescu() {
        return totalDescu;
    }

    public void setTotalDescu(Number totalDescu) {
        this.totalDescu = totalDescu;
    }

    public Number getSeguro() {
        return seguro;
    }

    public void setSeguro(Number seguro) {
        this.seguro = seguro;
    }

    public Number getFlete() {
        return flete;
    }

    public void setFlete(Number flete) {
        this.flete = flete;
    }

    public Number getMontoTotalOperacion() {
        return montoTotalOperacion;
    }

    public void setMontoTotalOperacion(Number montoTotalOperacion) {
        this.montoTotalOperacion = montoTotalOperacion;
    }

    public Number getTotalNoGravado() {
        return totalNoGravado;
    }

    public void setTotalNoGravado(Number totalNoGravado) {
        this.totalNoGravado = totalNoGravado;
    }

    public Number getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Number totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getTotalLetras() {
        return totalLetras;
    }

    public void setTotalLetras(String totalLetras) {
        this.totalLetras = totalLetras;
    }

    public Number getCondicionOperacion() {
        return condicionOperacion;
    }

    public void setCondicionOperacion(Number condicionOperacion) {
        this.condicionOperacion = condicionOperacion;
    }

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public String getCodIncoterms() {
        return codIncoterms;
    }

    public void setCodIncoterms(String codIncoterms) {
        this.codIncoterms = codIncoterms;
    }

    public String getDescIncoterms() {
        return descIncoterms;
    }

    public void setDescIncoterms(String descIncoterms) {
        this.descIncoterms = descIncoterms;
    }

    public String getNumPagoElectronico() {
        return numPagoElectronico;
    }

    public void setNumPagoElectronico(String numPagoElectronico) {
        this.numPagoElectronico = numPagoElectronico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Resumen_fex{" + "totalGravada=" + totalGravada + ", descuento=" + descuento + ", porcentajeDescuento=" + porcentajeDescuento + ", totalDescu=" + totalDescu + ", seguro=" + seguro + ", flete=" + flete + ", montoTotalOperacion=" + montoTotalOperacion + ", totalNoGravado=" + totalNoGravado + ", totalPagar=" + totalPagar + ", totalLetras=" + totalLetras + ", condicionOperacion=" + condicionOperacion + ", pagos=" + pagos + ", codIncoterms=" + codIncoterms + ", descIncoterms=" + descIncoterms + ", numPagoElectronico=" + numPagoElectronico + ", observaciones=" + observaciones + '}';
    }
    
}
