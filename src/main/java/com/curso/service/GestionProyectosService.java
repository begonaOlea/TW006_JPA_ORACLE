package com.curso.service;

import java.util.List;

import javax.persistence.EntityManager;
import com.curso.dao.FactoriaEntityManagersSingletone;
import com.curso.manytomany.*;

//rol service 
public class GestionProyectosService {
	
	
	
	public Project crearProyecto(String nombre){
		
		EntityManager em = FactoriaEntityManagersSingletone.getEntityManager();
		em.getTransaction().begin();
		
		Project p = new Project();
		p.setDescription(nombre);
		em.persist(p);
		
		em.getTransaction().commit();
		return p;
	}
	
	public Project getPorId(int id) {
		EntityManager em = FactoriaEntityManagersSingletone.getEntityManager();
		Project  p2 =  em.find(Project.class, id);
		return p2; //p2 es null si no lo encuentra
	}
	
	public void asignarTrabajadores(List<Worker> trabajadores, int idProyecto) {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
