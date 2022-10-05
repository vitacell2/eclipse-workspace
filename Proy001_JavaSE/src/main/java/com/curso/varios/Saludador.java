package com.curso.varios;

/*
 * JVM cargar la clase com.curso.varios.Saludador
 */

public class Saludador
{
	// las clases estan formadas por:
	
	// -atributos
	private String saludo;
	
	// -constructores (diferemcia de de metodos, los constructores no devuelven nada) (no poner "void" a un constructor, "void" es para metodos)
	public Saludador() //ahora puedes crear objetos saludador
	{
		super();
		this.saludo = "Hola";
	}
//	public Saludador()
//	{
//		super();
//	}
	
	// -metodos
	// definimos un metodo
	public String saluda (String nombreUsuario)
	{
		return "Hola " + nombreUsuario;
		//return null;
	}
	
	// definimos otro metodo
	public String saluda()
	{
		return this.saludo + " Amigo";
	}
}
