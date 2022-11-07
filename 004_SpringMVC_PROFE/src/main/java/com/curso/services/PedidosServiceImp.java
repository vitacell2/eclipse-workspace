package com.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Pedido;
import com.curso.domain.Producto;
import com.curso.domain.repository.PedidoRepository;
import com.curso.domain.repository.ProductoRepository;
import com.curso.services.excepciones.PedidoException;

@Service
public class PedidosServiceImp implements PedidosService {

	@Autowired
	@Qualifier("jpaProductoRepository")
	private ProductoRepository repositorio;
	
	
	@Autowired  //inyecta una instancia del servios PedidoRepositoryIMp
	private PedidoRepository repositorioPedido;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void hacerPedido(String idProducto, int cantidad) 
			           throws PedidoException{
		// new tx a
		Producto pAModf = repositorio.getProductoById(idProducto);
	    //validar que existe
		if( pAModf ==null) {
			throw new PedidoException("No se pudo realizar el pedido. El producto no existe");
		}
		
		//validar que hay stock
		if(pAModf.getUnidadesEnStock() - cantidad < 0) {
			throw new PedidoException("No se pudo realizar el pedido. No hay stock disponible");
		}
		//Modificar el stock disponible
		long stock = pAModf.getUnidadesEnStock();
		pAModf.setUnidadesEnStock(stock-cantidad);
		repositorio.update(pAModf);
		
		//  crear pedido
		Pedido pedido = new Pedido();
		pedido.setCantidad(cantidad);
		pedido.setFechaPedido(new java.util.Date());
		pedido.setProducto(pAModf);
		repositorioPedido.create(pedido);
		// commit o rollback
	}

}
