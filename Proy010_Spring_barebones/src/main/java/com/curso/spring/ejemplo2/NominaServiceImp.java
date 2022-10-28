package com.curso.spring.ejemplo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NominaServiceImp implements NominaService
{
	// inyecta en la variable de ref irpfService una inctancia de IRPFServiceImp
	
	@Autowired
	private IRPFService irpfService;
	
	public NominaServiceImp()
	{
		System.out.println("*** constructor nsi");
	}
	
	public void calcularNomina()
	{
		System.out.printf("*** tu nomina es %d con un " + " IRPF %5.3f %n", 
				233.0, irpfService.calcularIRPF());
	}
}
