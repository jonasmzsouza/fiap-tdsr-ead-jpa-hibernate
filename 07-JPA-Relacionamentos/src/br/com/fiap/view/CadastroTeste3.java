package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.GrupoChallengeDao;
import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.GrupoChallenge;
import br.com.fiap.entity.NanoCourse;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {

	public static void main(String[] args) {

		// Obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Cadastrar um grupo:
		// Instanciar umm GrupoDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);

		// Instanciar um Grupo
		GrupoChallenge grupo = new GrupoChallenge("Ambers");

		// Chamar o create do dao e commit
		try {
			grupoDao.create(grupo);
			grupoDao.commit();
			System.out.println("Grupo cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Cadastrar um projeto associado a um grupo que existe no banco
		// Instanciar um ProjetoDao
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);

		try {

			// Pesquisar um grupo no banco
			grupo = grupoDao.read(2);

			// Instanciar um Projeto com um grupo
			ProjetoChallenge projeto = new ProjetoChallenge("Transformando o mundo com IoT", Calendar.getInstance(),
					null, "Tecnologia", grupo);

			// Chamar o create do dao e commmit
			projetoDao.create(projeto);
			projetoDao.commit();
			System.out.println("Projeto cadastrado!");

		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		// Cadastrar um aluno associado a um grupo que ja existe no banco
		// Instanciar um AlunoDao
		GenericDao<Aluno, Integer> alunoDao = new GenericDaoImpl<Aluno, Integer>(em) {
		};

		try {
			// Pesquisar um Grupo
			grupo = grupoDao.read(2);

			// Instanciar um Aluno com o grupo
			Aluno aluno = new Aluno("Jorge", new GregorianCalendar(2021, Calendar.SEPTEMBER, 11), Genero.MASCULINO);

			// Chamar o create e commit do AlunoDao
			alunoDao.create(aluno);
			alunoDao.commit();
			System.out.println("Aluno registrador!");

		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		// Associar um aluno a um curso que já existe no banco
		// Intanciar um NanoCourseDao
		GenericDao<NanoCourse, Integer> nanoCourseDao = new GenericDaoImpl<NanoCourse, Integer>(em) {
		};

		try {
			// Pesquisar dois curso
			NanoCourse nanoCourse1 = nanoCourseDao.read(1);
			NanoCourse nanoCourse2 = nanoCourseDao.read(2);

			// Pesquisar um aluno
			Aluno aluno = alunoDao.read(3);

			// Adicionar os cursos na lista de cursos do aluno
			aluno.getNanoCourses().add(nanoCourse1);
			aluno.getNanoCourses().add(nanoCourse2);

			// Update no aluno
			alunoDao.update(aluno);
			alunoDao.commit();
			System.out.println("Aluno matriculado!");

		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
