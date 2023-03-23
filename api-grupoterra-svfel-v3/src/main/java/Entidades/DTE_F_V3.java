package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_F_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_f identificacion;
    private List<DocumentoRelacionado_f> documentoRelacionado;
    private Emisor_f emisor;
    private Receptor_f receptor;
    private List<OtrosDocumentos_f> otrosDocumentos;
    private VentaTercero_f ventaTercero;
    private List<CuerpoDocumento_f> cuerpoDocumento;
    private Resumen_f resumen;
    private Extension_f extension;
    private List<Apendice_f> apendice;

    public DTE_F_V3(Identificacion_f identificacion, List<DocumentoRelacionado_f> documentoRelacionado, Emisor_f emisor, Receptor_f receptor, List<OtrosDocumentos_f> otrosDocumentos, VentaTercero_f ventaTercero, List<CuerpoDocumento_f> cuerpoDocumento, Resumen_f resumen, Extension_f extension, List<Apendice_f> apendice) {
        this.identificacion = identificacion;
        this.documentoRelacionado = documentoRelacionado;
        this.emisor = emisor;
        this.receptor = receptor;
        this.otrosDocumentos = otrosDocumentos;
        this.ventaTercero = ventaTercero;
        this.cuerpoDocumento = cuerpoDocumento;
        this.resumen = resumen;
        this.extension = extension;
        this.apendice = apendice;
    }

    public DTE_F_V3() {
    }

    public Identificacion_f getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_f identificacion) {
        this.identificacion = identificacion;
    }

    public List<DocumentoRelacionado_f> getDocumentoRelacionado() {
        return documentoRelacionado;
    }

    public void setDocumentoRelacionado(List<DocumentoRelacionado_f> documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }

    public Emisor_f getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_f emisor) {
        this.emisor = emisor;
    }

    public Receptor_f getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_f receptor) {
        this.receptor = receptor;
    }

    public List<OtrosDocumentos_f> getOtrosDocumentos() {
        return otrosDocumentos;
    }

    public void setOtrosDocumentos(List<OtrosDocumentos_f> otrosDocumentos) {
        this.otrosDocumentos = otrosDocumentos;
    }

    public VentaTercero_f getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VentaTercero_f ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CuerpoDocumento_f> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_f> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_f getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_f resumen) {
        this.resumen = resumen;
    }

    public Extension_f getExtension() {
        return extension;
    }

    public void setExtension(Extension_f extension) {
        this.extension = extension;
    }

    public List<Apendice_f> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_f> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_F_V3{" + "identificacion=" + identificacion + ", documentoRelacionado=" + documentoRelacionado + ", emisor=" + emisor + ", receptor=" + receptor + ", otrosDocumentos=" + otrosDocumentos + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }
    
}
