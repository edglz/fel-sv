package Entidades;

import java.io.Serializable;
import java.util.List;

public class Resumen_f implements Serializable {
    
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
    private Number ivaRete1;
    private Number reteRenta;
    private Number montoTotalOperacion;
    private Number totalNoGravado;
    private Number totalPagar;
    private String totalLetras;
    private Number totalIva;
    private Number saldoFavor;
    private Number condicionOperacion;
    private Pagos pagos;
    private String numPagoElectronico;

    public Resumen_f(Number totalNoSuj, Number totalExenta, Number totalGravada, Number subTotalVentas, Number descuNoSuj, Number descuExenta, Number descuGravada, Number porcentajeDescuento, Number totalDescu, List<Tributo> tributos, Number subTotal, Number ivaRete1, Number reteRenta, Number montoTotalOperacion, Number totalNoGravado, Number totalPagar, String totalLetras, Number totalIva, Number saldoFavor, Number condicionOperacion, Pagos pagos, String numPagoElectronico) {
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
        this.ivaRete1 = ivaRete1;
        this.reteRenta = reteRenta;
        this.montoTotalOperacion = montoTotalOperacion;
        this.totalNoGravado = totalNoGravado;
        this.totalPagar = totalPagar;
        this.totalLetras = totalLetras;
        this.totalIva = totalIva;
        this.saldoFavor = saldoFavor;
        this.condicionOperacion = condicionOperacion;
        this.pagos = pagos;
        this.numPagoElectronico = numPagoElectronico;
    }

    public Resumen_f() {
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

    public Number getIvaRete1() {
        return ivaRete1;
    }

    public void setIvaRete1(Number ivaRete1) {
        this.ivaRete1 = ivaRete1;
    }

    public Number getReteRenta() {
        return reteRenta;
    }

    public void setReteRenta(Number reteRenta) {
        this.reteRenta = reteRenta;
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

    public Number getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Number totalIva) {
        this.totalIva = totalIva;
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

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
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
        return "Resumen_f{" + "totalNoSuj=" + totalNoSuj + ", totalExenta=" + totalExenta + ", totalGravada=" + totalGravada + ", subTotalVentas=" + subTotalVentas + ", descuNoSuj=" + descuNoSuj + ", descuExenta=" + descuExenta + ", descuGravada=" + descuGravada + ", porcentajeDescuento=" + porcentajeDescuento + ", totalDescu=" + totalDescu + ", tributos=" + tributos + ", subTotal=" + subTotal + ", ivaRete1=" + ivaRete1 + ", reteRenta=" + reteRenta + ", montoTotalOperacion=" + montoTotalOperacion + ", totalNoGravado=" + totalNoGravado + ", totalPagar=" + totalPagar + ", totalLetras=" + totalLetras + ", totalIva=" + totalIva + ", saldoFavor=" + saldoFavor + ", condicionOperacion=" + condicionOperacion + ", pagos=" + pagos + ", numPagoElectronico=" + numPagoElectronico + '}';
    }
    
}
