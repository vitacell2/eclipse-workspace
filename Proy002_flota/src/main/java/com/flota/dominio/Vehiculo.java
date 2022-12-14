package com.flota.dominio;
/*
 * Clase que representa un vehiculo de una flota
 * que puede transportar cajas, pero tienen una
 * carga maxima permitida
 * 
 * 
 */

public class Vehiculo {

	// atributos
	private double cargaMaxima; // si lo hago privado, y asi nadie puede meterle mano al camion, y modificar su carga maxima
	private String matricula = "";
	private double cargaActual = 0.0;
	private int numCajas = 0;
	
	// constructores
	public Vehiculo (String matricula, double cargaMaxima)
	{
		// validar la matricula no null
		// validar carga maxima > 0
		this.matricula = matricula;
		this.cargaMaxima = cargaMaxima;
	}
	
	/*
	 * Un metodo que recibe el peso de la caja a cargar y incrementa el peso actual del camion y
	 * el numero de cajas cargadas
	 * Si el peso no es valido (<0), lanza una excepcion
	 * Si el peso a cargar supera el maximo permitido excede...
	 * 
	 * @params peso de la caja a cargar en kg
	 * @throws RuntimeException el peso de la caja no es valido o super carga maxima permitida
	 */
	
	// metodos
	public void cargarCaja(double peso)
	{
		if (peso > 0 && (peso + cargaActual <= cargaMaxima)) {
			this.cargaActual=this.cargaActual + peso;
			this.numCajas++;
		}else 
		{
			throw new RuntimeException("No caben mas cajas");
		}
	}
	
	
	// getters & setters
	public double getCargaMaxima()
	{
		return cargaMaxima;
	}

	public void setCargaMaxima(double cargaMaxima)
	{
		if (cargaMaxima < 0)
		{
			throw new RuntimeException("No puede pasar una carga con valor negativo");
		}
		this.cargaMaxima = cargaMaxima;
	}
	
	public double getCargaActual()
	{
		return cargaActual;
	}
	
	public int getNumCajas()
	{
		return numCajas;
	}
	
	public String getMatricula()
	{
		return matricula;
	}
	
	/*public void setmatricula(String matricula)
	{
		this.matricula = matricula;
	}*/
	
} // FIN CLASE
