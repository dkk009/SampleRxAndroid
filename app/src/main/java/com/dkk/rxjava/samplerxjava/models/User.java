package com.dkk.rxjava.samplerxjava.models;

/**
 * Created by deepak on 23/2/17.
 * User model class using for holding user data
 */

public class User extends BaseModel {

    private String userName;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
