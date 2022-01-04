package Entidades.JsonOut;

import java.io.Serializable;

public class ACTIVIDAD_ECONOMICA_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String codActividad;
    private String descActividad;

    public ACTIVIDAD_ECONOMICA_OUT(String codActividad, String descActividad) {
        this.codActividad = codActividad;
        this.descActividad = descActividad;
    }

    public ACTIVIDAD_ECONOMICA_OUT() {
    }

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
    }

    @Override
    public String toString() {
        return "ACTIVIDAD_ECONOMICA_OUT{" + "codActividad=" + codActividad + ", descActividad=" + descActividad + '}';
    }
    
}
