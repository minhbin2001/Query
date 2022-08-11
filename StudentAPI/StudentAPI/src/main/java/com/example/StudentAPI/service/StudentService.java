package com.example.StudentAPI.service;

import com.example.StudentAPI.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentEntity save(StudentEntity studentEntity);

    StudentEntity update(StudentEntity studentEntity);

    Optional<StudentEntity> partialUpdate(StudentEntity studentEntity);

    List<StudentEntity> findAll();

    Optional<StudentEntity> findOne(Long id);

    void delete(Long id);
}
