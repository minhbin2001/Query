package com.example.StudentAPI.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LessonEntity.class)
public abstract class LessonEntity_ {

	public static volatile SingularAttribute<LessonEntity, String> time_start;
	public static volatile SingularAttribute<LessonEntity, TeacherEntity> teacherEntity;
	public static volatile SingularAttribute<LessonEntity, String> name;
	public static volatile SingularAttribute<LessonEntity, String> classroom;
	public static volatile SingularAttribute<LessonEntity, Long> id;
	public static volatile SingularAttribute<LessonEntity, String> time_end;

	public static final String TIME_START = "time_start";
	public static final String TEACHER_ENTITY = "teacherEntity";
	public static final String NAME = "name";
	public static final String CLASSROOM = "classroom";
	public static final String ID = "id";
	public static final String TIME_END = "time_end";

}

