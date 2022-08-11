package com.example.StudentAPI.controller;


import com.example.StudentAPI.dto.TeacherRequestDTO;
import com.example.StudentAPI.dto.TeacherResponseDTO;
import com.example.StudentAPI.entity.TeacherEntity;
import com.example.StudentAPI.repository.TeacherRepository;
import com.example.StudentAPI.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
@RequestMapping("/api")
public class TeacherController {
    private TeacherRepository teacherRepository;
    private TeacherService teacherService;

    public TeacherController(TeacherRepository teacherRepository, TeacherService teacherService) {
        this.teacherRepository = teacherRepository;
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<?> findAll() {
        TeacherResponseDTO result;
        try {
            result = teacherService.findAll();
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        TeacherResponseDTO result;
        try {
            result = teacherService.getById(id);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<String> updateTeacher(@PathVariable(value = "id", required = false) final Long id,
                                                       @RequestBody TeacherRequestDTO teacherRequestDTO) {
        try {
            teacherService.update(teacherRequestDTO, id);
            return ResponseEntity
                    .ok()
                    .body("UPDATED");
        } catch (Exception ex) {
            return new ResponseEntity<>("INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/teachers")
    public TeacherEntity changeTeacher(@RequestBody TeacherEntity newTeacherEntity) {
        return teacherRepository.save(newTeacherEntity);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}

