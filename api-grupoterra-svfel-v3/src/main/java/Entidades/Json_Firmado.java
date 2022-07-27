package Entidades;

import java.io.Serializable;

public class Json_Firmado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String status;
    private String body;

    public Json_Firmado(String status, String body) {
        this.status = status;
        this.body = body;
    }

    public Json_Firmado() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Json_Firmado{" + "status=" + status + ", body=" + body + '}';
    }
    
}
