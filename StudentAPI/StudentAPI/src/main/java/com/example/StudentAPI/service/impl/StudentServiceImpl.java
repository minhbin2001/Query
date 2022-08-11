package com.example.StudentAPI.service.impl;


import com.example.StudentAPI.entity.StudentEntity;
import com.example.StudentAPI.repository.StudentRepository;
import com.example.StudentAPI.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    private final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);


    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
@Override
    public StudentEntity save(StudentEntity studentEntity){
        log.debug("Request to save Student: {}",studentEntity);
        return studentRepository.save(studentEntity);
}

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        log.debug("Request to save Subject: {}",studentEntity);
        return studentRepository.save(studentEntity);
    }

    @Override
    public Optional<StudentEntity> partialUpdate(StudentEntity studentEntity) {
    log.debug("Request to partially update: {}",studentEntity);
    return studentRepository
            .findById(studentEntity.getId())
            .map(existingStudent ->{
                if(studentEntity.getDegree() != null) {
                    existingStudent.setDegree(studentEntity.getDegree());
                }
                if(studentEntity.getName() != null) {
                    existingStudent.setName(studentEntity.getName());

                }
                if(studentEntity.getEmail() != null) {
                    existingStudent.setEmail(studentEntity.getEmail());
                }
                return existingStudent;
            })
            .map(studentRepository::save);

        }
@Autowired
private EntityManager entityManager;
    @Override
    public List<StudentEntity> findAll() {
        log.debug("Request to get all Student");
        EntityTransaction transaction = entityManager.getTransaction();
        //important//
        transaction.begin();
        //insert //
        transaction.commit();

        transaction.rollback();
        return studentRepository.findAll();    }

    @Override
    public Optional<StudentEntity> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Subject : {}",id);
        studentRepository.deleteById(id);

    }
}
