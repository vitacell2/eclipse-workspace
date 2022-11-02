package com.curso.mercado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.mercado.entidades.Producto;

public class ProductoDataBaseDAO implements GenericDAO<Producto> {

	private Connection con;
	
	public ProductoDataBaseDAO(Connection con) {
		this.con = con;
	}
	@Override
	public void add(Producto entidad) {
		// TODO Auto-generated method stub
		String insercion = "INSERT INTO HR.PRODUCTOS (ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK)"
				+ "VALUES(?,?,?,?)";
		String consulta = "SELECT ID_PRODUCTO, DESCRIPCION FROM HR.PRODUCTOS";
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			int ultimoId=0;
			boolean nombreIgual = false;
			while(rs.next()&&!nombreIgual) {
				if(entidad.getDescripcion().equals(rs.getString("DESCRIPCION"))) {
					nombreIgual = true;
				}else {
					if(ultimoId<rs.getInt("ID_PRODUCTO")) {
						ultimoId = rs.getInt("ID_PRODUCTO");	
					}
					
				}
				
			}
			
			if(nombreIgual) {
				throw new RuntimeException("El producto ya existe");
			}else {
				PreparedStatement insert = con
						.prepareStatement(insercion);
				
				insert.setInt(1, ultimoId+1);
				insert.setString(2, entidad.getDescripcion());
				insert.setDouble(3, entidad.getPrecio());
				insert.setInt(4, entidad.getStock());
				insert.executeUpdate();
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("No se pudo crear el producto "+e.getMessage(), e);
		}
		
	}

	@Override
	public List<Producto> getAll() {
		ArrayList<Producto> productos = new ArrayList<>();
		String consulta = "SELECT * FROM HR.PRODUCTOS ORDER BY ID_PRODUCTO";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt("ID_PRODUCTO"));
				p.setDescripcion(rs.getString("DESCRIPCION"));
				p.setPrecio(rs.getDouble("PRECIO"));
				p.setStock(rs.getInt("STOCK"));
				productos.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Lnazamos una nueva excepcion pero le pasamos e throwable
			//para que no pierda la pila de llamadas
			//quien realmente lanza el error, en este caso oracle
			throw new RuntimeException ("DB JDBC API. "+e.getMessage(), e);
		}
		return productos;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

}
