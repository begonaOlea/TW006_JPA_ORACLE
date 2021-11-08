package com.curso.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.curso.dao.EmpleadoDAO;
import com.curso.dao.EmpleadoJPADAO;
import com.curso.entidades.Empleado;

public class GestionEmpleadosService {
	
	
	public void incrementarSalario() {
		
		//obtengo el ENTITY MANAGER
		EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		
		EmpleadoDAO dao = new EmpleadoJPADAO(em);
		
		//inicio transaccion
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//hago varios cambios de varios empleaso
//		dao.crear(new Empleado());
//		Empleado e = dao.getByID(100);
//		e.setApellidos("otro");
//		dao.modificar(e);
		
		
		
		//commit o rollback
		tx.commit();
		
	}

}
