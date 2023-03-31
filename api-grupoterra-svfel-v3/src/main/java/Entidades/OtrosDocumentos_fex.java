package Entidades;

import java.io.Serializable;

public class OtrosDocumentos_fex implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Number codDocAsociado;
    private String descDocumento;
    private String detalleDocumento;
    private String placaTrans;
    private Number modoTransp;
    private String numConductor;
    private String nombreConductor;

    public OtrosDocumentos_fex(Number codDocAsociado, String descDocumento, String detalleDocumento, String placaTrans, Number modoTransp, String numConductor, String nombreConductor) {
        this.codDocAsociado = codDocAsociado;
        this.descDocumento = descDocumento;
        this.detalleDocumento = detalleDocumento;
        this.placaTrans = placaTrans;
        this.modoTransp = modoTransp;
        this.numConductor = numConductor;
        this.nombreConductor = nombreConductor;
    }

    public OtrosDocumentos_fex() {
    }

    public Number getCodDocAsociado() {
        return codDocAsociado;
    }

    public void setCodDocAsociado(Number codDocAsociado) {
        this.codDocAsociado = codDocAsociado;
    }

    public String getDescDocumento() {
        return descDocumento;
    }

    public void setDescDocumento(String descDocumento) {
        this.descDocumento = descDocumento;
    }

    public String getDetalleDocumento() {
        return detalleDocumento;
    }

    public void setDetalleDocumento(String detalleDocumento) {
        this.detalleDocumento = detalleDocumento;
    }

    public String getPlacaTrans() {
        return placaTrans;
    }

    public void setPlacaTrans(String placaTrans) {
        this.placaTrans = placaTrans;
    }

    public Number getModoTransp() {
        return modoTransp;
    }

    public void setModoTransp(Number modoTransp) {
        this.modoTransp = modoTransp;
    }

    public String getNumConductor() {
        return numConductor;
    }

    public void setNumConductor(String numConductor) {
        this.numConductor = numConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    @Override
    public String toString() {
        return "OtrosDocumentos_fex{" + "codDocAsociado=" + codDocAsociado + ", descDocumento=" + descDocumento + ", detalleDocumento=" + detalleDocumento + ", placaTrans=" + placaTrans + ", modoTransp=" + modoTransp + ", numConductor=" + numConductor + ", nombreConductor=" + nombreConductor + '}';
    }
    
}
