package com.example.StudentAPI.entity;


import javax.persistence.*;

@Entity
@Table(name = "lesson")
public class LessonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name = "time_start")
    private String time_start;

    @Column(name = "time_end")
    private String time_end;

    @Column(name = "classroom")
    private String classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    public LessonEntity(String name, String time_start, String time_end, String classroom) {

        this.name = name;
        this.time_start = time_start;
        this.time_end = time_end;
        this.classroom = classroom;

    }

    public LessonEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getClassroom() {
        return classroom; }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
