package Entidades.JsonOut;

import java.io.Serializable;

public class RESUMEN_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Number totalNoSuj;
    private Number totalExenta;
    private Number totalGravada;
    private Number subTotalVentas;
    private Number porcentajeDescuento;
    private Number descuento;
    private Number totalIva;
    private Number subTotal;
    private Number ivaPerci1;
    private Number ivaRete1;
    private Number fovial;
    private Number cotrans;
    private Number turismo;
    private Number adValorem;
    private Number montoTotalOperacion;
    private Number totalNoGravado;
    private Number totalPagar;
    private String totalLetras;
    private Number saldoFavor;
    private Number condicionOperacion;
    private PAGOS_OUT pagos;
    private String numPagoElectronico;

    public RESUMEN_OUT(Number totalNoSuj, Number totalExenta, Number totalGravada, Number subTotalVentas, Number porcentajeDescuento, Number descuento, Number totalIva, Number subTotal, Number ivaPerci1, Number ivaRete1, Number fovial, Number cotrans, Number turismo, Number adValorem, Number montoTotalOperacion, Number totalNoGravado, Number totalPagar, String totalLetras, Number saldoFavor, Number condicionOperacion, PAGOS_OUT pagos, String numPagoElectronico) {
        this.totalNoSuj = totalNoSuj;
        this.totalExenta = totalExenta;
        this.totalGravada = totalGravada;
        this.subTotalVentas = subTotalVentas;
        this.porcentajeDescuento = porcentajeDescuento;
        this.descuento = descuento;
        this.totalIva = totalIva;
        this.subTotal = subTotal;
        this.ivaPerci1 = ivaPerci1;
        this.ivaRete1 = ivaRete1;
        this.fovial = fovial;
        this.cotrans = cotrans;
        this.turismo = turismo;
        this.adValorem = adValorem;
        this.montoTotalOperacion = montoTotalOperacion;
        this.totalNoGravado = totalNoGravado;
        this.totalPagar = totalPagar;
        this.totalLetras = totalLetras;
        this.saldoFavor = saldoFavor;
        this.condicionOperacion = condicionOperacion;
        this.pagos = pagos;
        this.numPagoElectronico = numPagoElectronico;
    }

    public RESUMEN_OUT() {
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

    public Number getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Number porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Number getDescuento() {
        return descuento;
    }

    public void setDescuento(Number descuento) {
        this.descuento = descuento;
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

    public Number getAdValorem() {
        return adValorem;
    }

    public void setAdValorem(Number adValorem) {
        this.adValorem = adValorem;
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

    public Number getSaldoFavor() {
        return saldoFavor;
    }

    public void setSaldoFavor(Number saldoFavor) {
        this.saldoFavor = saldoFavor;
    }

    public Number getCondicionOperacion() {
        return condicionOperacion;
    }

    public void setCondicionOperacion(Number condicionOperacion) {
        this.condicionOperacion = condicionOperacion;
    }

    public PAGOS_OUT getPagos() {
        return pagos;
    }

    public void setPagos(PAGOS_OUT pagos) {
        this.pagos = pagos;
    }

    public String getNumPagoElectronico() {
        return numPagoElectronico;
    }

    public void setNumPagoElectronico(String numPagoElectronico) {
        this.numPagoElectronico = numPagoElectronico;
    }

    @Override
    public String toString() {
        return "RESUMEN_OUT{" + "totalNoSuj=" + totalNoSuj + ", totalExenta=" + totalExenta + ", totalGravada=" + totalGravada + ", subTotalVentas=" + subTotalVentas + ", porcentajeDescuento=" + porcentajeDescuento + ", descuento=" + descuento + ", totalIva=" + totalIva + ", subTotal=" + subTotal + ", ivaPerci1=" + ivaPerci1 + ", ivaRete1=" + ivaRete1 + ", fovial=" + fovial + ", cotrans=" + cotrans + ", turismo=" + turismo + ", adValorem=" + adValorem + ", montoTotalOperacion=" + montoTotalOperacion + ", totalNoGravado=" + totalNoGravado + ", totalPagar=" + totalPagar + ", totalLetras=" + totalLetras + ", saldoFavor=" + saldoFavor + ", condicionOperacion=" + condicionOperacion + ", pagos=" + pagos + ", numPagoElectronico=" + numPagoElectronico + '}';
    }
    
}
