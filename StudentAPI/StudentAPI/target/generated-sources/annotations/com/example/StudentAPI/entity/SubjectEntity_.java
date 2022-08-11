package com.example.StudentAPI.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SubjectEntity.class)
public abstract class SubjectEntity_ {

	public static volatile SingularAttribute<SubjectEntity, String> name;
	public static volatile SingularAttribute<SubjectEntity, Long> id;
	public static volatile SingularAttribute<SubjectEntity, String> descript;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String DESCRIPT = "descript";

}

