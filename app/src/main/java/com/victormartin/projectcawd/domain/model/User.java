package com.victormartin.projectcawd.domain.model;

/**
 * Created by Víctor Javier Martín on 18/05/2016.
 *
 * It combines the functionality of @ToString, @EqualsAndHashCode, @Getter and @Setter.
 */
public class User {

    private String name;
    private String email;
    private String token;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token =  "BEARER " + token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}