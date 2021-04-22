package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.NanoCourse;
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
			System.out.println("Projeto: " + projeto.getNome());

			// Exibir o nome do grupo
			System.out.println("Grupo: " + projeto.getGrupo().getNome());

			// Exibir o nome dos alunos do grupo
			System.out.println("Alunos:");
			List<Aluno> alunos = projeto.getGrupo().getAlunos();
			for (Aluno aluno : alunos) {
				System.out.println(aluno.getNome());
				// Exibir os cursos relacionados ao aluno
				System.out.println("Cursos realizados:");
				for (NanoCourse nanoCourse : aluno.getNanoCourses()) {
					System.out.println(nanoCourse.getNome());
				}
			}

		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
