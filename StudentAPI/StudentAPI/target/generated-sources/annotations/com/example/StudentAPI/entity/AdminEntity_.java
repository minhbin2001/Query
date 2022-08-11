package com.example.StudentAPI.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AdminEntity.class)
public abstract class AdminEntity_ {

	public static volatile SingularAttribute<AdminEntity, String> password;
	public static volatile SingularAttribute<AdminEntity, Long> id;
	public static volatile SingularAttribute<AdminEntity, String> username;

	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String USERNAME = "username";

}

