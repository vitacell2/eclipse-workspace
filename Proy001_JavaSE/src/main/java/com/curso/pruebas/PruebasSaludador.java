package com.curso.pruebas;
import java.util.Date;
import com.curso.varios.Saludador;

public class PruebasSaludador {

	public static void main(String[] args) {
		// Uso de la clase Saludador.java
		
		int numeroCamiones = 2; // * (int)Math.PI;
		
		// 1 - Se puede crear un objeto Saludador
		// 		crear un objeto de la clase, instanciar un objeto de la clase
		//		s1 es una variable de referencia que apunta a objetos de tipo Saludador
		//com.curso.varios.Saludador s1; 
		Saludador s1 = new Saludador();
		// si da error, tienes que mencionar donde esta la clase Saludador
		// De la clase Saludador, se puede utilizar "import" arriba, o en vez de eso, se puede referenciar con "com.curso.varios.*"
		// pero habria que poner la referencia cada vez que escribes "Saludador"
		  
		// 2 - Pedir saludar pasando el nombre -> muestra "Hola" + nombre
		// escribo "syso" y luego control + espacio
		System.out.println(s1.saluda("Hola, un texto"));
		
		// 3 - Pedir saludar sin nombre -> muestra "Hola Amigo"
		System.out.println(s1.saluda());
		
		// 4 - Crear un saludador en el que indice el saludo
		Saludador s2 = new Saludador("Buenos dias");
		
		// 5 - Pedir saludo sin nombre "Buenos dias amigo"
		System.out.println(s2.saluda());

	}

}
