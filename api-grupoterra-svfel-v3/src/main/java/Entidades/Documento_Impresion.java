package Entidades;

import java.io.Serializable;

public class Documento_Impresion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;
    private String data;
    private String name;
    private String ext;
    private String path;
    private String printer;
    private Integer copies;

    public Documento_Impresion(String type, String data, String name, String ext, String path, String printer, Integer copies) {
        this.type = type;
        this.data = data;
        this.name = name;
        this.ext = ext;
        this.path = path;
        this.printer = printer;
        this.copies = copies;
    }

    public Documento_Impresion() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Documento_Impresion{" + "type=" + type + ", data=" + data + ", name=" + name + ", ext=" + ext + ", path=" + path + ", printer=" + printer + ", copies=" + copies + '}';
    }

}
