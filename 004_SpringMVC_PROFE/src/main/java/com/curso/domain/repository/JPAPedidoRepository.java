package com.curso.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Pedido;

@Repository
@Transactional
public class JPAPedidoRepository implements PedidoRepository {

	@PersistenceContext
	private EntityManager em;  // Injecta un entity manager 
	
	@Override
	public void create(Pedido pedido) {
		em.persist(pedido);		
	}

}
