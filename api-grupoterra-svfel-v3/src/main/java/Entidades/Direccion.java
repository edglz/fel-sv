package Entidades;

import java.io.Serializable;

public class Direccion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String departamento;
    private String municipio;
    private String complemento;

    public Direccion(String departamento, String municipio, String complemento) {
        this.departamento = departamento;
        this.municipio = municipio;
        this.complemento = complemento;
    }

    public Direccion() {
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
        return "Direccion_ccf{" + "departamento=" + departamento + ", municipio=" + municipio + ", complemento=" + complemento + '}';
    }
    
}
