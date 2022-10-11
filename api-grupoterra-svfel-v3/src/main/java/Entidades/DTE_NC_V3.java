package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_NC_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_nc identificacion;
    private List<DocumentoRelacionado_nc> documentoRelacionado;
    private Emisor_nc emisor;
    private Receptor_nc receptor;
    private VentaTercero_nc ventaTercero;
    private List<CuerpoDocumento_nc> cuerpoDocumento;
    private Resumen_nc resumen;
    private Extension_nc extension;
    private List<Apendice_nc> apendice;

    public DTE_NC_V3(Identificacion_nc identificacion, List<DocumentoRelacionado_nc> documentoRelacionado, Emisor_nc emisor, Receptor_nc receptor, VentaTercero_nc ventaTercero, List<CuerpoDocumento_nc> cuerpoDocumento, Resumen_nc resumen, Extension_nc extension, List<Apendice_nc> apendice) {
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

    public DTE_NC_V3() {
    }

    public Identificacion_nc getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_nc identificacion) {
        this.identificacion = identificacion;
    }

    public List<DocumentoRelacionado_nc> getDocumentoRelacionado() {
        return documentoRelacionado;
    }

    public void setDocumentoRelacionado(List<DocumentoRelacionado_nc> documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }

    public Emisor_nc getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_nc emisor) {
        this.emisor = emisor;
    }

    public Receptor_nc getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_nc receptor) {
        this.receptor = receptor;
    }

    public VentaTercero_nc getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VentaTercero_nc ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CuerpoDocumento_nc> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_nc> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_nc getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_nc resumen) {
        this.resumen = resumen;
    }

    public Extension_nc getExtension() {
        return extension;
    }

    public void setExtension(Extension_nc extension) {
        this.extension = extension;
    }

    public List<Apendice_nc> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_nc> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_NC_V3{" + "identificacion=" + identificacion + ", documentoRelacionado=" + documentoRelacionado + ", emisor=" + emisor + ", receptor=" + receptor + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }
    
}
