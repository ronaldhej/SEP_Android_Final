package com.github.sep_android_app.data.model;

public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.password = password;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
