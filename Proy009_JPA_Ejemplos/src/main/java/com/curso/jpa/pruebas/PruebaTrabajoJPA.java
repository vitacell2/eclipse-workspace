package com.curso.jpa.pruebas;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.jpa.entidades.Trabajo;

public class PruebaTrabajoJPA {

	public static void main(String[] args)
	{
		// 1. Crear una factoria de Entity Manager
		EntityManagerFactory myEntFactory =
				Persistence.createEntityManagerFactory("OracleHRPU");
		
		
		
		// 2. Obtenemos un Entity Manager que conecta con HR de Oracle y mapea clases entidad
		EntityManager myEntMan = myEntFactory.createEntityManager();
		
		
		
		// 3. Obtener el trabajo con el id "AD_VP"
		Trabajo myTrabajo = myEntMan.find(Trabajo.class, "AD_VP");
		
			// por si nos da null
			if (myTrabajo == null)
			{
				System.out.println("No existe el trabajo AD_VP");
			}
			else
			{
				System.out.println(myTrabajo);
			}
		
		
		
		// 4. Crear un trabajo
		Trabajo myTrabNuevo = new Trabajo("BE_OL", "Tareas super Dificiles", 33000.0, 53000.0);
		
		// inicia una nueva transaccional
		myEntMan.getTransaction().begin();
		
		// INSERT
		//myEntMan.persist(myTrabNuevo);
		
		// obtiene la transaccion y la confirma
		myEntMan.getTransaction().commit();
		
		// 5. Modificacion
		Trabajo myTrabNuevoModificado = new Trabajo ("PR_REP",
				"Tareas Super Dificiles de verdad", 
				33000.0, 53000.0);
		
		
		
		// 5.1. Modo 1 - modificar despues de un find
		Trabajo myTrabDesdeDB = myEntMan.find(Trabajo.class, myTrabNuevoModificado.getId());
		
		myTrabDesdeDB.setTituloTrabajo(myTrabNuevoModificado.getTituloTrabajo());
		myEntMan.getTransaction().commit();
		
		// 5.2 Modo 2 - modificar myEntMan.merge
		Trabajo myOtraVezTrabajoModificar = new Trabajo ("BE_OL",
				"Tareas Super Dificiles de verdad *", 
				33000.0, 53000.0);
		
		myEntMan.getTransaction().begin();
		Trabajo myTrabEnDB = myEntMan.merge(myOtraVezTrabajoModificar);
		
		// myOtraVezTrabajoModificar no esta attached contra la DB
		myOtraVezTrabajoModificar.setTituloTrabajo("setTituloTrabajo");
		
		// myTrabEnDB si esta sincronizado con la DB
		myTrabEnDB.setTituloTrabajo("Este si esta attached");
		
		myEntMan.getTransaction().commit(); // -> update
		System.out.println("... despues commit");
		
		
		
		// 6. Borrar
		myEntMan.getTransaction().begin();
		
		Trabajo myTrabAborrar = new Trabajo();
		myTrabAborrar.setId("BE_OL");
		
		// find object
		Trabajo myTrabDB = myEntMan.find(Trabajo.class, myTrabAborrar.getId());
		
		// remove
		myEntMan.remove(myTrabAborrar);
		myEntMan.getTransaction().commit();
		
		
		
		// 7. consulta JPAQueary
		Query myConsulta = myEntMan.createQuery("SELECT t FROM TRABAJO t"); // traeme objetos de tipo trabajo
		
		Collection<Trabajo> myLista = myConsulta.getResultList();
		System.out.println("... lista de trabajos");
		
		for (Trabajo trab : myLista)
		{
			System.out.println(trab);
		}
		
	}

}
