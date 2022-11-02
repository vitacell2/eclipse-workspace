package com.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PoolConexiones {
	
	//atributos
	private String url = "jdbc:oracle:thin:@localhost:49161:xe";
	private String usr =  "SYSTEM"; // "HR"
	private String clave = "oracle"; // "hr"
	 
	public PoolConexiones() {
		//cargar driver
		try {
			// esto es el jar. le pide que cargue de forma dinamica
			// el driver de oracle jdbc y mete los jars en la libreria
			// acordarse añadir la dependencia en el pom xml
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   System.out.println("cargó ok");
			} catch (ClassNotFoundException e) {
				System.out.println("No cargó driver");
				e.printStackTrace();
				throw new RuntimeException("No se pudo cargar el driver oracle");
			}
	}//fin constructor
	
	public Connection getConnection()
	{
		
		//String url = "jdbc:oracle:thin:@localhost:49161:xe";
		//String usr = "HR";
		//String clave = "hr";
		
		Connection con;
		try
		{
			con = DriverManager.getConnection(url, usr, clave);
		//	con.setAutoCommit(false);
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("No se pudo conectar a la DB " + e.getMessage());
		}
		return con;
	}

}
