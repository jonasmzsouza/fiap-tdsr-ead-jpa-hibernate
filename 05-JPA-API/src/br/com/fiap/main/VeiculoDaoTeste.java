package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Combustivel;
import br.com.fiap.bean.Veiculo;
import br.com.fiap.dao.VeiculoDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.VeiculoNotFoundException;
import br.com.fiap.impl.VeiculoDaoImpl;

public class VeiculoDaoTeste {

	public static void main(String[] args) {

		// Obter um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		// Instanciar um veiculoDao
		VeiculoDao veiculoDao = new VeiculoDaoImpl(em);

		// Cadastrar um veiculo
		Veiculo veiculo = new Veiculo("HONDA", "PRATA", new GregorianCalendar(2021, Calendar.MAY, 20), Combustivel.FLEX,
				false);

		try {
			veiculoDao.add(veiculo);
			veiculoDao.commit();
			System.out.println("Veículo registrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Pesquisar um veiculo e exibir os dados
		try {
			veiculo = veiculoDao.read(1);
			System.out.println(veiculo);
		} catch (VeiculoNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Atualizar um veiuculo
		veiculo = new Veiculo("HONDA", "PRETO", new GregorianCalendar(2021, Calendar.MAY, 20), Combustivel.FLEX, false);
		try {
			veiculoDao.update(veiculo);
			veiculoDao.commit();
			System.out.println("Veículo atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Remover um veiculo
		try {
			veiculoDao.delete(1);
			veiculoDao.commit();
			System.out.println("Veículo removido!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (VeiculoNotFoundException e) {
			System.out.println("Veiculo não existe para remover");
		}

		// fechar
		em.clear();
		fabrica.close();
	}

}
