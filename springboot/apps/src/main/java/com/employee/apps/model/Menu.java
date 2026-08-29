package com.employee.apps.model;

public class Menu {

    private Long id;
    private String name;
    private Long role_id;
    private String url;

    public Menu(Long id, String name, Long role_id, String url) {
        this.id = id;
        this.name = name;
        this.role_id = role_id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoleId() {
        return role_id;
    }

    public void setRoleId(Long role_id) {
        this.role_id = role_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
