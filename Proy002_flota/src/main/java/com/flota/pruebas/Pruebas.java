package com.flota.pruebas;

import com.flota.dominio.Vehiculo;

public class Pruebas {

	public static void main(String[] args) {
		Vehiculo camion = new Vehiculo("43254pkl", 600.10);
		
		//camion.cargaMaxima = 555.25; // atributo cargaMaxima es public
		
		try
		{
			camion.setCargaMaxima(560);
			System.out.printf("El camion con matricula %s " + "tiene una carga actual de %f kg",
					camion.getMatricula(),
					camion.getCargaActual());
			
			System.out.println("cargo una caja de 560kg");
			camion.cargarCaja(460);
			
			System.out.println("cargo una caja de 560kg");
			camion.cargarCaja(560);
			

		}catch(Exception e)
		{
			System.out.println("No pudo cargar: " + e.getMessage());
		}
	}

}
