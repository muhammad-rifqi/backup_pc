package com.djmapi.djmapi.model;

public class UserDb {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String access;

    public UserDb() {
    }

    public UserDb(Long id, String email, String username, String password, String access) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
