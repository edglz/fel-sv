package Entidades;

import java.io.Serializable;
import java.util.List;

public class TokenBody implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String user;
    private String token;
    private TokenBodyRol rol;
    private List<String> roles;
    private String tokenType;

    public TokenBody(String user, String token, TokenBodyRol rol, List<String> roles, String tokenType) {
        this.user = user;
        this.token = token;
        this.rol = rol;
        this.roles = roles;
        this.tokenType = tokenType;
    }

    public TokenBody() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenBodyRol getRol() {
        return rol;
    }

    public void setRol(TokenBodyRol rol) {
        this.rol = rol;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public String toString() {
        return "TokenBody{" + "user=" + user + ", token=" + token + ", rol=" + rol + ", roles=" + roles + ", tokenType=" + tokenType + '}';
    }
    
}
