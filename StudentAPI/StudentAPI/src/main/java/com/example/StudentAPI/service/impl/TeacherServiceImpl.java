package com.example.StudentAPI.service.impl;

import com.example.StudentAPI.dto.TeacherRequestDTO;
import com.example.StudentAPI.dto.TeacherResponseDTO;
import com.example.StudentAPI.entity.TeacherEntity;
import com.example.StudentAPI.repository.TeacherRepository;
import com.example.StudentAPI.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void update(TeacherRequestDTO teacherUpdate, long id) {
        TeacherEntity oldTeacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        // Gán dữ liệu từ teacherUpdate sang Entity ...

        log.debug("Request to save Teacher: {}",teacherUpdate);

        teacherRepository.save(oldTeacher);
    }

    @Override
    public Optional<TeacherEntity> partialUpdate(TeacherEntity teacherEntity) {
        log.debug("Request to partially update: {} ",teacherEntity);
        return teacherRepository
                .findById(teacherEntity.getId())
                .map(existingTeacher ->{
                    if(teacherEntity.getName() != null){
                        existingTeacher.setName(teacherEntity.getName());
                    }
                    if(teacherEntity.getPassword() !=null){
                        existingTeacher.setPassword(teacherEntity.getPassword());
                    }
                    if(teacherEntity.getEmail() !=null){
                        existingTeacher.setEmail(teacherEntity.getEmail());
                    }
                    return existingTeacher;
                })
                .map(teacherRepository::save);
    }

    @Override
    public TeacherResponseDTO getById(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public TeacherResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public TeacherEntity save(TeacherEntity teacherEntity) {
            log.debug("Request to save Teacher: {}", teacherEntity);
            return teacherRepository.save(teacherEntity);
        }

    @Override public TeacherResponseDTO findAll(){
        log.debug("Request to get all Teachers");
       return null;
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Teacher: {}",id);
        teacherRepository.deleteById(id);

    }
}



