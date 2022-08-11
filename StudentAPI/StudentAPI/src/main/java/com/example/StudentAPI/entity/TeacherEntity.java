package com.example.StudentAPI.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity(name = "Teacher")
@Table(name = "teacher")
public class TeacherEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")

    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "security_q")
    private String security_q;
    @Column(name = "password")
    private String password;

    @Column(name = "security_a")
    private String security_a;

    @ManyToMany
    @JoinTable(name = "teacher_subject",joinColumns =@JoinColumn(name = "teacher_id"),inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<SubjectEntity> likedSubject;



    public TeacherEntity(String name, String email, String phone, String security_a, String security_q, String password) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.security_a = security_a;
        this.security_q = security_q;
        this.password = password;
    }
    @ManyToOne
    StudentEntity studentEntity;

    public TeacherEntity() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecurity_a() {
        return security_a;
    }

    public void setSecurity_a(String security_a) {
        this.security_a = security_a;
    }

    public String getSecurity_q() {
        return security_q;
    }

    public void setSecurity_q(String security_q) {
        this.security_q = security_q;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
