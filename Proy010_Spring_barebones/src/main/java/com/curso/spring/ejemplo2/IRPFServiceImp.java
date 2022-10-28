package com.curso.spring.ejemplo2;

public class IRPFServiceImp implements IRPFService
{
	public IRPFServiceImp()
	{
		System.out.println("*** instanciando IRPF service implementation");
	}
	
	public double calcularIRPF()
	{
		return 10.0;
	}
}
