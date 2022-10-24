package com.curso.bank.servicios;

import com.curso.bank.domain.Bank;
import com.curso.bank.domain.Customer;

public class ClientesService
{
	public Customer[]  getAllClients()
	{
		return Bank.getCustomers();
	}

}
