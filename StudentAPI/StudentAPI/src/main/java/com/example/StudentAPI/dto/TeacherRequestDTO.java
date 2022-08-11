package com.example.StudentAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherRequestDTO {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String security_q;

    private String password;

    private String security_a;
}
