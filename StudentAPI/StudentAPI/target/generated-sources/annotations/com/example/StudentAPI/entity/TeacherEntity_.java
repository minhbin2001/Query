package com.example.StudentAPI.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeacherEntity.class)
public abstract class TeacherEntity_ {

	public static volatile SingularAttribute<TeacherEntity, String> password;
	public static volatile SingularAttribute<TeacherEntity, String> security_q;
	public static volatile SingularAttribute<TeacherEntity, String> security_a;
	public static volatile SingularAttribute<TeacherEntity, String> phone;
	public static volatile SetAttribute<TeacherEntity, SubjectEntity> likedSubject;
	public static volatile SingularAttribute<TeacherEntity, String> name;
	public static volatile SingularAttribute<TeacherEntity, StudentEntity> studentEntity;
	public static volatile SingularAttribute<TeacherEntity, Long> id;
	public static volatile SingularAttribute<TeacherEntity, String> email;

	public static final String PASSWORD = "password";
	public static final String SECURITY_Q = "security_q";
	public static final String SECURITY_A = "security_a";
	public static final String PHONE = "phone";
	public static final String LIKED_SUBJECT = "likedSubject";
	public static final String NAME = "name";
	public static final String STUDENT_ENTITY = "studentEntity";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}

