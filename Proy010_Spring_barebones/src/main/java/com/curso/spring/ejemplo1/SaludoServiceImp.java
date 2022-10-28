package com.curso.spring.ejemplo1;

import java.util.logging.Logger;

public class SaludoServiceImp implements SaludoService
{
	Logger myLogger = Logger.getLogger("SaludoServiceImp");

	// constructor
	public SaludoServiceImp()
	{
		myLogger.info("... instanciamos el servicio con el constructor");
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
		else
		{
			myLogger.fine ("Saludron");
			myLogger.info("Hola " + myMensaje + " !!!");
		}
	}
}
