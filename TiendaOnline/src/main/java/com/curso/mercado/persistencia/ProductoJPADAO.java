package com.curso.mercado.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.mercado.entidades.Producto;

public class ProductoJPADAO implements GenericDAO<Producto>
{
	// 1. Crear una factoria de Entity Manager
	private static EntityManagerFactory myEntManFact;
	
	static
	{
		myEntManFact = Persistence.createEntityManagerFactory("OracleHRPU");
	}
	
	// 2. Obtenemos un Entity Manager que conecta con HR de Oracle y mapea clases entidad
			EntityManager myEntMan = myEntManFact.createEntityManager();
	
	@Override
	public void add(Producto entidad)
	{
		myEntMan.getTransaction().begin();
		myEntMan.persist(entidad);
		myEntMan.getTransaction().rollback();
	}

	@Override
	public List<Producto> getAll()
	{
		
		
		return null;
	}

	@Override
	public Producto getByID(int id)
	{
		return null;
	}

	@Override
	public void delete(int id)
	{
		
	}

	@Override
	public void update(Producto entidad)
	{
		
	}
	
}
