package com.curso.service;

import java.util.ArrayList;
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
	
	public void asignarTrabajadores( int idProyecto, Worker... trabajadores) {
		EntityManager em = FactoriaEntityManagersSingletone.getEntityManager();
		em.getTransaction().begin();
		
		Project  p = getPorId(idProyecto);
		if(p !=null ) {
			if(p.getWorkers() == null ) p.setWorkers(new ArrayList());
			
			for(Worker w : trabajadores) {
				p.getWorkers().add(w);
			}
		}
		em.merge(p);
		
		em.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		
		GestionProyectosService service = new GestionProyectosService();
		
		Project nuevo = service.crearProyecto("Configuracion e");
		Worker w1 = new Worker(12);
		Worker w2 = new Worker(13);
		
		service.asignarTrabajadores(nuevo.getId(), w1, w2);
		
	}

	

}
