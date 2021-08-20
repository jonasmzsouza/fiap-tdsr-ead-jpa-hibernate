package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDAO;
import br.com.fiap.entity.CarrinhoCompra;

public class CarrinhoCompraDAOImpl extends GenericDaoImpl<CarrinhoCompra, Integer> implements CarrinhoCompraDAO {

	public CarrinhoCompraDAOImpl(EntityManager em) {
		super(em);
		
	}

}
