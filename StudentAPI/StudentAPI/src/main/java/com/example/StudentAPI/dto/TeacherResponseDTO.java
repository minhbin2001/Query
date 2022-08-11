package com.example.StudentAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherResponseDTO {
    private Long id;

    private String name;

    public TeacherResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
