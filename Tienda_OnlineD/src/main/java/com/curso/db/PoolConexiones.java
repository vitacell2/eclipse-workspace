package com.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.curso.mercado.persistencia.ProductoDataBaseDAO;

public final class PoolConexiones {

	public PoolConexiones() {
		try {
			// esto es el jar. le pide que cargue de forma dinamica
			// el driver de oracle jdbc y mete los jars en la libreria
			// acordarse añadir la dependencia en el pom xml
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// mysql
			// Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			throw new RuntimeException("No se udo cargar el driver de oracle");
		}
		
		
	}
	
	public Connection getConexion () {
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr = "system";
		String clave = "oracle";
		Connection con;
		try {
			con = DriverManager.getConnection(url, usr, clave);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("No se pudo conectar a la BD");
		}
		return con;
	}
}
