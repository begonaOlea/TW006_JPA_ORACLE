package com.curso.pruebas;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.manytomany.*;

public class PruebasManyToMany {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
		
		em.getTransaction().begin();
		
		//crear 3 trabajadores
		Worker w1 = new Worker();
		w1.setName("Luis Ramos");
		
		em.persist(w1);
		
		Worker w2 = new Worker();
		w2.setName("Laura Roca");
		
		em.persist(w2);
		
		Worker w3 = new Worker();
		w3.setName("Kepa Zostr");
		
		em.persist(w3);
		
		//crear 1 proyecto
		//añadir 2 trabajadores al proyecto
		
		Project p = new Project();
		p.setDescription("Desarrollo Angular ");
	
		em.persist(p);
	
		p.setWorkers(new ArrayList<Worker>());
		p.getWorkers().add(w1);
		p.getWorkers().add(w2);
		
		
		//añado 1 trabaj mas
		  //pendiente luego
		
		em.getTransaction().commit();
	}

}
