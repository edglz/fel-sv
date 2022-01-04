package Entidades.JsonOut;

import java.io.Serializable;

public class SUCURSAL_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String codigo;
    private String puntoVenta;
    private DIRECCION_OUT direccion;
    private String telefono;

    public SUCURSAL_OUT(String nombre, String codigo, String puntoVenta, DIRECCION_OUT direccion, String telefono) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.puntoVenta = puntoVenta;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public SUCURSAL_OUT() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(String puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public DIRECCION_OUT getDireccion() {
        return direccion;
    }

    public void setDireccion(DIRECCION_OUT direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "SUCURSAL_OUT{" + "nombre=" + nombre + ", codigo=" + codigo + ", puntoVenta=" + puntoVenta + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
}
