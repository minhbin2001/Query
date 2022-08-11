package com.example.StudentAPI.controller;

import com.example.StudentAPI.entity.LessonEntity;
import com.example.StudentAPI.repository.LessonRepository;
import com.example.StudentAPI.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;
    private LessonService lessonService;


    private final Logger log = LoggerFactory.getLogger(LessonController.class);

    private static final String ENTITY_NAME = "lesson";

    public LessonController(LessonService lessonService, LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
        this.lessonService = lessonService;
    }
    @PostMapping("/lessons")
    public ResponseEntity<LessonEntity> createStudent(@RequestBody LessonEntity lessonEntity) throws URISyntaxException {
        log.debug("REST request to save Student : {}", lessonEntity);
        LessonEntity result = lessonService.save(lessonEntity);
        return ResponseEntity
                 .created(new URI("/api/lessons/" + result.getId()))
                .body(result);
    }
    @PutMapping("/lessons/{id}")
    public ResponseEntity<LessonEntity> updateLesson(@PathVariable(value = "id", required = false) final Long id, @RequestBody LessonEntity lessonEntity)
            throws URISyntaxException {
        log.debug("REST request to update Student : {}, {}", id, lessonEntity);
        LessonEntity result = lessonService.update(lessonEntity);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PatchMapping(value = "/lessons/{id}")
    public ResponseEntity<Optional<LessonEntity>> partialUpdate(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody LessonEntity lessonEntity
    ) throws URISyntaxException {
        log.debug("REST request to partial update Lessons partially : {}, {}", id, lessonEntity);

        Optional<LessonEntity> result = lessonService.partialUpdate(lessonEntity);
        return ResponseEntity.ok()
                .body(result);
    }
    @GetMapping("/lessons")
    public List<LessonEntity> getAllLessons() {
        log.debug("REST request to get all Lessons");
        return lessonService.findAll();
    }
    @GetMapping("/lessons/{id}")
    public ResponseEntity<Optional<LessonEntity>> getLesson(@PathVariable Long id) {
        log.debug("REST request to get Lessons : {}", id);
        Optional<LessonEntity> result = lessonService.findOne(id);
        return ResponseEntity.ok()
                .body(result);
    }
    @DeleteMapping("/lessons/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        log.debug("REST request to delete Lessons : {}", id);
        lessonService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}



