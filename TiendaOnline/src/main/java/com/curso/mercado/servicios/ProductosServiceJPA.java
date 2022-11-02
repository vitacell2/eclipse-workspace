package com.curso.mercado.servicios;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.entidades.ProductoJPA;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoJPADAO;



public class ProductosServiceJPA {
	
	private GenericDAO<Producto> dao;
	
			//new ProductoInMemoryDAO();
	
	public ProductosServiceJPA() {
		 // Pool conexiones  // NO ES ASI EN PRODUCCION
		// PoolConexiones pool = new PoolConexiones();
		// this.dao = new ProductoDataBaseDAO(pool.getConnection());
		dao = new ProductoJPADAO();
		
	}
	
	
	public void darAltaUnproducto(Producto p) {
		// valida que p no es null
		//validar descripcion 
		//validar precio
		
		dao.add(p);
		
	}
	
	public List<Producto>  dameTodosLosProductos()
	{
		//Query myConsulta = myEntMan.createQuery("SELECT t FROM TRABAJO t"); // traeme objetos de tipo trabajo
		
		//Collection<ProductoJPA> myLista = myConsulta.getResultList();
		//System.out.println("... lista de trabajos");
		
		//for (ProductoJPA prod : myLista)
		//{
			//System.out.println(prod);
		//}
		
		return dao.getAll();
	}
	
	
	public List<Producto> borrarProducto(int id)
	{
		Producto myProducto = dao.getByID(id);
		if(myProducto == null)
		{
			throw new RuntimeException("ERROR: no esta el producto que quieres eliminar");
		}
		dao.delete(id);
		return dao.getAll();
	}

}
