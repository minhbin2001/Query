package com.example.StudentAPI.service.impl;


import com.example.StudentAPI.entity.AdminEntity;
import com.example.StudentAPI.repository.AdminRepository;
import com.example.StudentAPI.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {


   private final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

   private final AdminRepository adminRepository;

   public AdminServiceImpl(AdminRepository adminRepository){
       this.adminRepository = adminRepository;
   }
    @Override
    public AdminEntity save(AdminEntity adminEntity) {
        log.debug("Request to save Admin: {}",adminEntity);
        return adminRepository.save(adminEntity);
    }

    @Override
    public AdminEntity update(AdminEntity adminEntity) {
        log.debug("Request to save Admin: {}",adminEntity);
        return adminRepository.save(adminEntity);
    }

    @Override
    public Optional<AdminEntity> partialUpdate(AdminEntity adminEntity) {
        log.debug("Request to partially update Admin : {}", adminEntity);

        return adminRepository
                .findById(adminEntity.getId())
                .map(existingAdmin -> {
                    if (adminEntity.getUsername() != null){
                        existingAdmin.setUsername(adminEntity.getUsername());
                    }
                    if(adminEntity.getPassword() !=null){
                        existingAdmin.setPassword(adminEntity.getUsername());
                    }
                    return existingAdmin;
                })
                        .map(adminRepository::save);
   }


@Autowired
private EntityManager entityManager;
    @Override
    public List<AdminEntity> findAll() {
        log.debug("Request to get all Admin");
        EntityTransaction transaction = entityManager.getTransaction();
        //important//
        transaction.begin();
        //insert //
        transaction.commit();

        transaction.rollback();
        return adminRepository.findAll();
    }

    @Override
    public Optional<AdminEntity> findOne(Long id) {
        log.debug("Request to get Admin :",id);
        return adminRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Admin : {}",id);
        adminRepository.deleteById(id);
    }
}
