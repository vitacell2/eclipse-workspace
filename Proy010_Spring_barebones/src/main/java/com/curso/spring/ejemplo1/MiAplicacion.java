package com.curso.spring.ejemplo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MiAplicacion {

	public static void main(String[] args)
	{
		// sin Spring inyeccion de la dependencia
		SaludoService myService = new SaludoServiceImp();
		myService.saludar("Amigo");
		
		
		// SIN SPRING IOC
		// ya n voy yo a crear nunca mas una instancia de la clase SaludoServiceImp
		// sino que voy a solicitar al Contenedor de beans de Spring que me entregue una instancia
		
		// para crear un contenedor de Beans de Spring
		ApplicationContext myAppContext =
				new ClassPathXmlApplicationContext("mis-beans.xml");
		
		// creamos un saludador, nuevo objeto
		SaludoService mySaludador1 = (SaludoService) myAppContext.getBean("saludadorPrototipo");
		mySaludador1.saludar("soy saludador1");
		
		System.out.println("mySaludador1: " + mySaludador1);
		SaludoService mySaludador2 = (SaludoService) myAppContext.getBean("saludadorPrototipo");
		System.out.println("mySaludador2: " + mySaludador2);

	}

}
