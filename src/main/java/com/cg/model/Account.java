package com.cg.model;

public class Account {
    private String nameUser;
    private String password;
    public Account() {
    }
    public Account(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
