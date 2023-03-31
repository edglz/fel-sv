package Entidades;

import java.io.Serializable;
import java.util.List;

public class CuerpoDocumento_fex implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number numItem;
    private Number cantidad;
    private String codigo;
    private Number uniMedida;
    private String descripcion;
    private Number precioUni;
    private Number montoDescu;
    private Number ventaGravada;
    private List<String> tributos;
    private Number noGravado;

    public CuerpoDocumento_fex(Number numItem, Number cantidad, String codigo, Number uniMedida, String descripcion, Number precioUni, Number montoDescu, Number ventaGravada, List<String> tributos, Number noGravado) {
        this.numItem = numItem;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.uniMedida = uniMedida;
        this.descripcion = descripcion;
        this.precioUni = precioUni;
        this.montoDescu = montoDescu;
        this.ventaGravada = ventaGravada;
        this.tributos = tributos;
        this.noGravado = noGravado;
    }

    public CuerpoDocumento_fex() {
    }

    public Number getNumItem() {
        return numItem;
    }

    public void setNumItem(Number numItem) {
        this.numItem = numItem;
    }

    public Number getCantidad() {
        return cantidad;
    }

    public void setCantidad(Number cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Number getUniMedida() {
        return uniMedida;
    }

    public void setUniMedida(Number uniMedida) {
        this.uniMedida = uniMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Number getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Number precioUni) {
        this.precioUni = precioUni;
    }

    public Number getMontoDescu() {
        return montoDescu;
    }

    public void setMontoDescu(Number montoDescu) {
        this.montoDescu = montoDescu;
    }

    public Number getVentaGravada() {
        return ventaGravada;
    }

    public void setVentaGravada(Number ventaGravada) {
        this.ventaGravada = ventaGravada;
    }

    public List<String> getTributos() {
        return tributos;
    }

    public void setTributos(List<String> tributos) {
        this.tributos = tributos;
    }

    public Number getNoGravado() {
        return noGravado;
    }

    public void setNoGravado(Number noGravado) {
        this.noGravado = noGravado;
    }

    @Override
    public String toString() {
        return "CuerpoDocumento_fex{" + "numItem=" + numItem + ", cantidad=" + cantidad + ", codigo=" + codigo + ", uniMedida=" + uniMedida + ", descripcion=" + descripcion + ", precioUni=" + precioUni + ", montoDescu=" + montoDescu + ", ventaGravada=" + ventaGravada + ", tributos=" + tributos + ", noGravado=" + noGravado + '}';
    }
    
}
