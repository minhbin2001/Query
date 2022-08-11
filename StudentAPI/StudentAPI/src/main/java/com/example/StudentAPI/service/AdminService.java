package com.example.StudentAPI.service;

import com.example.StudentAPI.entity.AdminEntity;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    AdminEntity save(AdminEntity adminEntity);

    AdminEntity update(AdminEntity adminEntity);

    Optional<AdminEntity> partialUpdate(AdminEntity adminEntity);

    List<AdminEntity> findAll();

    Optional<AdminEntity> findOne(Long id);

    void delete(Long id);
}
