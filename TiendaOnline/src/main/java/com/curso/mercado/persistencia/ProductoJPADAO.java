package com.curso.mercado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.entidades.ProductoJPA;

public class ProductoJPADAO implements GenericDAO<ProductoJPA>
{
	/*
	// ATRIBUTOS
	private Connection myConnection;
	
	public ProductoJPADAO (Connection myConn)
	{
		this.myConnection = myConn;
	}
	
	
	
	@Override
	public void add (ProductoJPA entidad)
	{
		try
		{
			int newId = 0;
			// obtener el ultimo id
			
			newId = getUltimoIdProducto() + 1;
		
			PreparedStatement ps = con.prepareStatement(
				"INSERT INTO HR.PRODUCTOS " + 
				"(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) " +
				"VALUES (?, ?, ?, ?)");
			ps.setInt(1, newId);
			ps.setString(2, entidad.getDescripcion());
			ps.setDouble(3, entidad.getPrecio());
			ps.setInt(4, entidad.getStock());
			ps.executeUpdate();
			System.out.println("Se grabo OK el producto");
		}
		catch
		 (SQLException e)
		{
			//e.printStackTrace();
			throw new RuntimeException("DB JDBC API. " + e.getMessage(), e);
		}
	}
	
	
	
	private int getUltimoIdProducto() // para conseguir el ultimo ID del ultimo producto añadido
	{
		// mandamos una consulta para que nos de el valor del maximo ID
		String consulta = "SELECT max(ID_PRODUCTO) FROM HR.PRODUCTOS";
		
		try
		{
			ResultSet rs = myConnection.createStatement().executeQuery(consulta);
			if (rs.next()) // mover el sursor
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("ERROR: No pudó obtener el ultimo id");
		}
	}
	
	
	
	@Override
	public ProductoJPA getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductoJPA entidad) {
		// TODO Auto-generated method stub
		
	}*/
	
	
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
	//public void add(ProductoJPA entidad, int id)
	{
		try
		{
			

		    ProductoJPA myProductoJPA = new ProductoJPA();
			
			// asignar un ID (simular AUTOINCREMENT de una base de datos)
			int newID = 0;
			
			newID = getUltimoIdProductoJPA();
			
			// inicia una nueva transaccional
			myEntMan.getTransaction().begin();
			myProductoJPA.setIdProducto(newID);
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
		Query q = myEntMan.createQuery("SELECT myProducto FROM HR.PRODUCTOS myProducto");
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
	
	/*
	public List<ProductoJPA> findNRows(int id)
	{
        return myEntMan.createQuery("from "+ProductoJPA.getDescripcion() + " ORDER BY id DESC", ProductoJPA).setMaxResults(id).getResultList();
	}*/
	
	/*
    public List<ProductoJPA> getProductoMaxIdJPA()
    {
        Query myQuery = myEntMan.createQuery("SELECT max(ID_PRODUCTO) FROM HR.PRODUCTOS", ProductoJPA.class); // traeme objeto de tipo producto
        return myQuery.getResultList();
    }*/
    
    // conseguir el maximo ID, la funcion nos devuelve un integer
    private int getUltimoIdProductoJPA()
    {
    	// para devolver objeto
    	// resultado = myEntMan.createQuery("SELECT max(ID_PRODUCTO) FROM HR.PRODUCTOS", ProductoJPA.class).getSingleResult();
    
    	// para devolver Integer
    	Integer resultado = 0;
    	resultado = (Integer)myEntMan.createQuery("SELECT max(ID_PRODUCTO) FROM HR.PRODUCTOS").getSingleResult();
    	resultado = resultado + 1;
    	return resultado;
    }
	
}
