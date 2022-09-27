package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IdentityCache {
    private Integer userReference;
    private List<String> userLoginSnapshots;
    private String userName;
    @Autowired
    @Qualifier("login")
    private LoginController loginData;

    public Integer getUserReference() {
        return userReference;
    }

    public void setUserReference(Integer userReference) {
        this.userReference = userReference;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getUserLoginSnapshots() {
        return userLoginSnapshots;
    }

    public void setUserLoginSnapshots(List<String> userLoginSnapshots) {
        this.userLoginSnapshots = userLoginSnapshots;
    }

    public String showLogin(){
        return loginData.getAuthToken();
    }
}
