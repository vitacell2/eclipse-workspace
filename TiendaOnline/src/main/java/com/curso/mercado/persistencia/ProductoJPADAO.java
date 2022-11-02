package com.curso.mercado.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.mercado.entidades.ProductoJPA;

public class ProductoJPADAO implements GenericDAO<ProductoJPA>
{
	// 1. Crear una factoria de Entity Manager
	private static EntityManagerFactory myEntManFact;
	
	static
	{
		myEntManFact = Persistence.createEntityManagerFactory("OracleHRPU");
	}
	
	// 2. Obtenemos un Entity Manager que conecta con HR de Oracle y mapea clases entidad
			EntityManager myEntMan = myEntManFact.createEntityManager();
	
			
			
	// AGREGAR UN PRODUCTO NUEVO CON JPA
	@Override
	public void add(ProductoJPA entidad)
	{
		try
		{
			myEntMan.getTransaction().begin();
			myEntMan.persist(entidad);
			myEntMan.getTransaction().commit();
		}
		catch(Exception e)
		{
			myEntMan.getTransaction().rollback();
		}
	}

	
	
	// OBTENER TODA LA LISTA DE PRODUCTOS (listar)
	@Override
	public List<ProductoJPA> getAll()
	{
		Query q = myEntMan.createQuery("SELECT myProducto FROM Producto myProducto");
		List<ProductoJPA> lista  = q.getResultList();
		return lista;
	}

	
	
	// OBTENER PRODUCTO POR SU ID
	@Override
	public ProductoJPA getByID(int id)
	{
		ProductoJPA myProducto = null; // ahora no contiene nada
		try
		{
			myEntMan.getTransaction().begin(); // comenzar la transaccion
			myProducto = myEntMan.find(ProductoJPA.class, id); // encontrar el objeto
			myEntMan.getTransaction().commit();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			myEntMan.getTransaction().rollback();
		}
		return myProducto;
	}

	
	
	// ELIMINAR UN PRODUCTO DE LA BASE DE DATOS
	@Override
	public void delete(int id)
	{
		try
		{
			myEntMan.getTransaction().begin(); // comenzar la transaccion
			ProductoJPA myProducto = myEntMan.find(ProductoJPA.class, id); // encontrar el objeto
			myEntMan.remove(myProducto); // eliminar un producto
			myEntMan.getTransaction().commit(); // aplicar cambios
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			myEntMan.getTransaction().rollback();
		}
	}

	
	
	// MODIFICAR UN PRODUCTO DE LA BASE DE DATOS
	@Override
	public void update(ProductoJPA entidad)
	{
		try {
			myEntMan.getTransaction().begin();
			ProductoJPA myProducto = myEntMan.merge(entidad);
			myEntMan.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			myEntMan.getTransaction().rollback();
		}
	}
	
}
