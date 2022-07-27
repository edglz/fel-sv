package Entidades;

import java.io.Serializable;
import java.util.List;

public class DTE_CCF_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_ccf identificacion;
    private List<DocumentoRelacionado_ccf> documentoRelacionado;
    private Emisor_ccf emisor;
    private Receptor_ccf receptor;
    private List<OtrosDocumentos_ccf> otrosDocumentos;
    private VentaTercero_ccf ventaTercero;
    private List<CuerpoDocumento_ccf> cuerpoDocumento;
    private Resumen_ccf resumen;
    private Extension_ccf extension;
    private List<Apendice_ccf> apendice;

    public DTE_CCF_V3(Identificacion_ccf identificacion, List<DocumentoRelacionado_ccf> documentoRelacionado, Emisor_ccf emisor, Receptor_ccf receptor, List<OtrosDocumentos_ccf> otrosDocumentos, VentaTercero_ccf ventaTercero, List<CuerpoDocumento_ccf> cuerpoDocumento, Resumen_ccf resumen, Extension_ccf extension, List<Apendice_ccf> apendice) {
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

    public DTE_CCF_V3() {
    }

    public Identificacion_ccf getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_ccf identificacion) {
        this.identificacion = identificacion;
    }

    public List<DocumentoRelacionado_ccf> getDocumentoRelacionado() {
        return documentoRelacionado;
    }

    public void setDocumentoRelacionado(List<DocumentoRelacionado_ccf> documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }

    public Emisor_ccf getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_ccf emisor) {
        this.emisor = emisor;
    }

    public Receptor_ccf getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor_ccf receptor) {
        this.receptor = receptor;
    }

    public List<OtrosDocumentos_ccf> getOtrosDocumentos() {
        return otrosDocumentos;
    }

    public void setOtrosDocumentos(List<OtrosDocumentos_ccf> otrosDocumentos) {
        this.otrosDocumentos = otrosDocumentos;
    }

    public VentaTercero_ccf getVentaTercero() {
        return ventaTercero;
    }

    public void setVentaTercero(VentaTercero_ccf ventaTercero) {
        this.ventaTercero = ventaTercero;
    }

    public List<CuerpoDocumento_ccf> getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(List<CuerpoDocumento_ccf> cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public Resumen_ccf getResumen() {
        return resumen;
    }

    public void setResumen(Resumen_ccf resumen) {
        this.resumen = resumen;
    }

    public Extension_ccf getExtension() {
        return extension;
    }

    public void setExtension(Extension_ccf extension) {
        this.extension = extension;
    }

    public List<Apendice_ccf> getApendice() {
        return apendice;
    }

    public void setApendice(List<Apendice_ccf> apendice) {
        this.apendice = apendice;
    }

    @Override
    public String toString() {
        return "DTE_CCF_V3{" + "identificacion=" + identificacion + ", documentoRelacionado=" + documentoRelacionado + ", emisor=" + emisor + ", receptor=" + receptor + ", otrosDocumentos=" + otrosDocumentos + ", ventaTercero=" + ventaTercero + ", cuerpoDocumento=" + cuerpoDocumento + ", resumen=" + resumen + ", extension=" + extension + ", apendice=" + apendice + '}';
    }

}
