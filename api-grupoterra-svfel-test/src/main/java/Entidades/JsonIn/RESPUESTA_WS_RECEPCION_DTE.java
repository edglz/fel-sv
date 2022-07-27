package Entidades.JsonIn;

import java.io.Serializable;
import java.util.List;

public class RESPUESTA_WS_RECEPCION_DTE implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String kcoo_jde;
    private String mcu_jde;
    private String doco_jde;
    private String dcto_jde;
    private String doc_jde;
    private String dct_jde;
    private String an8_jde;
    private String shan_jde;
    private String crcd_jde;
    private String ivd_jde;
    private Number version;
    private String ambiente;
    private Number versionApp;
    private String estado;
    private String numeroControl;
    private String codigoGeneracion;
    private String selloRecibido;
    private String fhProcesamiento;
    private String clasificaMsg;
    private String codigoMsg;
    private String descripcionMsg;
    private List<String> observaciones;
    private String nombEntrega;
    private String docuEntrega;
    private String codEmpleado;
    private String nombRecibe;
    private String docuRecibe;
    private String nit_emisor;
    private String nrc_emisor;
    private String num_facturador_emisor;
    private String nombre_razon_social_emisor;
    private String codigo_actividad_emisor;
    private String nombre_actividad_emisor;

    public RESPUESTA_WS_RECEPCION_DTE(String kcoo_jde, String mcu_jde, String doco_jde, String dcto_jde, String doc_jde, String dct_jde, String an8_jde, String shan_jde, String crcd_jde, String ivd_jde, Number version, String ambiente, Number versionApp, String estado, String numeroControl, String codigoGeneracion, String selloRecibido, String fhProcesamiento, String clasificaMsg, String codigoMsg, String descripcionMsg, List<String> observaciones, String nombEntrega, String docuEntrega, String codEmpleado, String nombRecibe, String docuRecibe, String nit_emisor, String nrc_emisor, String num_facturador_emisor, String nombre_razon_social_emisor, String codigo_actividad_emisor, String nombre_actividad_emisor) {
        this.kcoo_jde = kcoo_jde;
        this.mcu_jde = mcu_jde;
        this.doco_jde = doco_jde;
        this.dcto_jde = dcto_jde;
        this.doc_jde = doc_jde;
        this.dct_jde = dct_jde;
        this.an8_jde = an8_jde;
        this.shan_jde = shan_jde;
        this.crcd_jde = crcd_jde;
        this.ivd_jde = ivd_jde;
        this.version = version;
        this.ambiente = ambiente;
        this.versionApp = versionApp;
        this.estado = estado;
        this.numeroControl = numeroControl;
        this.codigoGeneracion = codigoGeneracion;
        this.selloRecibido = selloRecibido;
        this.fhProcesamiento = fhProcesamiento;
        this.clasificaMsg = clasificaMsg;
        this.codigoMsg = codigoMsg;
        this.descripcionMsg = descripcionMsg;
        this.observaciones = observaciones;
        this.nombEntrega = nombEntrega;
        this.docuEntrega = docuEntrega;
        this.codEmpleado = codEmpleado;
        this.nombRecibe = nombRecibe;
        this.docuRecibe = docuRecibe;
        this.nit_emisor = nit_emisor;
        this.nrc_emisor = nrc_emisor;
        this.num_facturador_emisor = num_facturador_emisor;
        this.nombre_razon_social_emisor = nombre_razon_social_emisor;
        this.codigo_actividad_emisor = codigo_actividad_emisor;
        this.nombre_actividad_emisor = nombre_actividad_emisor;
    }

    public RESPUESTA_WS_RECEPCION_DTE() {
    }

    public String getKcoo_jde() {
        return kcoo_jde;
    }

    public void setKcoo_jde(String kcoo_jde) {
        this.kcoo_jde = kcoo_jde;
    }

    public String getMcu_jde() {
        return mcu_jde;
    }

    public void setMcu_jde(String mcu_jde) {
        this.mcu_jde = mcu_jde;
    }

    public String getDoco_jde() {
        return doco_jde;
    }

    public void setDoco_jde(String doco_jde) {
        this.doco_jde = doco_jde;
    }

    public String getDcto_jde() {
        return dcto_jde;
    }

    public void setDcto_jde(String dcto_jde) {
        this.dcto_jde = dcto_jde;
    }

    public String getDoc_jde() {
        return doc_jde;
    }

    public void setDoc_jde(String doc_jde) {
        this.doc_jde = doc_jde;
    }

    public String getDct_jde() {
        return dct_jde;
    }

    public void setDct_jde(String dct_jde) {
        this.dct_jde = dct_jde;
    }

    public String getAn8_jde() {
        return an8_jde;
    }

    public void setAn8_jde(String an8_jde) {
        this.an8_jde = an8_jde;
    }

    public String getShan_jde() {
        return shan_jde;
    }

    public void setShan_jde(String shan_jde) {
        this.shan_jde = shan_jde;
    }

    public String getCrcd_jde() {
        return crcd_jde;
    }

    public void setCrcd_jde(String crcd_jde) {
        this.crcd_jde = crcd_jde;
    }

    public String getIvd_jde() {
        return ivd_jde;
    }

    public void setIvd_jde(String ivd_jde) {
        this.ivd_jde = ivd_jde;
    }

    public Number getVersion() {
        return version;
    }

    public void setVersion(Number version) {
        this.version = version;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Number getVersionApp() {
        return versionApp;
    }

    public void setVersionApp(Number versionApp) {
        this.versionApp = versionApp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getCodigoGeneracion() {
        return codigoGeneracion;
    }

    public void setCodigoGeneracion(String codigoGeneracion) {
        this.codigoGeneracion = codigoGeneracion;
    }

    public String getSelloRecibido() {
        return selloRecibido;
    }

    public void setSelloRecibido(String selloRecibido) {
        this.selloRecibido = selloRecibido;
    }

    public String getFhProcesamiento() {
        return fhProcesamiento;
    }

    public void setFhProcesamiento(String fhProcesamiento) {
        this.fhProcesamiento = fhProcesamiento;
    }

    public String getClasificaMsg() {
        return clasificaMsg;
    }

    public void setClasificaMsg(String clasificaMsg) {
        this.clasificaMsg = clasificaMsg;
    }

    public String getCodigoMsg() {
        return codigoMsg;
    }

    public void setCodigoMsg(String codigoMsg) {
        this.codigoMsg = codigoMsg;
    }

    public String getDescripcionMsg() {
        return descripcionMsg;
    }

    public void setDescripcionMsg(String descripcionMsg) {
        this.descripcionMsg = descripcionMsg;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombEntrega() {
        return nombEntrega;
    }

    public void setNombEntrega(String nombEntrega) {
        this.nombEntrega = nombEntrega;
    }

    public String getDocuEntrega() {
        return docuEntrega;
    }

    public void setDocuEntrega(String docuEntrega) {
        this.docuEntrega = docuEntrega;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombRecibe() {
        return nombRecibe;
    }

    public void setNombRecibe(String nombRecibe) {
        this.nombRecibe = nombRecibe;
    }

    public String getDocuRecibe() {
        return docuRecibe;
    }

    public void setDocuRecibe(String docuRecibe) {
        this.docuRecibe = docuRecibe;
    }

    public String getNit_emisor() {
        return nit_emisor;
    }

    public void setNit_emisor(String nit_emisor) {
        this.nit_emisor = nit_emisor;
    }

    public String getNrc_emisor() {
        return nrc_emisor;
    }

    public void setNrc_emisor(String nrc_emisor) {
        this.nrc_emisor = nrc_emisor;
    }

    public String getNum_facturador_emisor() {
        return num_facturador_emisor;
    }

    public void setNum_facturador_emisor(String num_facturador_emisor) {
        this.num_facturador_emisor = num_facturador_emisor;
    }

    public String getNombre_razon_social_emisor() {
        return nombre_razon_social_emisor;
    }

    public void setNombre_razon_social_emisor(String nombre_razon_social_emisor) {
        this.nombre_razon_social_emisor = nombre_razon_social_emisor;
    }

    public String getCodigo_actividad_emisor() {
        return codigo_actividad_emisor;
    }

    public void setCodigo_actividad_emisor(String codigo_actividad_emisor) {
        this.codigo_actividad_emisor = codigo_actividad_emisor;
    }

    public String getNombre_actividad_emisor() {
        return nombre_actividad_emisor;
    }

    public void setNombre_actividad_emisor(String nombre_actividad_emisor) {
        this.nombre_actividad_emisor = nombre_actividad_emisor;
    }

    @Override
    public String toString() {
        return "RESPUESTA_WS_RECEPCION_DTE{" + "kcoo_jde=" + kcoo_jde + ", mcu_jde=" + mcu_jde + ", doco_jde=" + doco_jde + ", dcto_jde=" + dcto_jde + ", doc_jde=" + doc_jde + ", dct_jde=" + dct_jde + ", an8_jde=" + an8_jde + ", shan_jde=" + shan_jde + ", crcd_jde=" + crcd_jde + ", ivd_jde=" + ivd_jde + ", version=" + version + ", ambiente=" + ambiente + ", versionApp=" + versionApp + ", estado=" + estado + ", numeroControl=" + numeroControl + ", codigoGeneracion=" + codigoGeneracion + ", selloRecibido=" + selloRecibido + ", fhProcesamiento=" + fhProcesamiento + ", clasificaMsg=" + clasificaMsg + ", codigoMsg=" + codigoMsg + ", descripcionMsg=" + descripcionMsg + ", observaciones=" + observaciones + ", nombEntrega=" + nombEntrega + ", docuEntrega=" + docuEntrega + ", codEmpleado=" + codEmpleado + ", nombRecibe=" + nombRecibe + ", docuRecibe=" + docuRecibe + ", nit_emisor=" + nit_emisor + ", nrc_emisor=" + nrc_emisor + ", num_facturador_emisor=" + num_facturador_emisor + ", nombre_razon_social_emisor=" + nombre_razon_social_emisor + ", codigo_actividad_emisor=" + codigo_actividad_emisor + ", nombre_actividad_emisor=" + nombre_actividad_emisor + '}';
    }
    
}
