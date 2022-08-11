package com.example.StudentAPI.repository;

import com.example.StudentAPI.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity,Long> {

}
