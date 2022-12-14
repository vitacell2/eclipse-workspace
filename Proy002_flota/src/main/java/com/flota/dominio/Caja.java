package com.flota.dominio;

public class Caja {
	
	// variables primitivas
	
	// Variables de referencia
	Caja c = new Caja();
	Caja c2 = null;
	Caja c3 = new Caja();
	c2 = c3; // ahora en c2 tendremos referencia/direccion de c3
	
	// atributos
	private double peso = 0.0;
	
	// constructor
	// PROPOSITO: crear el objeto reservando la memoria necesaria para guardar todos sus atributos
	//asegura de inicializar los atributos para que el objeto sea consistente (preparado)
	public Caja()
	{
		this.peso = 100;
	}
	
	public void cargarCaja(double peso) {
		//validar que el peso es > 0 
		if(peso <= 0) {
			throw new RuntimeException("La caja debe pesar algo");
		}
		// validar que cabe . Que no supera la carga máxima		
		if(peso+cargaActual > cargaMaxima)  {
			throw new RuntimeException("no caben mas cajas");
		}
		
		//puedo cargar luego incremento carga actual y numero de cajas
		this.cargaActual = this.cargaActual + peso;
		this.numCajas ++;
				
	}//fin metodo cargar Caja	
	
	//sobrecargo el método cargarCaja para que permita
	//recibir un objeto Caja
	public void cargarCaja(Caja c) {
		cargarCaja(c.getPeso());
	}

}
