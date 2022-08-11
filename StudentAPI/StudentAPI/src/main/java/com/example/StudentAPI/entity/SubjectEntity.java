package com.example.StudentAPI.entity;

//import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="subject")
public class SubjectEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "descript")
    String descript;

    public SubjectEntity(Long id, String name, String descript) {
        this.id = id;
        this.name = name;
        this.descript = descript;
    }

}