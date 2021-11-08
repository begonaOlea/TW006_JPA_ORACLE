package com.curso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		// TODO Auto-generated method stub
		return null;
	}

	public void modificar(Empleado e) {
		// TODO Auto-generated method stub

	}

	public void borrar(int id) {
		// TODO Auto-generated method stub

	}

	public Empleado getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
