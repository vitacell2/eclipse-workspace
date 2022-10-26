package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Order;

public class PruebaOneToMany
{
	public static void main(String[] args)
	{
		//1. Crear una Factoria de Entiny Manager
		EntityManagerFactory myFactoryEntMan =
						Persistence.createEntityManagerFactory("OraceHRPU");
		
		//2. Obtenemos un Entity Manager 
		EntityManager myEntMan = myFactoryEntMan.createEntityManager();
		
		// crear un pedido para un cliente (id 7 Nombre)
		Order myPedido = new Order();
		Customer c7 = new Customer();
		c7.setId(7);
		
		myPedido.setCliente(c7);
		myPedido.setDescripcion("Pedido importante ");
		
		myEntMan.getTransaction().begin();
		myEntMan.persist(myPedido);
		myEntMan.getTransaction().commit();
		
		Order myOrder = myEntMan.find(Order.class, 13L);
		System.out.printf("El pedido %s ha " +
					"sido hecho por %s ",
					myOrder.getDescripcion(),
					myOrder.getCliente().getCustomerName()
				);
		
		myEntMan.clear();
		
		Order myOrder2 = myEntMan.find(Order.class, 13L);
		System.out.printf("El pedido %s ha " +
					"sido hecho por %s ",
					myOrder2.getDescripcion(),
					myOrder2.getCliente().getCustomerName()
				);
		
		System.out.println("... buscamos cliente 7 ");
		Customer begona = myEntMan.find(Customer.class, 7);
		
		System.out.println("El cliente " + begona.getCustomerName());
		System.out.println("pedidos: ");
		for (Order or : begona.getPedidos())
		{
			System.out.println(or.getDescripcion());
		}
		
	}
}
