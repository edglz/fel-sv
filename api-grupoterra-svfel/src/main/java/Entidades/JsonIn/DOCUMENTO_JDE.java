package Entidades.JsonIn;

import java.io.Serializable;

public class DOCUMENTO_JDE implements Serializable {

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

    public DOCUMENTO_JDE(String kcoo_jde, String mcu_jde, String doco_jde, String dcto_jde, String doc_jde, String dct_jde, String an8_jde, String shan_jde, String crcd_jde, String ivd_jde) {
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
    }

    public DOCUMENTO_JDE() {
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

    @Override
    public String toString() {
        return "DOCUMENTO_JDE{" + "kcoo_jde=" + kcoo_jde + ", mcu_jde=" + mcu_jde + ", doco_jde=" + doco_jde + ", dcto_jde=" + dcto_jde + ", doc_jde=" + doc_jde + ", dct_jde=" + dct_jde + ", an8_jde=" + an8_jde + ", shan_jde=" + shan_jde + ", crcd_jde=" + crcd_jde + ", ivd_jde=" + ivd_jde + '}';
    }
    
}
