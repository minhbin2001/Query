package com.example.StudentAPI.dao;

import com.example.StudentAPI.entity.LessonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class LessonDao {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager em;

    public LessonEntity findById(Long id){
        return em.find(LessonEntity.class, id);
    }
    public int updateName(Long id,LessonEntity lessonEntity){
        try{
            int executeUpdate = em.createQuery("UPDATE LessonEntity o SET o.name=?1,o.classroom=?2,o.time_start=?3,o.time_end=?4 WHERE o.id=?5")
                    .setParameter(1,lessonEntity.getName())
                    .setParameter(2,lessonEntity.getClassroom())
                    .setParameter(3,lessonEntity.getTime_start())
                    .setParameter(4,lessonEntity.getTime_end())
                    .setParameter(5, id)
                    .executeUpdate();
        return executeUpdate;
    }catch (Exception ex){
            ex.getStackTrace();
        }
        return 0;
    }
    public List<LessonEntity> getList(Integer start, Integer max) {
        List<LessonEntity> finalList = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT c FROM LessonEntity c WHERE c.id > 0 ORDER BY c.id DESC");
            if (start != null) {
                query.setFirstResult(start);
            }
            if (max != null) {
                query.setMaxResults(max);
            }
            if (!query.getResultList().isEmpty()) {
                finalList = query.getResultList();
            }
        }catch (Exception e){

            }
        return finalList;
        }
public LessonEntity save(LessonEntity lessonEntity){
        if(lessonEntity.getId() == null) {
            em.persist(lessonEntity);
        }else {
            em.persist(lessonEntity);
        }
        return lessonEntity;
}
public void delete(Long id){
        LessonEntity lessonEntity = findById(id);
        em.remove(lessonEntity);
}
    }

