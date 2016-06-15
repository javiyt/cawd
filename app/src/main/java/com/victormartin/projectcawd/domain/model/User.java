package com.victormartin.projectcawd.domain.model;

/**
 * Created by Víctor Javier Martín on 18/05/2016.
 *
 * It combines the functionality of @ToString, @EqualsAndHashCode, @Getter and @Setter.
 */
public class User {

    private UserData userData;
    private String token;

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}