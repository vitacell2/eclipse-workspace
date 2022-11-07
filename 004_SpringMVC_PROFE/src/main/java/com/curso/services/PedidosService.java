package com.curso.services;

import com.curso.services.excepciones.PedidoException;

public interface PedidosService {

	public void hacerPedido(String idProducto, int cantidad) throws PedidoException;
	
}
