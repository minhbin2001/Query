package com.example.StudentAPI.repository;

import com.example.StudentAPI.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
