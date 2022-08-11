package com.example.StudentAPI.entity;

import com.example.StudentAPI.entity.enumaration.degree;
import com.example.StudentAPI.entity.enumaration.gender;
import com.example.StudentAPI.entity.enumaration.semester;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name ="name")
    private String name;
    @Column (name ="email")
    private String email;
    @JsonFormat(pattern ="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "dob")
    private String dob;
    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    private gender gender;

    @Enumerated(EnumType.STRING)
    private semester semester;
    @Enumerated(EnumType.STRING)
    private degree degree;

    @ManyToMany
    @JoinTable(name = "student_lesson",joinColumns =@JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonEntity> likedLessons;

    @ManyToMany
    @JoinTable(name = "student_subject",joinColumns =@JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<SubjectEntity> likedSubjects;

    public com.example.StudentAPI.entity.enumaration.gender getGender() {
        return gender;
    }

    public void setGender(com.example.StudentAPI.entity.enumaration.gender gender) {
        this.gender = gender;
    }

    public semester getSemester() {
        return semester;
    }

    public void setSemester(com.example.StudentAPI.entity.enumaration.semester semester) {
        this.semester = semester;
    }

    public degree getDegree() {
        return degree;
    }

    public void setDegree(com.example.StudentAPI.entity.enumaration.degree degree) {
        this.degree = degree;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public StudentEntity(String name, String email, String dob, String phone,semester semester,degree degree,gender gender) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.semester = semester;
        this.degree = degree;
        this.gender = gender;
    }

    public StudentEntity() {

    }
}


