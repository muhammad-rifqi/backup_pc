package com.djmapi.djmapi.model;

public class Tenant {
    
    private Long id;
    private String name;
    private String domain;
    private String address;

    public Tenant(Long id, String name, String domain, String address) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getAddress() {
        return address;
    }
}
