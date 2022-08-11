package com.example.StudentAPI.service.impl;


import com.example.StudentAPI.entity.LessonEntity;
import com.example.StudentAPI.repository.LessonRepository;
import com.example.StudentAPI.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

@Service("LessonServiceImpl")
@Transactional
public class LessonServiceImpl implements LessonService {

    private final Logger log = LoggerFactory.getLogger(LessonServiceImpl.class);

private final LessonRepository lessonRepository;

public LessonServiceImpl(LessonRepository lessonRepository)
{
    this.lessonRepository = lessonRepository;}

    @Override
    public LessonEntity save(LessonEntity lessonEntity) {
    log.debug("Request to save Lesson: {}",lessonEntity);
        return lessonRepository.save(lessonEntity);
    }

    @Override
    public LessonEntity update(LessonEntity lessonEntity) {
        log.debug("Request to save Lesson: {}",lessonEntity);
        return lessonRepository.save(lessonEntity);
    }

    @Override
    public Optional<LessonEntity> partialUpdate(LessonEntity lessonEntity) {
       log.debug("Request to partially update Lesson : {}", lessonEntity);

       return lessonRepository
               .findById(lessonEntity.getId())
               .map(existingLesson -> {
                   if (lessonEntity.getClassroom() != null) {
                       existingLesson.setClassroom(lessonEntity.getClassroom());
                   }
                   if (lessonEntity.getName() != null) {
                       existingLesson.setName(lessonEntity.getName());
                   }
                   if (lessonEntity.getTime_end() != null) {
                       existingLesson.setTime_end(lessonEntity.getTime_end());
                   }
                   if (lessonEntity.getTime_start() != null) {
                       existingLesson.setTime_start(lessonEntity.getTime_start());
                   }
                   return existingLesson;
               })
                       .map(lessonRepository::save);
    }
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<LessonEntity> findAll() {
        log.debug("Request to get all Lesson");
        EntityTransaction transaction = entityManager.getTransaction();
        //important//
        transaction.begin();
        //insert //
        transaction.commit();

        transaction.rollback();
        return lessonRepository.findAll();
    }


    @Override
    public Optional<LessonEntity> findOne(Long id) {
        log.debug("Request to get Lesson :",id);
        return lessonRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Lesson : {}",id);
        lessonRepository.deleteById(id);

    }
}