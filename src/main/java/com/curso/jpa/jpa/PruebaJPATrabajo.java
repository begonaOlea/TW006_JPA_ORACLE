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
		
		//  em.find(Clase, PK) devuelve un objeto con los datos de la bd
		Trabajo t = em.find(Trabajo.class, "AD_PRES");  //SELECT
		
		if( t != null)
			System.out.println("titulo es  " + t.getTitulo());
		else
			System.out.println("El trabajo con id AD_PRES no existe");
		
		
		
		//t esta attached con la table  JOBS
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		t.setTitulo("Presidente"); //si t le cambio valores cuando haga commit 
									//los modif en la bd
		
		
		tx.commit(); //UPDATE
		
		//insertar un nuevo trabajo
		
		Trabajo tNew = new Trabajo("DESNUEVO","Desarrollo nuevo",24000,50000);
		
		//EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(tNew); 
		
		tx.commit();  // INSERT CONTRA LA BD
		
		
		// t y tNew  ahora estan sincronizados
		
	
		
		//obj no ATTACHED  - NO ESTÁ SINCRONIZdo con la bd
		//20080   40000
		Trabajo presi = new Trabajo("AD_PRES","Presidente",0,0);
		
		//Modificar datos
		//modo 1
		tx.begin();
		
		Trabajo tBD = em.find(Trabajo.class, presi.getIdTrabajo());
		
		tBD.setSalarioMax(presi.getSalarioMax());
		tBD.setSalarioMin(presi.getSalarioMin());
		
	
		tx.commit(); //si cambia update contra la bd
		
		//modo 2  em.merge();
		
		tx.begin();
		//HR NO ATTACHED
		//hay en bd un registro con id HR_REP
		// pero quiero modif sus datos
		Trabajo hr = new Trabajo("HR_REP","Representante RRRHH",4500,10000);
		
		Trabajo hrBD = em.merge(hr); //UPDATE CONTRA LA BD
		
		//hr.setSalarioMax(0); // no hay sinc con bd
		//hrBD.setSalarioMax(45000); //si sinc con bd
		
		tx.commit();
		
		//borrar
		tx.begin();
		Trabajo tBorrar = //new Trabajo("HR_REP","Represesntante RRRHH",4500,10000);
				em.find(Trabajo.class,"HR_REP");
		em.remove(tBorrar); //tBorrar esta ATTACHED  (em find o persis, merege)
		tx.commit();  // delete  
		
		
	}//fin main
	

}
