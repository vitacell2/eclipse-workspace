package com.banco.domain;

public class Cuenta {

	// Atributos
	private double saldo = 500.00;
	private double ingreso;
	private double retiro;
	
	// constructor
	public Cuenta()
	{
		this.saldo = 0;
	}
	
	// metodos
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		//depositarSaldo();
		this.saldo = saldo;
	}
	
	public boolean depositarSaldo(double ingreso)
	{
		if (ingreso > 0)
		{
			this.saldo = saldo + ingreso;
			System.out.printf("Se han añadido %f ", ingreso);
			return true;
		}else 
		{
			throw new RuntimeException("No hay dinero que depositar");
			//return false;
		}
		//return true;
	}
	
	public boolean retirarSaldo(double ingreso)
	{
		boolean seRetira = false;
		if (retiro <= saldo)
		{
			this.saldo = saldo - retiro;
			seRetira = true;
			setSaldo(saldo);
			//return true;
		}else
		{
			seRetira = false;
			throw new RuntimeException("No se retirar mas de lo que se tiene");
			//return false;
		}
		return seRetira;
	}

}
