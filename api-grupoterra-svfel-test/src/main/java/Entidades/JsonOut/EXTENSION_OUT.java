package Entidades.JsonOut;

import java.io.Serializable;

public class EXTENSION_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Number totalItems;
    private Number totalDescu;
    private String nombEntrega;
    private String docuEntrega;
    private String codEmpleado;
    private String nombRecibe;
    private String docuRecibe;
    private String observaciones;
    private String placaVehiculo;
    private String autoFitoSanitaria;

    public EXTENSION_OUT(Number totalItems, Number totalDescu, String nombEntrega, String docuEntrega, String codEmpleado, String nombRecibe, String docuRecibe, String observaciones, String placaVehiculo, String autoFitoSanitaria) {
        this.totalItems = totalItems;
        this.totalDescu = totalDescu;
        this.nombEntrega = nombEntrega;
        this.docuEntrega = docuEntrega;
        this.codEmpleado = codEmpleado;
        this.nombRecibe = nombRecibe;
        this.docuRecibe = docuRecibe;
        this.observaciones = observaciones;
        this.placaVehiculo = placaVehiculo;
        this.autoFitoSanitaria = autoFitoSanitaria;
    }

    public EXTENSION_OUT() {
    }

    public Number getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Number totalItems) {
        this.totalItems = totalItems;
    }

    public Number getTotalDescu() {
        return totalDescu;
    }

    public void setTotalDescu(Number totalDescu) {
        this.totalDescu = totalDescu;
    }

    public String getNombEntrega() {
        return nombEntrega;
    }

    public void setNombEntrega(String nombEntrega) {
        this.nombEntrega = nombEntrega;
    }

    public String getDocuEntrega() {
        return docuEntrega;
    }

    public void setDocuEntrega(String docuEntrega) {
        this.docuEntrega = docuEntrega;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombRecibe() {
        return nombRecibe;
    }

    public void setNombRecibe(String nombRecibe) {
        this.nombRecibe = nombRecibe;
    }

    public String getDocuRecibe() {
        return docuRecibe;
    }

    public void setDocuRecibe(String docuRecibe) {
        this.docuRecibe = docuRecibe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getAutoFitoSanitaria() {
        return autoFitoSanitaria;
    }

    public void setAutoFitoSanitaria(String autoFitoSanitaria) {
        this.autoFitoSanitaria = autoFitoSanitaria;
    }

    @Override
    public String toString() {
        return "EXTENSION_OUT{" + "totalItems=" + totalItems + ", totalDescu=" + totalDescu + ", nombEntrega=" + nombEntrega + ", docuEntrega=" + docuEntrega + ", codEmpleado=" + codEmpleado + ", nombRecibe=" + nombRecibe + ", docuRecibe=" + docuRecibe + ", observaciones=" + observaciones + ", placaVehiculo=" + placaVehiculo + ", autoFitoSanitaria=" + autoFitoSanitaria + '}';
    }
    
}
