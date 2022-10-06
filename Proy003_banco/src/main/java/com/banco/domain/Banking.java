package com.banco.domain;

import com.banco.domain.Cliente; // importamos de la clase Cliente
import com.banco.domain.Cuenta; // importamos de la clase Cuenta

public class Banking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// constructor
		Cliente thisClient = new Cliente(String nombre, String apellido, long cuenta);
		
		Cuenta thisCuenta = new Cuenta(double saldo, double ingreso, double retiro);
		
		thisClient.getSaldo();
		
		printInfo(info);
		
	}
	
	public void printInfo()
	{
		getInfo();
		System.out.println(".....");
        //System.out.println(info);
        System.out.println("....");
        
	}
	
	public void getInfo()
	{
		
	}

	// NOTA: voy muy lento porque no tengo claro lo que tengo que poner exactamente
}
