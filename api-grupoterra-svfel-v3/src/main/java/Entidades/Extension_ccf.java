package Entidades;

import java.io.Serializable;

public class Extension_ccf implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombEntrega;
    private String docuEntrega;
    private String nombRecibe;
    private String docuRecibe;
    private String observaciones;
    private String placaVehiculo;

    public Extension_ccf(String nombEntrega, String docuEntrega, String nombRecibe, String docuRecibe, String observaciones, String placaVehiculo) {
        this.nombEntrega = nombEntrega;
        this.docuEntrega = docuEntrega;
        this.nombRecibe = nombRecibe;
        this.docuRecibe = docuRecibe;
        this.observaciones = observaciones;
        this.placaVehiculo = placaVehiculo;
    }

    public Extension_ccf() {
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

    @Override
    public String toString() {
        return "Extension_ccf{" + "nombEntrega=" + nombEntrega + ", docuEntrega=" + docuEntrega + ", nombRecibe=" + nombRecibe + ", docuRecibe=" + docuRecibe + ", observaciones=" + observaciones + ", placaVehiculo=" + placaVehiculo + '}';
    }
    
}
