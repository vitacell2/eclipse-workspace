package com.curso.bank.database;

public class Cliente {


	  private String nombre;

	  private String apellido;

	  private Cuenta[] cuentas;
	  private int numeroDeCuentas;

	  public Cliente(String n, String a) {
	    nombre = n;
	    apellido = a;
	    
	    // inicializar
	    cuentas = new Cuenta[4];
	    numeroDeCuentas = 0; // inicializamos a cero
	  }

	  public String getNombre() {
	    return nombre;
	  }

	  public String getApellido() {
	    return apellido;
	  }

	  public void anadirCuente(Cuenta c) {
	    int i = numeroDeCuentas++;
	    cuentas[i] = c;
	  }

	  public int getNumeroDeCuentas() {
	    return numeroDeCuentas;
	  }

	  public Cuenta getCuenta(int cuentas_index) {
	    return cuentas[cuentas_index];
	  }
	
}
