package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_ND_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_nd identificacion;
    private List<DocumentoRelacionado_nd> documentoRelacionado;
    private Emisor_nd emisor;
    private Receptor_nd receptor;
    private VentaTercero_nd ventaTercero;
    private List<CuerpoDocumento_nd> cuerpoDocumento;
    private Resumen_nd resumen;
    private Extension_nd extension;
    private List<Apendice_nd> apendice;

    public DTE_ND_V3(Identificacion_nd identificacion, List<DocumentoRelacionado_nd> documentoRelacionado, Emisor_nd emisor, Receptor_nd receptor, VentaTercero_nd ventaTercero, List<CuerpoDocumento_nd> cuerpoDocumento, Resumen_nd resumen, Extension_nd extension, List<Apendice_nd> apendice) {
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

    public DTE_ND_V3() {
    }

    public Identificacion_nd getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_nd identificacion) {
        this.identificacion = identificacion;
    }

    public List<DocumentoRelacionado_nd> getDocumentoRelacionado() {
        return documentoRelacionado;
    }

    public void setDocumentoRelacionado(List<DocumentoRelacionado_nd> documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }

    public Emisor_nd getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_nd emisor) {
        this.emisor = emisor;
    }

    public Receptor_nd getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_nd receptor) {
        this.receptor = receptor;
    }

    public VentaTercero_nd getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VentaTercero_nd ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CuerpoDocumento_nd> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_nd> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_nd getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_nd resumen) {
        this.resumen = resumen;
    }

    public Extension_nd getExtension() {
        return extension;
    }

    public void setExtension(Extension_nd extension) {
        this.extension = extension;
    }

    public List<Apendice_nd> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_nd> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_ND_V3{" + "identificacion=" + identificacion + ", documentoRelacionado=" + documentoRelacionado + ", emisor=" + emisor + ", receptor=" + receptor + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }
    
}
