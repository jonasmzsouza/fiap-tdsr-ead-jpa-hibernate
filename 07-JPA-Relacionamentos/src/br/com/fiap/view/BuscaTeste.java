package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		// Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Obter o ProjetoChallengeDao
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);

		try {
			// Pesquisar um projeto
			ProjetoChallenge projeto = projetoDao.read(1);

			// Exibir o nome do projeto
			System.out.println(projeto.getNome());

			// Exibir o nome do grupo
			System.out.println(projeto.getGrupo().getNome());

		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
