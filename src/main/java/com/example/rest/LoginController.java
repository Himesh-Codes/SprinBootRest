package com.example.rest;

import org.springframework.stereotype.Component;

@Component("login")
public class LoginController {
    private String authToken = "";

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
//    Used to print the string representation on=f object
    public String toString() {
        return "Login{" +
                "authToken='" + authToken + '\'' +
                '}';
    }
}
