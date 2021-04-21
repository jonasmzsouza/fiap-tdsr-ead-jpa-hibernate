package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Disciplina;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class DisciplinaTeste {

	public static void main(String[] args) {

		// Obter o Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Obter uma instância do Generic Dao para a Disciplina
		GenericDao<Disciplina, Integer> dao = new GenericDaoImpl<Disciplina, Integer>(em) {
		};

		// Cadastrar e pesquisar
		Disciplina disciplina = new Disciplina("Mobile", "Android e IOS", null);

		try {
			dao.create(disciplina);
			dao.commit();
			System.out.println("Disciplina cadastrada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			disciplina = dao.read(1);
			System.out.println(disciplina.getNome() + " " + disciplina.getEmenta());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
