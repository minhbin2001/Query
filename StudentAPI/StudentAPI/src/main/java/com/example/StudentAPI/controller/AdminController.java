package com.example.StudentAPI.controller;


import com.example.StudentAPI.entity.AdminEntity;

import com.example.StudentAPI.repository.AdminRepository;
import com.example.StudentAPI.service.AdminService;
import com.example.StudentAPI.service.impl.AdminServiceImpl;
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
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    private AdminService adminService;

    private final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    public AdminController(AdminService adminService,AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.adminService = adminService;
    }
    @PostMapping("/admins")
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity adminEntity) throws URISyntaxException {
        log.debug("REST request to save Admin : {}", adminEntity);
        AdminEntity result = adminService.save(adminEntity);
        return ResponseEntity
                .created(new URI("/api/admins/" + result.getId()))
                .body(result);
    }
    @PutMapping("/admins/{id}")
    public ResponseEntity<AdminEntity> updateAdmin(@PathVariable(value = "id", required = false) final Long id, @RequestBody AdminEntity adminEntity)
            throws URISyntaxException {
        log.debug("REST request to update Student : {}, {}", id, adminEntity);
        AdminEntity result = adminService.update(adminEntity);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PatchMapping(value = "/admins/{id}")
    public ResponseEntity<Optional<AdminEntity>> partialUpdate(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody AdminEntity adminEntity
    ) throws URISyntaxException {
        log.debug("REST request to partial update Lessons partially : {}, {}", id, adminEntity);

        Optional<AdminEntity> result = adminService.partialUpdate(adminEntity);
        return ResponseEntity.ok()
                .body(result);
    }
    @GetMapping("/admins")
    public List<AdminEntity> getAllAdmins() {
        log.debug("REST request to get all Admins");
        return adminService.findAll();
    }
    @GetMapping("/admins/{id}")
    public ResponseEntity<Optional<AdminEntity>> getAdmin(@PathVariable Long id) {
        log.debug("REST request to get Admins : {}", id);
        Optional<AdminEntity> result = adminService.findOne(id);
        return ResponseEntity.ok()
                .body(result);
    }
    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        log.debug("REST request to delete Admins : {}", id);
        adminService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
