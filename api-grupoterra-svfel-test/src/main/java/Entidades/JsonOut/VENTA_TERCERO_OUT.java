package Entidades.JsonOut;

import java.io.Serializable;

public class VENTA_TERCERO_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nit;
    private String nombre;

    public VENTA_TERCERO_OUT(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
    }

    public VENTA_TERCERO_OUT() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Venta_Tercero{" + "nit=" + nit + ", nombre=" + nombre + '}';
    }
    
}
