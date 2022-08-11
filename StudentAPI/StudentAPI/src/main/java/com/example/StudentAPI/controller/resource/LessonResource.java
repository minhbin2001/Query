package com.example.StudentAPI.controller.resource;

import com.example.StudentAPI.dao.LessonDao;
import com.example.StudentAPI.entity.LessonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LessonResource {

    @Autowired
    private LessonDao lessonDao;

    @GetMapping("/lessonsrs/{id}")
    @ResponseBody
    public ResponseEntity findLesson(@PathVariable("id") Long id) {
        LessonEntity lessonEntity = lessonDao.findById(id);
        if (lessonEntity == null) {
            return new ResponseEntity("No Lesson found for ID" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lessonEntity,HttpStatus.OK);
    }
    @PutMapping("/lessonsrs/{id}")
    @ResponseBody
    public ResponseEntity updateProductName(@PathVariable Long id, @RequestBody LessonEntity lessonEntity){
        int count = lessonDao.updateName(id, lessonEntity);
        if (count ==0) {
            return new ResponseEntity(("No Lesson found for ID") + id, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity(lessonEntity,HttpStatus.OK);
    }
    @DeleteMapping("/lessonsrs/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Long id){
        lessonDao.delete(id);
        return new ResponseEntity("lesson with"+ id + "deleted",HttpStatus.OK);
    }
@PostMapping("/lessonsrs")
@ResponseBody
public ResponseEntity create(@RequestBody LessonEntity lessonEntity){
        LessonEntity ex = lessonDao.save(lessonEntity);
        return new ResponseEntity(lessonEntity,HttpStatus.OK);
}

}