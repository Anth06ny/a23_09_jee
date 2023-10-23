package com.example.a23_09_jee.beans;

public class UserBean {

    private String login,password,sessionId;

    public UserBean() {
    }

    public UserBean(String login, String password, String sessionId) {
        this.login = login;
        this.password = password;
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
