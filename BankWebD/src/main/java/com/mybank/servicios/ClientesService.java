package com.mybank.servicios;

import com.mybank.domain.Bank;
import com.mybank.domain.Customer;

public class ClientesService {
	
	public Customer[]  dameTodosLosClientes() {
		return Bank.getBank().getCustomers();
	}

}
