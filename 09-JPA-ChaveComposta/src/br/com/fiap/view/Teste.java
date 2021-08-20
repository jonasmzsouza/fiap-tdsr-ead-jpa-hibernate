package br.com.fiap.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDAO;
import br.com.fiap.dao.ItemProdutoDAO;
import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.dao.impl.CarrinhoCompraDAOImpl;
import br.com.fiap.dao.impl.ItemProdutoDAOImpl;
import br.com.fiap.dao.impl.ProdutoDAOImpl;
import br.com.fiap.entity.CarrinhoCompra;
import br.com.fiap.entity.ItemProduto;
import br.com.fiap.entity.ItemProdutoPK;
import br.com.fiap.entity.Produto;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {

		// Cadastrar um produto, carrinho de compra e item
		// Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Instaniar um ProdutoDAO e CarrinhoCompraDAO
		ProdutoDAO produtoDao = new ProdutoDAOImpl(em);
		CarrinhoCompraDAO carrinhoDao = new CarrinhoCompraDAOImpl(em);

		// Instanciar um produto
		Produto produto = new Produto("Notebook");

		// Instanciar um ItemProduto (tirar o carrinho de compras do construtor)
		ItemProduto item = new ItemProduto(produto, null, 5000.0, 1);

		// Instanciar um Carrinho de compras
		CarrinhoCompra carrinho = new CarrinhoCompra(Calendar.getInstance());

		// Adicionar o item no carrinho de compras
		carrinho.addItem(item);

		try {
			// Cadastrar um produto
			produtoDao.create(produto);
			// Cadastrar o carrinho de compras (0 item prouto vai em cascata)
			carrinhoDao.create(carrinho);
			produtoDao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Pesquisar um item pela PK
		try {
			ItemProdutoDAO itemDao = new ItemProdutoDAOImpl(em);
			ItemProdutoPK pk = new ItemProdutoPK(1, 1, 1);
			ItemProduto item2 = itemDao.read(pk);
			System.out.println(item2.getProduto().getNome() + " " + item2.getValor());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
