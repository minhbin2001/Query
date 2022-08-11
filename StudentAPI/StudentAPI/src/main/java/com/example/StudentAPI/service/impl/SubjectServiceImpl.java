package com.example.StudentAPI.service.impl;


import com.example.StudentAPI.entity.SubjectEntity;
import com.example.StudentAPI.repository.SubjectRepository;
import com.example.StudentAPI.service.SubjectService;
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
public class SubjectServiceImpl implements SubjectService {

   private final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);



   private final SubjectRepository subjectRepository;

   public SubjectServiceImpl(SubjectRepository subjectRepository) {
       this.subjectRepository = subjectRepository;
   }

    @Override
    public SubjectEntity save(SubjectEntity subjectEntity) {
        log.debug("Request to save Subject: {}",subjectEntity);
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public SubjectEntity update(SubjectEntity subjectEntity) {
        log.debug("Request to save Subject: {}",subjectEntity);
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public Optional<SubjectEntity> partialUpdate(SubjectEntity subjectEntity) {
        log.debug("Request to partially update Subject : {}", subjectEntity);

        return subjectRepository
                .findById(subjectEntity.getId())
                .map(existingSubject -> {
                    if (subjectEntity.getName() != null){
                        existingSubject.setName(subjectEntity.getName());
                    }
                    if(subjectEntity.getDescript() != null){
                        existingSubject.setDescript(subjectEntity.getDescript());
                    }
                   return existingSubject;
                })
                        .map(subjectRepository::save);
    }
        @Autowired
        private EntityManager entityManager;
    @Override
    public List<SubjectEntity> findAll() {
            log.debug("Request to get all Subject");
            EntityTransaction transaction = entityManager.getTransaction();
            //important//
            transaction.begin();
            //insert //
            transaction.commit();

            transaction.rollback();
            return subjectRepository.findAll();
    }

    @Override
    public Optional<SubjectEntity> findOne(Long id) {
            log.debug("Request to get Subject :",id);
            return subjectRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
            log.debug("Request to delete Subject : {}",id);
            subjectRepository.deleteById(id);
        }

    }

