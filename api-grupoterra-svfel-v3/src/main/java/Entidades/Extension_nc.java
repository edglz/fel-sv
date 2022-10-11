package Entidades;

import java.io.Serializable;

public class Extension_nc implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombEntrega;
    private String docuEntrega;
    private String nombRecibe;
    private String docuRecibe;
    private String observaciones;

    public Extension_nc(String nombEntrega, String docuEntrega, String nombRecibe, String docuRecibe, String observaciones) {
        this.nombEntrega = nombEntrega;
        this.docuEntrega = docuEntrega;
        this.nombRecibe = nombRecibe;
        this.docuRecibe = docuRecibe;
        this.observaciones = observaciones;
    }

    public Extension_nc() {
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

    @Override
    public String toString() {
        return "Extension_nc{" + "nombEntrega=" + nombEntrega + ", docuEntrega=" + docuEntrega + ", nombRecibe=" + nombRecibe + ", docuRecibe=" + docuRecibe + ", observaciones=" + observaciones + '}';
    }
    
}
