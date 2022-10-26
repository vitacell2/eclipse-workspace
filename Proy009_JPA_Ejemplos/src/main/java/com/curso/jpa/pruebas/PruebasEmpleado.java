package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Empleado;

public class PruebasEmpleado {

	public static void main(String[] args)
	{
		//1. crear la factoria de EM
		   //2. crear un Em
		  // 3. crear una transaccion
		 //   4. crear un EMpleado nuevo  
		    //5. perisistirlo en bd
			//6  confirmar transaccion si ok rollback si fallo
			
			//1. Crear una Factoria de Entiny Manager
			EntityManagerFactory myFactoryEntMan =
							Persistence.createEntityManagerFactory("OraceHRPU");
					
			//2. Obtenemos un Entity Manager 
			EntityManager myEntMan = myFactoryEntMan.createEntityManager();
		
		
		
			// 3. Transaccion
			myEntMan.getTransaction().begin();
			
		try
		{
			Empleado myEmpleado = new Empleado();
			
			myEmpleado.setNombre ("Luis");
			myEmpleado.setApellidos ("Ramos");
			myEmpleado.setFechaContratacion (new java.util.Date());
			myEmpleado.setIdDepartamento(10);
			myEmpleado.setIdTrabajo("ST_MAN");
			myEmpleado.setEmail("luis.ramos@curso.es");
			
			myEntMan.persist(myEmpleado);
			
			System.out.println("Creo el empleado. Nuevo id: " + myEmpleado.getId());
			
			myEntMan.getTransaction().commit();
		}
		catch (Exception e) 
		{
			myEntMan.getTransaction().rollback();
		}
		
		
	}
	
}
