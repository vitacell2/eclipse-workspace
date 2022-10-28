package com.curso.spring.ejemplo1;

import java.util.logging.Logger;

public class SaludoServiceImp implements SaludoService
{
	Logger myLogger = Logger.getLogger("SaludoServiceImp");
	
	private String cabeceraMensaje;

	// constructor
	public SaludoServiceImp()
	{
		myLogger.info("... instanciamos el servicio con el constructor");
		// myLogger.info("... instanciamos el servicio ");
		this.cabeceraMensaje = " Hola ";
	}
	
	// constructor para el saludadorAdios
	public SaludoServiceImp(String cabecera)
	{
		myLogger.info("... instanciamos el servicio con el constructor");
		// myLogger.info("... instanciamos el servicio ");
		this.cabeceraMensaje = cabecera;
	}
	
	@Override
	public void saludar(String myMensaje)
	{
		if (myMensaje == null)
		{
		myLogger.fine("MENSAJE: " + myMensaje + " !!!");
		myLogger.info("Saludaron");
		myLogger.severe("Error grande");
		throw new IllegalArgumentException ("El mensaje viene null");
		}
		
		myLogger.fine ("Saludron");
		myLogger.info(this.cabeceraMensaje + myMensaje + " !!!");
		
	}
}
