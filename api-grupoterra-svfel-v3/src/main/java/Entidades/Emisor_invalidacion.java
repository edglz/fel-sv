package Entidades;

import java.io.Serializable;

public class Emisor_invalidacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nit;
    private String nombre;
    private String tipoEstablecimiento;
    private String nomEstablecimiento;
    private String codEstableMH;
    private String codEstable;
    private String codPuntoVentaMH;
    private String codPuntoVenta;
    private String telefono;
    private String correo;

    public Emisor_invalidacion(String nit, String nombre, String tipoEstablecimiento, String nomEstablecimiento, String codEstableMH, String codEstable, String codPuntoVentaMH, String codPuntoVenta, String telefono, String correo) {
        this.nit = nit;
        this.nombre = nombre;
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.nomEstablecimiento = nomEstablecimiento;
        this.codEstableMH = codEstableMH;
        this.codEstable = codEstable;
        this.codPuntoVentaMH = codPuntoVentaMH;
        this.codPuntoVenta = codPuntoVenta;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Emisor_invalidacion() {
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

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public String getNomEstablecimiento() {
        return nomEstablecimiento;
    }

    public void setNomEstablecimiento(String nomEstablecimiento) {
        this.nomEstablecimiento = nomEstablecimiento;
    }

    public String getCodEstableMH() {
        return codEstableMH;
    }

    public void setCodEstableMH(String codEstableMH) {
        this.codEstableMH = codEstableMH;
    }

    public String getCodEstable() {
        return codEstable;
    }

    public void setCodEstable(String codEstable) {
        this.codEstable = codEstable;
    }

    public String getCodPuntoVentaMH() {
        return codPuntoVentaMH;
    }

    public void setCodPuntoVentaMH(String codPuntoVentaMH) {
        this.codPuntoVentaMH = codPuntoVentaMH;
    }

    public String getCodPuntoVenta() {
        return codPuntoVenta;
    }

    public void setCodPuntoVenta(String codPuntoVenta) {
        this.codPuntoVenta = codPuntoVenta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Emisor_invalidacion{" + "nit=" + nit + ", nombre=" + nombre + ", tipoEstablecimiento=" + tipoEstablecimiento + ", nomEstablecimiento=" + nomEstablecimiento + ", codEstableMH=" + codEstableMH + ", codEstable=" + codEstable + ", codPuntoVentaMH=" + codPuntoVentaMH + ", codPuntoVenta=" + codPuntoVenta + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
}
