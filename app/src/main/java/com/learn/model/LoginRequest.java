package com.learn.model;

import com.google.gson.annotations.Expose;

/**
 * Created by chetan on 15/05/15.
 */
public class LoginRequest {

    private String LoginID;
    private String Password;

    public LoginRequest(String loginID, String password) {
        LoginID = loginID;
        Password = password;
    }

    /**
     * @return The LoginID
     */
    public String getLoginID() {
        return LoginID;
    }

    /**
     * @param LoginID The LoginID
     */
    public void setLoginID(String LoginID) {
        this.LoginID = LoginID;
    }

    public LoginRequest withLoginID(String LoginID) {
        this.LoginID = LoginID;
        return this;
    }

    /**
     * @return The Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password The Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public LoginRequest withPassword(String Password) {
        this.Password = Password;
        return this;
    }

}
