package com.banco.domain;

public class Cliente {

	// atributos
	private String nombre;
	private String apellido;
	private long cuenta = 0;
	
	// constructor
	public Cliente (String nombre, String apellido, long cuenta)
	{
		this.nombre = "Luis";
		this.apellido = "Ramos";
		this.cuenta = 23763467;
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

	/*public void getSaldo() {
		// TODO Auto-generated method stub
		
	}*/
	
	
	
}
