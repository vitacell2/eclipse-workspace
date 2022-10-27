package com.curso.jpa.pruebas;

class PruebasAux {

	private static final String SEPARADOR = "\n###############################################" +
											"#################################################\n";
	
	static void vuelcaEntidad(Object obj) {
		System.out.println(SEPARADOR + obj.toString().replace(", ", ",\n") + SEPARADOR);
	}
}
