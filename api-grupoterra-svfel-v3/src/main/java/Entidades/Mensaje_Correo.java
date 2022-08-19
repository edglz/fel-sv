package Entidades;

import java.io.Serializable;
import java.util.List;

public class Mensaje_Correo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recipients;
    private String cc;
    private String subject;
    private String body;
    private String bodyHtml;
    private List<Adjunto> files;

    public Mensaje_Correo(String recipients, String cc, String subject, String body, String bodyHtml, List<Adjunto> files) {
        this.recipients = recipients;
        this.cc = cc;
        this.subject = subject;
        this.body = body;
        this.bodyHtml = bodyHtml;
        this.files = files;
    }

    public Mensaje_Correo() {
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public List<Adjunto> getFiles() {
        return files;
    }

    public void setFiles(List<Adjunto> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Mensaje_Correo{" + "recipients=" + recipients + ", cc=" + cc + ", subject=" + subject + ", body=" + body + ", bodyHtml=" + bodyHtml + ", files=" + files + '}';
    }

}
