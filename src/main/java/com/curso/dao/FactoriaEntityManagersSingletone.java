package com.curso.dao;

import javax.persistence.*;
public class FactoriaEntityManagersSingletone {
	
	private static EntityManagerFactory instance;
	
	private FactoriaEntityManagersSingletone() {	
	}
	
	public static EntityManager getEntityManager() {
		if(instance == null) {
			instance =  Persistence.createEntityManagerFactory("OracleHRPU");
		}
		return instance.createEntityManager();
	}
	

}
