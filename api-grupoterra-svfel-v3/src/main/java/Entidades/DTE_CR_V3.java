package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_CR_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_cr identificacion;
    private Emisor_cr emisor;
    private Receptor_cr receptor;
    private List<CuerpoDocumento_cr> cuerpoDocumento;
    private Resumen_cr resumen;
    private Extension_cr extension;
    private List<Apendice_cr> apendice;

    public DTE_CR_V3(Identificacion_cr identificacion, Emisor_cr emisor, Receptor_cr receptor, List<CuerpoDocumento_cr> cuerpoDocumento, Resumen_cr resumen, Extension_cr extension, List<Apendice_cr> apendice) {
        this.identificacion = identificacion;
        this.emisor = emisor;
        this.receptor = receptor;
        this.cuerpoDocumento = cuerpoDocumento;
        this.resumen = resumen;
        this.extension = extension;
        this.apendice = apendice;
    }

    public DTE_CR_V3() {
    }

    public Identificacion_cr getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_cr identificacion) {
        this.identificacion = identificacion;
    }

    public Emisor_cr getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_cr emisor) {
        this.emisor = emisor;
    }

    public Receptor_cr getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_cr receptor) {
        this.receptor = receptor;
    }

    public List<CuerpoDocumento_cr> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_cr> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_cr getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_cr resumen) {
        this.resumen = resumen;
    }

    public Extension_cr getExtension() {
        return extension;
    }

    public void setExtension(Extension_cr extension) {
        this.extension = extension;
    }

    public List<Apendice_cr> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_cr> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_CR_V3{" + "identificacion=" + identificacion + ", emisor=" + emisor + ", receptor=" + receptor + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }
    
}
