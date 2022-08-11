package com.example.StudentAPI.repository;

import com.example.StudentAPI.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}

