package com.curso.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.curso.dao.EmpleadoDAO;
import com.curso.dao.EmpleadoJPADAO;
import com.curso.entidades.Customer;
import com.curso.entidades.Orders;
import com.curso.entidades.Record;

public class PruebaMapeos {
	
	public static void main(String[] args) {
		
	   EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
	  
//	   EntityTransaction tx = em.getTransaction();
//	   tx.begin();
//	   //CREAR UN NUEVO REGISTRO
//	   Record rec = new Record();
//	   rec.setRecordName("REGISTOR 1");
//	   
//	   em.persist(rec);
//	   
//	   //CREAR UN NUEVO CLIENTE CON EL REG CREADO
//	   
//	   Customer cliente = new Customer();
//	   cliente.setCustomerName("Luis Ramos");
//	   cliente.setRecord(rec);
//	   
//	   em.persist(cliente);
//	   
//	   tx.commit();
//	   
	   
	   
	   //BUSCAR EL CLIENTE
	   Customer cliente2 = em.find(Customer.class, 4);
	   if(cliente2 == null) {
		   System.out.println("no existe");
		   return;
	   }
	   
	   System.out.println(cliente2.getCustomerName());
	   System.out.println(cliente2.getRecord().getRecordName());
	   
	   System.out.println("----- por record ----");
		Record r = em.find(Record.class, 3);
		if(r !=null) {
			System.out.println(r.getRecordName());
			System.out.println(r.getCliente().getCustomerName());
		}
	   
	   
		//ejemplo mappeo  ONE TO MANY - MANY TO ONE
		
		//CREAR DOS PEDIDOS PARA EL CLIENTE id 4
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		Customer c4  = em.find(Customer.class, 4);
		
		if( c4 != null) {
			
//			//hago pedido
//			Orders o1 = new Orders();
//			
//			o1.setCustomer(c4);
//			o1.setDescription("Pedido zapatos");
//			em.persist(o1);
//			
//			Orders o2 = new Orders();
//			
//			o2.setCustomer(c4);
//			o2.setDescription("Pedido libros");
//			em.persist(o2);
			
			//mostrar los pedidos del cliente
			
			for(Orders o: c4.getOrdersCollection()) {
				System.out.println(o.getDescription());
			}
			
		}
				
				
				
	    tx.commit();	
		
	}	

}
