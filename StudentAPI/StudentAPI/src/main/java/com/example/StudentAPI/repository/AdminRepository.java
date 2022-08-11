package com.example.StudentAPI.repository;

import com.example.StudentAPI.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
}
