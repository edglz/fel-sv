package Entidades;

import java.io.Serializable;
import java.util.List;

public class Resumen_nd implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number totalNoSuj;
    private Number totalExenta;
    private Number totalGravada;
    private Number subTotalVentas;
    private Number descuNoSuj;
    private Number descuExenta;
    private Number descuGravada;
    private Number totalDescu;
    private List<Tributo> tributos;
    private Number subTotal;
    private Number ivaPerci1;
    private Number ivaRete1;
    private Number montoTotalOperacion;
    private String totalLetras;
    private Number condicionOperacion;
    private String numPagoElectronico;

    public Resumen_nd(Number totalNoSuj, Number totalExenta, Number totalGravada, Number subTotalVentas, Number descuNoSuj, Number descuExenta, Number descuGravada, Number totalDescu, List<Tributo> tributos, Number subTotal, Number ivaPerci1, Number ivaRete1, Number montoTotalOperacion, String totalLetras, Number condicionOperacion, String numPagoElectronico) {
        this.totalNoSuj = totalNoSuj;
        this.totalExenta = totalExenta;
        this.totalGravada = totalGravada;
        this.subTotalVentas = subTotalVentas;
        this.descuNoSuj = descuNoSuj;
        this.descuExenta = descuExenta;
        this.descuGravada = descuGravada;
        this.totalDescu = totalDescu;
        this.tributos = tributos;
        this.subTotal = subTotal;
        this.ivaPerci1 = ivaPerci1;
        this.ivaRete1 = ivaRete1;
        this.montoTotalOperacion = montoTotalOperacion;
        this.totalLetras = totalLetras;
        this.condicionOperacion = condicionOperacion;
        this.numPagoElectronico = numPagoElectronico;
    }

    public Resumen_nd() {
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

    public Number getIvaPerci1() {
        return ivaPerci1;
    }

    public void setIvaPerci1(Number ivaPerci1) {
        this.ivaPerci1 = ivaPerci1;
    }

    public Number getIvaRete1() {
        return ivaRete1;
    }

    public void setIvaRete1(Number ivaRete1) {
        this.ivaRete1 = ivaRete1;
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

    public Number getCondicionOperacion() {
        return condicionOperacion;
    }

    public void setCondicionOperacion(Number condicionOperacion) {
        this.condicionOperacion = condicionOperacion;
    }

    public String getNumPagoElectronico() {
        return numPagoElectronico;
    }

    public void setNumPagoElectronico(String numPagoElectronico) {
        this.numPagoElectronico = numPagoElectronico;
    }

    @Override
    public String toString() {
        return "Resumen_nd{" + "totalNoSuj=" + totalNoSuj + ", totalExenta=" + totalExenta + ", totalGravada=" + totalGravada + ", subTotalVentas=" + subTotalVentas + ", descuNoSuj=" + descuNoSuj + ", descuExenta=" + descuExenta + ", descuGravada=" + descuGravada + ", totalDescu=" + totalDescu + ", tributos=" + tributos + ", subTotal=" + subTotal + ", ivaPerci1=" + ivaPerci1 + ", ivaRete1=" + ivaRete1 + ", montoTotalOperacion=" + montoTotalOperacion + ", totalLetras=" + totalLetras + ", condicionOperacion=" + condicionOperacion + ", numPagoElectronico=" + numPagoElectronico + '}';
    }
    
}
