package com.example.StudentAPI.entity;


import javax.persistence.*;

@Entity
@Table(name ="user")
public class AdminEntity {

    @Id
    private Long id;
    String username;
    String password;

    public AdminEntity(Long id ,String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AdminEntity() {

    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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


}
