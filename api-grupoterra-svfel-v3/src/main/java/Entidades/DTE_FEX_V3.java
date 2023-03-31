package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_FEX_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_fex identificacion;
    private Emisor_fex emisor;
    private Receptor_fex receptor;
    private List<OtrosDocumentos_fex> otrosDocumentos;
    private VentaTercero_fex ventaTercero;
    private List<CuerpoDocumento_fex> cuerpoDocumento;
    private Resumen_fex resumen;
    private List<Apendice_fex> apendice;

    public DTE_FEX_V3(Identificacion_fex identificacion, Emisor_fex emisor, Receptor_fex receptor, List<OtrosDocumentos_fex> otrosDocumentos, VentaTercero_fex ventaTercero, List<CuerpoDocumento_fex> cuerpoDocumento, Resumen_fex resumen, List<Apendice_fex> apendice) {
        this.identificacion = identificacion;
        this.emisor = emisor;
        this.receptor = receptor;
        this.otrosDocumentos = otrosDocumentos;
        this.ventaTercero = ventaTercero;
        this.cuerpoDocumento = cuerpoDocumento;
        this.resumen = resumen;
        this.apendice = apendice;
    }

    public DTE_FEX_V3() {
    }

    public Identificacion_fex getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_fex identificacion) {
        this.identificacion = identificacion;
    }

    public Emisor_fex getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_fex emisor) {
        this.emisor = emisor;
    }

    public Receptor_fex getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_fex receptor) {
        this.receptor = receptor;
    }

    public List<OtrosDocumentos_fex> getOtrosDocumentos() {
        return otrosDocumentos;
    }

    public void setOtrosDocumentos(List<OtrosDocumentos_fex> otrosDocumentos) {
        this.otrosDocumentos = otrosDocumentos;
    }

    public VentaTercero_fex getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VentaTercero_fex ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CuerpoDocumento_fex> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_fex> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_fex getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_fex resumen) {
        this.resumen = resumen;
    }

    public List<Apendice_fex> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_fex> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_FEX_V3{" + "identificacion=" + identificacion + ", emisor=" + emisor + ", receptor=" + receptor + ", otrosDocumentos=" + otrosDocumentos + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", apendice=" + apendice + '}';
    }
    
}
