package com.example.StudentAPI.service;

import com.example.StudentAPI.dto.TeacherRequestDTO;
import com.example.StudentAPI.dto.TeacherResponseDTO;
import com.example.StudentAPI.entity.TeacherEntity;

import java.util.Optional;

public interface TeacherService {

    TeacherEntity save(TeacherEntity teacherEntity);

    void update(TeacherRequestDTO teacherRequestDTO, long id);

    Optional<TeacherEntity> partialUpdate(TeacherEntity teacherEntity);

    TeacherResponseDTO getById(long id);

    TeacherResponseDTO findById(Long id);

    TeacherResponseDTO findAll();
    void delete(Long id);


}
