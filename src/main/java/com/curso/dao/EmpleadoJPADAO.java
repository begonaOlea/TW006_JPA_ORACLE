package com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.entidades.Empleado;

public class EmpleadoJPADAO implements EmpleadoDAO {


   public static EntityManagerFactory factory;
   private EntityManager em;
	
	
   static {
	   factory =  Persistence.createEntityManagerFactory("OracleHRPU");
   }
   
   public EmpleadoJPADAO(EntityManager em) {
	 this.em = em;
   }
	

	public Empleado crear(Empleado e) {
		em.persist(e);
		return e; //devuelvo e con el nuevo id autogenerado
	}

	public void modificar(Empleado e) {
		//antes de modificiar ver si existe
		Empleado eBD = em.find(Empleado.class, e.getId());
		if( eBD == null ) {
			throw new RuntimeException("No puedo modificar. Empleado no existe");
		}
		em.merge(e);
	}

	public void borrar(int id) {
		Empleado eBD = em.find(Empleado.class,id);
		if( eBD == null ) {
			throw new RuntimeException("No puedo borrar. Empleado no existe");
		}
		em.remove(eBD);
	}

	public Empleado getByID(int id) {
		Empleado eBD = em.find(Empleado.class,id);
		return eBD;
	}

	public List<Empleado> getAll() {
		//consulta
		//String consulta = "SELECT e from Empleado e";
		//Query query = em.createQuery(consulta);
		
		Query query = em.createNamedQuery("Empleado.findAll");
		return query.getResultList();
	}	
	
	
	
	
	
	
	
	
	
	
}
