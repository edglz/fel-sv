package Entidades;

import java.io.Serializable;

public class Adjunto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private String data;
    private String ext;
    private String path;

    public Adjunto(String name, String type, String data, String ext, String path) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.ext = ext;
        this.path = path;
    }

    public Adjunto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "file{" + "name=" + name + ", type=" + type + ", data=" + data + ", ext=" + ext + ", path=" + path + '}';
    }

}
