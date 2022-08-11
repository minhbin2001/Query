package com.example.StudentAPI.controller;



import com.example.StudentAPI.entity.SubjectEntity;

import com.example.StudentAPI.repository.SubjectRepository;

import com.example.StudentAPI.service.SubjectService;
import com.example.StudentAPI.service.impl.SubjectServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class SubjectController {
    private SubjectRepository subjectRepository;
    private SubjectService subjectService;

    private final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);

    public SubjectController(SubjectService subjectService, SubjectRepository subjectRepository) {
        this.subjectService = subjectService;
        this.subjectRepository = subjectRepository;
    }


    @PostMapping("/subjects")
    public ResponseEntity<SubjectEntity> createSubject(@RequestBody SubjectEntity subjectEntity) throws URISyntaxException {
        log.debug("REST request to save Subject : {}", subjectEntity);
        SubjectEntity result = subjectService.save(subjectEntity);
        return ResponseEntity
                .created(new URI("/api/subjects/" + result.getId()))
                .body(result);
    }
    @PutMapping("/subjects/{id}")
    public ResponseEntity<SubjectEntity> updateSubject(@PathVariable(value = "id", required = false) final Long id, @RequestBody SubjectEntity subjectEntity)
            throws URISyntaxException {
        log.debug("REST request to update Subject : {}, {}", id, subjectEntity);
        SubjectEntity result = subjectService.update(subjectEntity);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PatchMapping(value = "/subjects/{id}")
    public ResponseEntity<Optional<SubjectEntity>> partialUpdate(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody SubjectEntity subjectEntity
    ) throws URISyntaxException {
        log.debug("REST request to partial update Subject partially : {}, {}", id, subjectEntity);

        Optional<SubjectEntity> result = subjectService.partialUpdate(subjectEntity);
        return ResponseEntity.ok()
                .body(result);
    }
    @GetMapping("/subjects")
    public List<SubjectEntity> getAllSubjects() {
        log.debug("REST request to get all Subject");
        return subjectService.findAll();
    }
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Optional<SubjectEntity>> getSubject(@PathVariable Long id) {
        log.debug("REST request to get Subject : {}", id);
        Optional<SubjectEntity> result = subjectService.findOne(id);
        return ResponseEntity.ok()
                .body(result);
    }
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        log.debug("REST request to delete Subject : {}", id);
        subjectService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}

