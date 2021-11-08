package com.curso.jpa.jpa;

import javax.persistence.*;

import com.curso.entidades.Trabajo;

public class PruebaJPATrabajo {
	
	private static EntityManager em;

	public static void main(String[] args) {
		
		EntityManagerFactory factory =  
				Persistence.createEntityManagerFactory("OracleHRPU");
		
		em = factory.createEntityManager();  //lee en persistence.xml 
											 //datos conexión y entidades
		
		
		//recuperar un Job para el id (PK) 'AD_PRES'
		
		
		Trabajo t = em.find(Trabajo.class, "AD_PRES");
		if( t != null)
			System.out.println("titulo es  " + t.getTitulo());
		else
			System.out.println("El trabajo con id AD_PRES no existe");
		
		
		//t esta attached con la tabal  JOBS
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		t.setTitulo("Presidente");
		
		
		tx.commit();
		
		//insertar un nuevo trabajo
		
//		Trabajo tNew = new Trabajo("DES","Desarrollo",24000,50000);
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		
//		em.persist(tNew);
//		
//		tx.commit();
//		
		
		// t y tNew  ahora estan sincronizados
		
	
		
		//obj no ATTACHED
		//20080   40000
		Trabajo presi = new Trabajo("AD_PRES","Presidente",0,0);
		
		
		//Modificar datos
		//modo 1
		tx.begin();
		
		Trabajo tBD = em.find(Trabajo.class, presi.getIdTrabajo());
		
		tBD.setSalarioMax(presi.getSalarioMax());
		tBD.setSalarioMin(presi.getSalarioMin());
		
	
		tx.commit();
		
		//modo 2  em.merge();
		
		tx.begin();
		//HR NO ATTACHED
		Trabajo hr = new Trabajo("HR_REP","Represesntante RRRHH",4500,10000);
		
		Trabajo hrBD = em.merge(hr);
		
		//hr.setSalarioMax(0); // no hay sinc con bd
		//hrBD.setSalarioMax(45000); //si sinc con bd
		
		tx.commit();
		
		//borrar
		tx.begin();
		Trabajo tBorrar =new Trabajo("HR_REP","Represesntante RRRHH",4500,10000);
				//em.find(Trabajo.class,"DES");
		em.remove(tBorrar);
		tx.commit();
		
		
	}//fin main
	

}
