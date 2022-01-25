package Entidades.JsonOut;

import java.io.Serializable;
import java.util.List;

public class DTE_OUT implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private IDENTIFICACION_OUT identificacion;
    private DOCUMENTOS_RELACIONADOS_OUT documentoRelacionado;
    private EMISOR_OUT emisor;
    private RECEPTOR_OUT receptor;
    private VENTA_TERCERO_OUT ventaTercero;
    private List<CUERPO_DOCUMENTO_OUT> cuerpoDocumento;
    private RESUMEN_OUT resumen;
    private EXTENSION_OUT extension;
    private APENDICE_OUT apendice;

    public DTE_OUT(IDENTIFICACION_OUT identificacion, DOCUMENTOS_RELACIONADOS_OUT documentoRelacionado, EMISOR_OUT emisor, RECEPTOR_OUT receptor, VENTA_TERCERO_OUT ventaTercero, List<CUERPO_DOCUMENTO_OUT> cuerpoDocumento, RESUMEN_OUT resumen, EXTENSION_OUT extension, APENDICE_OUT apendice) {
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

    public DTE_OUT() {
    }

    public IDENTIFICACION_OUT getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(IDENTIFICACION_OUT identificacion) {
        this.identificacion = identificacion;
    }

    public DOCUMENTOS_RELACIONADOS_OUT getDocumentoRelacionado() {
        return documentoRelacionado;
    }

    public void setDocumentoRelacionado(DOCUMENTOS_RELACIONADOS_OUT documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }

    public EMISOR_OUT getEmisor() {
        return emisor;
    }

    public void setEmisor(EMISOR_OUT emisor) {
        this.emisor = emisor;
    }

    public RECEPTOR_OUT getReceptor() {
        return receptor;
    }

    public void setReceptor(RECEPTOR_OUT receptor) {
        this.receptor = receptor;
    }

    public VENTA_TERCERO_OUT getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VENTA_TERCERO_OUT ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CUERPO_DOCUMENTO_OUT> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CUERPO_DOCUMENTO_OUT> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public RESUMEN_OUT getResumen() {
        return resumen;
    }

    public void setResumen(RESUMEN_OUT resumen) {
        this.resumen = resumen;
    }

    public EXTENSION_OUT getExtension() {
        return extension;
    }

    public void setExtension(EXTENSION_OUT extension) {
        this.extension = extension;
    }

    public APENDICE_OUT getApendice() {
        return apendice;
    }

    public void setApendice(APENDICE_OUT apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_OUT{" + "identificacion=" + identificacion + ", documentoRelacionado=" + documentoRelacionado + ", emisor=" + emisor + ", receptor=" + receptor + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }
    
}
