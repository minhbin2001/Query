package com.example.StudentAPI.controller;

import com.example.StudentAPI.entity.LessonEntity;
import com.example.StudentAPI.entity.StudentEntity;
import com.example.StudentAPI.repository.StudentRepository;
import com.example.StudentAPI.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController implements ApiBaseController {
    private final StudentService studentService;
    private StudentRepository studentRepository;
    private final Logger log = LoggerFactory.getLogger(StudentController.class);

  public StudentController(StudentService studentService,StudentRepository studentRepository){
      this.studentRepository = studentRepository;
      this.studentService = studentService;
  }
    @PostMapping("/students")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) throws URISyntaxException {
        log.debug("REST request to save Student : {}", studentEntity);
        StudentEntity result = studentService.save(studentEntity);
        return ResponseEntity
                .created(new URI("/api/students/" + result.getId()))
                .body(result);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentEntity> updateLesson(@PathVariable(value = "id", required = false) final Long id, @RequestBody StudentEntity studentEntity)
            throws URISyntaxException {
        log.debug("REST request to update Student : {}, {}", id, studentEntity);
        StudentEntity result = studentService.update(studentEntity);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PatchMapping(value = "/students/{id}")
    public ResponseEntity<Optional<StudentEntity>> partialUpdate(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody StudentEntity studentEntity
    ) throws URISyntaxException {
        log.debug("REST request to partial update Students partially : {}, {}", id, studentEntity);

        Optional<StudentEntity> result = studentService.partialUpdate(studentEntity);
        return ResponseEntity.ok()
                .body(result);
    }
    @GetMapping("/students")
    public List<StudentEntity> getAllLessons() {
        log.debug("REST request to get all Students");
        return studentService.findAll();
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<StudentEntity>> getLesson(@PathVariable Long id) {
        log.debug("REST request to get Students : {}", id);
        Optional<StudentEntity> result = studentService.findOne(id);
        return ResponseEntity.ok()
                .body(result);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        log.debug("REST request to delete Students : {}", id);
        studentService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
