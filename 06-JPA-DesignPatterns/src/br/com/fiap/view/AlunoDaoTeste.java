package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Aluno;
import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.impl.AlunoDaoImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class AlunoDaoTeste {

	public static void main(String[] args) {

		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Obter um Dao do Aluno
		AlunoDao dao = new AlunoDaoImpl(em);

		// Cadastrar
		Aluno aluno = new Aluno("Jonas", "2TDSR");

		try {
			dao.create(aluno);
			dao.commit();
			System.out.println("Aluno registrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Pesquisar e exibir os dados
		try {
			aluno = dao.read(12);
			System.out.println(aluno.getNome() + " " + aluno.getTurma());
		} catch (EntityNotFoundException e) {
			System.out.println("Aluno não encontrado!");
		}

		// Atualizar
		aluno = new Aluno(1, "Wander", "2TDSR");
		try {
			dao.update(aluno);
			dao.commit();
			System.out.println("Aluno atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Remover
		try {
			dao.delete(1);
			dao.commit();
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();
	}

}
