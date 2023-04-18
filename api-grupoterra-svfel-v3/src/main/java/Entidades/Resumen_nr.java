package Entidades;

import java.io.Serializable;
import java.util.List;

public class Resumen_nr implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number totalNoSuj;
    private Number totalExenta;
    private Number totalGravada;
    private Number subTotalVentas;
    private Number descuNoSuj;
    private Number descuExenta;
    private Number descuGravada;
    private Number porcentajeDescuento;
    private Number totalDescu;
    private List<Tributo> tributos;
    private Number subTotal;
    private Number montoTotalOperacion;
    private String totalLetras;

    public Resumen_nr(Number totalNoSuj, Number totalExenta, Number totalGravada, Number subTotalVentas, Number descuNoSuj, Number descuExenta, Number descuGravada, Number porcentajeDescuento, Number totalDescu, List<Tributo> tributos, Number subTotal, Number montoTotalOperacion, String totalLetras) {
        this.totalNoSuj = totalNoSuj;
        this.totalExenta = totalExenta;
        this.totalGravada = totalGravada;
        this.subTotalVentas = subTotalVentas;
        this.descuNoSuj = descuNoSuj;
        this.descuExenta = descuExenta;
        this.descuGravada = descuGravada;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalDescu = totalDescu;
        this.tributos = tributos;
        this.subTotal = subTotal;
        this.montoTotalOperacion = montoTotalOperacion;
        this.totalLetras = totalLetras;
    }

    public Resumen_nr() {
    }

    public Number getTotalNoSuj() {
        return totalNoSuj;
    }

    public void setTotalNoSuj(Number totalNoSuj) {
        this.totalNoSuj = totalNoSuj;
    }

    public Number getTotalExenta() {
        return totalExenta;
    }

    public void setTotalExenta(Number totalExenta) {
        this.totalExenta = totalExenta;
    }

    public Number getTotalGravada() {
        return totalGravada;
    }

    public void setTotalGravada(Number totalGravada) {
        this.totalGravada = totalGravada;
    }

    public Number getSubTotalVentas() {
        return subTotalVentas;
    }

    public void setSubTotalVentas(Number subTotalVentas) {
        this.subTotalVentas = subTotalVentas;
    }

    public Number getDescuNoSuj() {
        return descuNoSuj;
    }

    public void setDescuNoSuj(Number descuNoSuj) {
        this.descuNoSuj = descuNoSuj;
    }

    public Number getDescuExenta() {
        return descuExenta;
    }

    public void setDescuExenta(Number descuExenta) {
        this.descuExenta = descuExenta;
    }

    public Number getDescuGravada() {
        return descuGravada;
    }

    public void setDescuGravada(Number descuGravada) {
        this.descuGravada = descuGravada;
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

    public List<Tributo> getTributos() {
        return tributos;
    }

    public void setTributos(List<Tributo> tributos) {
        this.tributos = tributos;
    }

    public Number getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Number subTotal) {
        this.subTotal = subTotal;
    }

    public Number getMontoTotalOperacion() {
        return montoTotalOperacion;
    }

    public void setMontoTotalOperacion(Number montoTotalOperacion) {
        this.montoTotalOperacion = montoTotalOperacion;
    }

    public String getTotalLetras() {
        return totalLetras;
    }

    public void setTotalLetras(String totalLetras) {
        this.totalLetras = totalLetras;
    }

    @Override
    public String toString() {
        return "Resumen_nr{" + "totalNoSuj=" + totalNoSuj + ", totalExenta=" + totalExenta + ", totalGravada=" + totalGravada + ", subTotalVentas=" + subTotalVentas + ", descuNoSuj=" + descuNoSuj + ", descuExenta=" + descuExenta + ", descuGravada=" + descuGravada + ", porcentajeDescuento=" + porcentajeDescuento + ", totalDescu=" + totalDescu + ", tributos=" + tributos + ", subTotal=" + subTotal + ", montoTotalOperacion=" + montoTotalOperacion + ", totalLetras=" + totalLetras + '}';
    }
    
}
