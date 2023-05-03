package Entidades;

import java.io.Serializable;

public class DTE_INVALIDACION_V3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identificacion_invalidacion identificacion;
    private Emisor_invalidacion emisor;
    private Documento_invalidacion documento;
    private Motivo_invalidacion motivo;

    public DTE_INVALIDACION_V3(Identificacion_invalidacion identificacion, Emisor_invalidacion emisor, Documento_invalidacion documento, Motivo_invalidacion motivo) {
        this.identificacion = identificacion;
        this.emisor = emisor;
        this.documento = documento;
        this.motivo = motivo;
    }

    public DTE_INVALIDACION_V3() {
    }

    public Identificacion_invalidacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion_invalidacion identificacion) {
        this.identificacion = identificacion;
    }

    public Emisor_invalidacion getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor_invalidacion emisor) {
        this.emisor = emisor;
    }

    public Documento_invalidacion getDocumento() {
        return documento;
    }

    public void setDocumento(Documento_invalidacion documento) {
        this.documento = documento;
    }

    public Motivo_invalidacion getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo_invalidacion motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "DTE_INVALIDACION_V3{" + "identificacion=" + identificacion + ", emisor=" + emisor + ", documento=" + documento + ", motivo=" + motivo + '}';
    }

}
