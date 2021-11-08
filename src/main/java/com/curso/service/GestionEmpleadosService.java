package com.curso.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.curso.dao.EmpleadoDAO;
import com.curso.dao.EmpleadoJPADAO;
import com.curso.entidades.Empleado;

public class GestionEmpleadosService {
	
	
	public void incrementarSalario(List<Empleado> lista, double incremento) {
		
		//obtengo el ENTITY MANAGER
		EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		
		EmpleadoDAO dao = new EmpleadoJPADAO(em);
		//inicio transaccion
		EntityTransaction tx = em.getTransaction();
		try {	
			tx.begin();
	        for(Empleado aux: lista) {
	        	aux.setSalario(aux.getComision()+incremento);
	        	dao.modificar(aux);
	        }
			//commit o rollback
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}
	}
	
	public void altaEmpleado(String nombre, 
			String apellido, 
			String Telefono,
			String idJob, 
			int idManager) {
			
//		TX new
//		
//		Tabajo  t = em.find(Trabajo.class, idJob);
//		t.geSalMin();
//		
//		commit
		
	}
	
	
	public void informeEmpleados() {
	   EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		
		EmpleadoDAO dao = new EmpleadoJPADAO(em);
		
		List<Empleado> lista = dao.getAll();
		System.out.println("... lista ");
		for(Empleado e : lista) {
			System.out.println(". " + e.getId() + " " + e.getNombre());
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		GestionEmpleadosService service = new GestionEmpleadosService();
		service.informeEmpleados();
	}
	
	
	
	
	
}
