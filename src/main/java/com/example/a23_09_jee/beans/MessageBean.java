package com.example.a23_09_jee.beans;

public class MessageBean {

    private String pseudo;
    private String message;

    public MessageBean() {
    }

    public MessageBean(String pseudo, String message) {
        this.pseudo = pseudo;
        this.message = message;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
