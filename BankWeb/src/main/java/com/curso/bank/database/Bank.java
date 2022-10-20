package com.curso.bank.database;

public class Bank {

	  private static Cliente[] clientes;
	  private static int numeroDeClientes;

	  static {
	    clientes = new Cliente[4];
	    numeroDeClientes = 0;
	  }

	  private Bank() {
	    // constructor que no sera llamado
	  }

	  public static void anadirCliente(String n, String a) {
	    int i = numeroDeClientes++;
	    clientes[i] = new Cliente(n, a);
	  }
	  public static int getNumeroDeClientes() {
	    return numeroDeClientes;
	  }
	  public static Cliente getCliente(int clientes_index) {
	    return clientes[clientes_index];
	  }
	
}
