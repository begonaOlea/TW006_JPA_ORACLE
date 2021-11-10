package com.curso.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.print.attribute.SetOfIntegerSyntax;

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
	
	
	public List<Empleado> getAllEmpleadoPorDpto(int idDepartamento){
		
		 EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		 Query query = em.createNamedQuery("Empleado.findAllByIdDept");
		 //pasar parametro
		 query.setParameter("id", idDepartamento);
		 return query.getResultList();
		
	}
	
	public List<Empleado> getEmpleadosParaListar(){
		
		 EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		 Query query = em.createNamedQuery("Empleado.findAllDatosBasicos");
		 return query.getResultList();
	}

	public static void main(String[] args) {
		
		GestionEmpleadosService service = new GestionEmpleadosService();
		service.informeEmpleados();

		List<Empleado> empleadosDptoAdm = service.getAllEmpleadoPorDpto(10);
		
		for(Empleado e : empleadosDptoAdm) {
			System.out.println(". " + e.getId() + " " + e.getNombre() 
			+ " - " + e.getEmail());
		}
		
		System.out.println("----  lista empleados --- ");	
		
		List<Empleado> lista = service.getEmpleadosParaListar();
		for(Empleado e :lista) {
			System.out.println(". " + e.getId() + " " + e.getNombre() 
			+ " - " + e.getEmail());
		}
	}
	
	
	
	
	
	
	
}
