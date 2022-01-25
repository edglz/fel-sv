package Entidades;

import java.io.Serializable;

public class TokenMH implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String status;
    private TokenBody body;

    public TokenMH(String status, TokenBody body) {
        this.status = status;
        this.body = body;
    }

    public TokenMH() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TokenBody getBody() {
        return body;
    }

    public void setBody(TokenBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "TokenMH{" + "status=" + status + ", body=" + body + '}';
    }
    
}
