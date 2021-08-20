package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.dao.util.DataUtil;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
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

		// Pesquisar um transporte pelo c�digo
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

		// Listar os clientes informando a primeira posi��o e o m�ximo de resultados
		// (paginando)
		clientes = clienteDao.listar(0, 3);

		// Exibir os clientes
		System.out.println("Listar os clientes por pagina��o");
		clientes.forEach(c -> System.out.println(c.getNome()));

		// Pesquisar pacotes por pre�o, retornando a descri��o e a qtd de dias
		// (Object[])
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(950);
		System.out.println("Buscar por pacotes por pre�o menor (Object)");
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));

		// Pesquisar pacotes por pre�o, retornando a descri��o e a qtd de dias
		// (Pacote)
		List<Pacote> pacote = pacoteDao.buscarPorPrecoMenor2(10000);
		System.out.println("Buscar por pacotes por pre�o menor (Pacote)");
		pacote.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getPreco()));

		// Pesquisar pacotes por pre�o, retornando a descri��o e a qtd de dias
		// (Pacote)
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(10000);
		System.out.println("Buscar por pacotes por pre�o menor (Pacote)");
		listaString.forEach(p -> System.out.println(p));

		// Pesquisar pacotes por data de sa�da
		Calendar inicio = new GregorianCalendar(2021, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2020, Calendar.DECEMBER, 31);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);

		// Exibir a descri��o e a data de sa�da dos pacotes
		System.out.println("Buscar pacotes por data de sa�da");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));

		// Pesquisar cliente por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "a");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));

		// Pesquisar clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("PR");
		estados.add("SP");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estados:");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));

		// Buscar por parte do nome, sem diferenciar as maiuscular e min�sculas,
		// ordenando por nome
		clientes = clienteDao.buscarPorParteNome2("iA");
		System.out.println("Buscar por parte do nome, sem diferenciar as maiuscular e min�sculas, ordenando por nome:");
		clientes.forEach(c -> System.out.println(c.getNome()));

		// Contar cliente por estado espec�fico
		Long qtd = clienteDao.contarPorEstado("PR");
		System.out.println("Contar cliente por estado espec�fico: " + qtd);

		// Somar pre�os por um transporte espec�fico
		Double soma = pacoteDao.somarPrecoPorTransporte("CoMetA");
		System.out.println("Somar pre�os por um transporte espec�fico: " + soma);

		// Instanciar a ReservaDAOImlp
		ReservaDAO reservaDao = new ReservaDAOImpl(em);

		// Pesquisar reservas por parte do nome do cliente
		List<Reserva> reservas = reservaDao.buscarClientePorNome("a");

		// Exibir a descricao do pacote, nome do cliente e data da reserva
		reservas.forEach(r -> System.out.println(r.getPacote().getDescricao() + " " + r.getCliente().getNome() + " "
				+ DataUtil.formatar(r.getDataReserva())));

		// Pesquisar reservas por preco do pacote entre 2 valores
		reservas = reservaDao.buscarPorPrecoPacote(1000, 5000);

		// Exibir a descricao do pacote e data da reserva
		System.out.println("Exibir a descricao do pacote e data da reserva:");
		reservas.forEach(r -> System.out.println(r.getPacote().getDescricao() + " " + r.getPacote().getPreco() + " "
				+ DataUtil.formatar(r.getDataReserva())));

		// Pesquisar pacote por preco e qtd de dias
		pacotes = pacoteDao.buscarPorQtdDiasMaiorEPrecoMenor(5, 1000);

		// Exibir a descri��o do pacote, a qtd de dias e o preco
		System.out.println("Buscar pacotes por pre�o menor e qdt de dias maior");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getPreco()));

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
