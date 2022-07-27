package Entidades.JsonOut;

import java.io.Serializable;

public class RESUMEN_OUT_NC implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Number totalNoSuj;
    private Number totalExenta;
    private Number totalGravada;
    private Number subTotalVentas;
    private Number totalIva;
    private Number subTotal;
    private Number ivaPerci1;
    private Number ivaRete1;
    private Number fovial;
    private Number cotrans;
    private Number turismo;
    private Number montoTotalOperacion;
    private String totalLetras;
    private Number condicionOperacion;

    public RESUMEN_OUT_NC(Number totalNoSuj, Number totalExenta, Number totalGravada, Number subTotalVentas, Number totalIva, Number subTotal, Number ivaPerci1, Number ivaRete1, Number fovial, Number cotrans, Number turismo, Number montoTotalOperacion, String totalLetras, Number condicionOperacion) {
        this.totalNoSuj = totalNoSuj;
        this.totalExenta = totalExenta;
        this.totalGravada = totalGravada;
        this.subTotalVentas = subTotalVentas;
        this.totalIva = totalIva;
        this.subTotal = subTotal;
        this.ivaPerci1 = ivaPerci1;
        this.ivaRete1 = ivaRete1;
        this.fovial = fovial;
        this.cotrans = cotrans;
        this.turismo = turismo;
        this.montoTotalOperacion = montoTotalOperacion;
        this.totalLetras = totalLetras;
        this.condicionOperacion = condicionOperacion;
    }

    public RESUMEN_OUT_NC() {
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

    public Number getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Number totalIva) {
        this.totalIva = totalIva;
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

    public Number getFovial() {
        return fovial;
    }

    public void setFovial(Number fovial) {
        this.fovial = fovial;
    }

    public Number getCotrans() {
        return cotrans;
    }

    public void setCotrans(Number cotrans) {
        this.cotrans = cotrans;
    }

    public Number getTurismo() {
        return turismo;
    }

    public void setTurismo(Number turismo) {
        this.turismo = turismo;
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

    @Override
    public String toString() {
        return "RESUMEN_OUT_NC{" + "totalNoSuj=" + totalNoSuj + ", totalExenta=" + totalExenta + ", totalGravada=" + totalGravada + ", subTotalVentas=" + subTotalVentas + ", totalIva=" + totalIva + ", subTotal=" + subTotal + ", ivaPerci1=" + ivaPerci1 + ", ivaRete1=" + ivaRete1 + ", fovial=" + fovial + ", cotrans=" + cotrans + ", turismo=" + turismo + ", montoTotalOperacion=" + montoTotalOperacion + ", totalLetras=" + totalLetras + ", condicionOperacion=" + condicionOperacion + '}';
    }
    
}
