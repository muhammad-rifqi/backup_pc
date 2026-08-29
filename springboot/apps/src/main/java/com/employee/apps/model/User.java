package com.employee.apps.model;

public class User {
    private Long id;
    private String email;
    private String password;
    private String nama;
    private String status;

    public User(Long id, String email, String password, String nama,String status){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nama = nama;
        this.status = status;
    }


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }


    public String getPassword(){
        return password;
    } 

    public void setPassword(String password){
        this.password = password;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getStatus(){
        return status;
    }

     public void setStatus(String status){
        this.status = status;
    }

}
