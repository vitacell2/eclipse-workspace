package com.curso.varios;

public class EjemploVariablesPila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a = new Alumno(1);
		metodo1(a);
		System.out.println(" Id alumno es " + a.getId());
		System.out.println("Fin main");
		
	}

	public static void metodo1(Alumno a)
	{
		Alumno b = a;
		b.setId(33);
		metodo2();
		System.out.println("Fin metodo 1");
	}
	
	public static void metodo2()
	{
		Alumno c = new Alumno(3);
		//if(c == 3) throw new RuntimeException("La has liado");
		//String s = null;
		//s = s.toUpperCase();
		System.out.println("Fin metodo 2");
	}
}
