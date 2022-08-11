package com.example.StudentAPI.service;


import com.example.StudentAPI.entity.LessonEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    LessonEntity save(LessonEntity lessonEntity);

    LessonEntity update(LessonEntity lessonEntity);

    Optional<LessonEntity> partialUpdate(LessonEntity lessonEntity);

    List<LessonEntity> findAll();

    Optional<LessonEntity> findOne(Long id);

    void delete(Long id);
}