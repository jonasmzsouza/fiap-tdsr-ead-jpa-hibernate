package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestePesquisa {

	public static void main(String[] args) {

		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Instaciar uma CidadeDAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);

		// Pesquisar as cidades
		List<Cidade> cidades = cidadeDao.listar();

		// Exibir todas as cidades
		System.out.println("Listar todas as cidades:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getUf());
		}

		// Exibir todas as cidade que possuem mais do que 1000 habitantes
		cidades = cidadeDao.buscarPorNumeroHabitantesMaior(1000);

		System.out.println("Pesquisa por habitantes:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getNrHabitantes());
		}

		// Instanciar um CLienteDao
		ClienteDAO clienteDao = new ClienteDAOImpl(em);

		// Listar os clientes
		List<Cliente> clientes = clienteDao.listar();

		// Exibir todos os clientes
		System.out.println("Listar os clientes:");
		clientes.forEach(c -> System.out.println(c.getNome()));

		// Pesquisar os clientes por parte do nome
		clientes = clienteDao.buscarPorParteNome("a");

		// Exibir os clientes
		System.out.println("Buscar por parte do nome:");
		clientes.forEach(c -> System.out.println(c.getNome()));

		// Instanciar um TransporteDAO
		TransporteDAO transporteDao = new TransporteDAOImpl(em);

		// Instanciar um PacoteDao
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);

		// Pesquisar um transporte pelo código
		Transporte transporte = transporteDao.pesquisar(1);

		// Buscar os pacotes pelo transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);

		// Exibir os pacotes e o nome da empresa do transporte
		System.out.println("Buscar pacotes por tranporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " - " + p.getTransporte().getEmpresa()));

		// Pesquisar os clientes por Estado
		clientes = clienteDao.buscarPorEstado("PR");

		// Exibir os clientes do estado do Parana
		System.out.println("Buscar clientes por Estado:");
		clientes.forEach(c -> System.out.println(c.getNome() + " - " + c.getEndereco().getCidade().getUf()));

		// Pesquisar cliente que tem 10 dias de reserva
		clientes = clienteDao.buscarPorDiasReserva(10);

		// Exibir os clientes
		System.out.println("Buscar clientes por dias de reserva:");
		clientes.forEach(c -> System.out.println(c.getNome()));

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
