package com.banco.domain;

public class Cliente {

	// atributos
	private String nombre = "Luis";
	private String apellido = "Ramos";
	private long cuenta = 0;
	
	// constructor
	public Cliente (String nombre, String apellido, long cuenta)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuenta = 0;
	}

	// getters & setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getCuenta() {
		return cuenta;
	}

	public void setCuenta(long cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
}
