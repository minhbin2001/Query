package com.example.StudentAPI.entity;

import com.example.StudentAPI.entity.enumaration.degree;
import com.example.StudentAPI.entity.enumaration.gender;
import com.example.StudentAPI.entity.enumaration.semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentEntity.class)
public abstract class StudentEntity_ {

	public static volatile SingularAttribute<StudentEntity, gender> gender;
	public static volatile SingularAttribute<StudentEntity, String> phone;
	public static volatile SingularAttribute<StudentEntity, String> dob;
	public static volatile SingularAttribute<StudentEntity, String> name;
	public static volatile SingularAttribute<StudentEntity, degree> degree;
	public static volatile SingularAttribute<StudentEntity, semester> semester;
	public static volatile SetAttribute<StudentEntity, LessonEntity> likedLessons;
	public static volatile SingularAttribute<StudentEntity, Long> id;
	public static volatile SetAttribute<StudentEntity, SubjectEntity> likedSubjects;
	public static volatile SingularAttribute<StudentEntity, String> email;

	public static final String GENDER = "gender";
	public static final String PHONE = "phone";
	public static final String DOB = "dob";
	public static final String NAME = "name";
	public static final String DEGREE = "degree";
	public static final String SEMESTER = "semester";
	public static final String LIKED_LESSONS = "likedLessons";
	public static final String ID = "id";
	public static final String LIKED_SUBJECTS = "likedSubjects";
	public static final String EMAIL = "email";

}

