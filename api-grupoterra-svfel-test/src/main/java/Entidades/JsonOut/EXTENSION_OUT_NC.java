package Entidades.JsonOut;

import java.io.Serializable;

public class EXTENSION_OUT_NC implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Number totalItems;
    private String nombEntrega;
    private String docuEntrega;
    private String codEmpleado;
    private String nombRecibe;
    private String docuRecibe;
    private String observaciones;

    public EXTENSION_OUT_NC(Number totalItems, String nombEntrega, String docuEntrega, String codEmpleado, String nombRecibe, String docuRecibe, String observaciones) {
        this.totalItems = totalItems;
        this.nombEntrega = nombEntrega;
        this.docuEntrega = docuEntrega;
        this.codEmpleado = codEmpleado;
        this.nombRecibe = nombRecibe;
        this.docuRecibe = docuRecibe;
        this.observaciones = observaciones;
    }

    public EXTENSION_OUT_NC() {
    }

    public Number getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Number totalItems) {
        this.totalItems = totalItems;
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

    @Override
    public String toString() {
        return "EXTENSION_OUT_NC{" + "totalItems=" + totalItems + ", nombEntrega=" + nombEntrega + ", docuEntrega=" + docuEntrega + ", codEmpleado=" + codEmpleado + ", nombRecibe=" + nombRecibe + ", docuRecibe=" + docuRecibe + ", observaciones=" + observaciones + '}';
    }
    
}
