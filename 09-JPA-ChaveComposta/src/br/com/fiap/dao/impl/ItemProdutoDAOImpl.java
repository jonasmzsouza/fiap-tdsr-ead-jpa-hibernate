package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemProdutoDAO;
import br.com.fiap.entity.ItemProduto;
import br.com.fiap.entity.ItemProdutoPK;

public class ItemProdutoDAOImpl extends GenericDaoImpl<ItemProduto, ItemProdutoPK> implements ItemProdutoDAO {

	public ItemProdutoDAOImpl(EntityManager em) {
		super(em);
	}
	
}
