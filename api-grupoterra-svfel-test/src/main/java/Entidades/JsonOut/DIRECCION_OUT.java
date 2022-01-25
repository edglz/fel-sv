package Entidades.JsonOut;

import java.io.Serializable;

public class DIRECCION_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String departamento;
    private String municipio;
    private String complemento;

    public DIRECCION_OUT(String departamento, String municipio, String complemento) {
        this.departamento = departamento;
        this.municipio = municipio;
        this.complemento = complemento;
    }

    public DIRECCION_OUT() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "DIRECCION_OUT{" + "departamento=" + departamento + ", municipio=" + municipio + ", complemento=" + complemento + '}';
    }
    
}
