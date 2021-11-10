package com.curso.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.dao.EmpleadoJPADAO;
import com.curso.otras.*;

public class PruebasRegionLocalidadPais {

	
	public static void main(String[] args) {
		
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
		
//		//buscar una localidad 
//		Localidad l = em.find(Localidad.class, 1000L);
//		System.out.println(  l.getCity());
//		
//		System.out.println(l.getCountry().getCountryName());
//		
		
		Query query = em.createQuery("SELECT r FROM Region r");
		List<Region> regiones = query.getResultList();
		
		if(regiones.size() == 0 ) {
			System.out.println("No hay regiones ");
		}
		  
		for(Region r : regiones) {
			System.out.println( r.getRegionName());
			for(Pais p : r.getCountries()) {
				System.out.println("    ." + p.getCountryName());
				for(Localidad l : p.getLocations()) {
					System.out.println("        * " + l.getCity());
				}
			}
		}
		 
		 
		
	}
}
