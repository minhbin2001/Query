package com.example.StudentAPI.repository;

import com.example.StudentAPI.dto.TeacherResponseDTO;
import com.example.StudentAPI.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
    @Query(value = "select new com.example.StudentAPI.dto.TeacherResponseDTO(e.id, e.name) from Teacher e where e.id = :id")
    TeacherResponseDTO getById(@Param("id") long id);
}
