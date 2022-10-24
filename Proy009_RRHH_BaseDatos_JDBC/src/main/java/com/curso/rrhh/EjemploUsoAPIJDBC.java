package com.curso.rrhh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploUsoAPIJDBC {

	public static void main(String[] args) {

		// 1. Cargar driver JDBC Oracle 18c (conectarme a la DB)
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("cargó ok");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("No cargó driver");
			e.printStackTrace();
			return;
		}
		
		// 2. crear una conexion a la DB
		
		//Connection con = null;
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr =  "SYSTEM";
		String clave = "oracle";
		
		try (Connection con = DriverManager.getConnection(url, usr, clave))
		{
			System.out.println("conectó ok");
			// 3. consultar la lista de paises
			Statement st = con.createStatement();
			
			// 3.1 lanzar la consulta a la DB
			//Statement st = con.createStatement("SELECT * FROM COUNTRIES");
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			
			/*  rs -> before resultado
			 * 			registor 1 AR
			 * 			registor 2 AU
			 * 			registor 3 BE
			 * 			after
			 */
			
			boolean hayRegistro = rs.next();
			if (hayRegistro)
			{
				// leo el primer campo y el segundo
				// columnas van numeradas del 1 en adelante
				
				System.out.print(rs.getString("COUNTRY_ID") + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.println(rs.getString(3));
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				//System.out.println(rs.getString(3));
			}
		 
			// 3.2 recorrer el resultado de la consulta
			while (rs.next())
			{
				System.out.println(rs.getString(1));
			}
			
			//llamada al proc almacenado
//			CallableStatement call = con.prepareCall("{call MI_PROGRAMA1(?,?,?)} ");
			
			String sentenciaInsert = "INSERT INTO HR.COUNTRIES " + " VALUES ('XX','PAISXX', 4) ";
			int regAfectado = st.executeUpdate(sentenciaInsert);
			System.out.printf("insertó %d registros", regAfectado);
		
		}
		catch(SQLException e)
		{
			System.out.println("Error conexion" + e.getMessage());
			e.printStackTrace();
		}
		
		try(Zapato z = new Zapato();)
		{
			System.out.println(".....se111");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// 3. consulta la lista de paises
		
		
		// 4. hacer una SELECT
		
		
		// 5. hacer un INSERT

	}

}
