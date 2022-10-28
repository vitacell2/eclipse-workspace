package com.curso.mercado.servicios;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import com.curso.mercado.entidades.ProductoJPA;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoJPADAO;



public class ProductosServiceJPA {
	
	private GenericDAO<ProductoJPA> dao;
	
			//new ProductoInMemoryDAO();
	
	public ProductosServiceJPA() {
		 // Pool conexiones  // NO ES ASI EN PRODUCCION
		// PoolConexiones pool = new PoolConexiones();
		// this.dao = new ProductoDataBaseDAO(pool.getConnection());
		this.dao = new ProductoJPADAO();
		
	}
	
	
	public void darAltaUnproducto(ProductoJPA p) {
		// valida que p no es null
		//validar descripcion 
		//validar precio
		
		dao.add(p);
		
	}
	
	public List<ProductoJPA>  dameTodosLosProductos() {
		Query myConsulta = myEntMan.createQuery("SELECT t FROM TRABAJO t"); // traeme objetos de tipo trabajo
		
		Collection<ProductoJPA> myLista = myConsulta.getResultList();
		System.out.println("... lista de trabajos");
		
		for (ProductoJPA prod : myLista)
		{
			System.out.println(prod);
		}
		
		//return dao.getAll();
	}

}
