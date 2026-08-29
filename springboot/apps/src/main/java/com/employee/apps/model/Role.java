package com.employee.apps.model;

public class Role {

    private Long id;
    private String role_name;
    private String description;

    public Role(Long id, String role_name, String description) {
        this.id = id;
        this.role_name = role_name;
        this.description = description;
    }

    // getter & setter

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return role_name;
    }

    public String getDescrition() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String role_name) {
        this.role_name = role_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
