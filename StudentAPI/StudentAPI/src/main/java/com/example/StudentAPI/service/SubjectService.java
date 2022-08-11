package com.example.StudentAPI.service;

import com.example.StudentAPI.entity.SubjectEntity;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    SubjectEntity save(SubjectEntity subjectEntity);

    SubjectEntity update(SubjectEntity subjectEntity);

    Optional<SubjectEntity> partialUpdate(SubjectEntity subjectEntity);

    List<SubjectEntity> findAll();

    Optional<SubjectEntity> findOne(Long id);

    void delete(Long id);
}
