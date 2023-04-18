package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_NR_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_nr identificacion;
    private List<DocumentoRelacionado_nr> documentoRelacionado;
    private Emisor_nr emisor;
    private Receptor_nr receptor;
    private VentaTercero_nr ventaTercero;
    private List<CuerpoDocumento_nr> cuerpoDocumento;
    private Resumen_nr resumen;
    private Extension_nr extension;
    private List<Apendice_nr> apendice;

    public DTE_NR_V3(Identificacion_nr identificacion, List<DocumentoRelacionado_nr> documentoRelacionado, Emisor_nr emisor, Receptor_nr receptor, VentaTercero_nr ventaTercero, List<CuerpoDocumento_nr> cuerpoDocumento, Resumen_nr resumen, Extension_nr extension, List<Apendice_nr> apendice) {
        this.identificacion = identificacion;
        this.documentoRelacionado = documentoRelacionado;
        this.emisor = emisor;
        this.receptor = receptor;
        this.ventaTercero = ventaTercero;
        this.cuerpoDocumento = cuerpoDocumento;
        this.resumen = resumen;
        this.extension = extension;
        this.apendice = apendice;
    }

    public DTE_NR_V3() {
    }

    public Identificacion_nr getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_nr identificacion) {
        this.identificacion = identificacion;
    }

    public List<DocumentoRelacionado_nr> getDocumentoRelacionado() {
        return documentoRelacionado;
    }

    public void setDocumentoRelacionado(List<DocumentoRelacionado_nr> documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }

    public Emisor_nr getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_nr emisor) {
        this.emisor = emisor;
    }

    public Receptor_nr getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_nr receptor) {
        this.receptor = receptor;
    }

    public VentaTercero_nr getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VentaTercero_nr ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CuerpoDocumento_nr> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_nr> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_nr getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_nr resumen) {
        this.resumen = resumen;
    }

    public Extension_nr getExtension() {
        return extension;
    }

    public void setExtension(Extension_nr extension) {
        this.extension = extension;
    }

    public List<Apendice_nr> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_nr> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_NR_V3{" + "identificacion=" + identificacion + ", documentoRelacionado=" + documentoRelacionado + ", emisor=" + emisor + ", receptor=" + receptor + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }
    
}
