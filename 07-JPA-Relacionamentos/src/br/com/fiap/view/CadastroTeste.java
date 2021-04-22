package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoChallengeDao;
import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.GrupoChallenge;
import br.com.fiap.entity.NanoCourse;
import br.com.fiap.entity.NivelCurso;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	// Utiliza o projeto para cadastrar o grupo
	public static void main(String[] args) {

		// Obter o Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Obter um GrupoChallangeDao e ProjetoChallangeDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);

		// Instanciar um grupo
		GrupoChallenge grupo = new GrupoChallenge("Forever");

		// Instanciar um projeto
		ProjetoChallenge projeto = new ProjetoChallenge("IoT conectando pessoas",
				new GregorianCalendar(2021, Calendar.JULY, 15), null, "RH", grupo);

		// Cadastrar um grupo
		// grupoDao.create(grupo);

		// Instanciar 3 alunos e adiciona-los no grupo
		Aluno aluno1 = new Aluno("Mike", new GregorianCalendar(2000, Calendar.JULY, 8), Genero.FEMININO);
		Aluno aluno2 = new Aluno("John", new GregorianCalendar(2001, Calendar.FEBRUARY, 22), Genero.MASCULINO);
		Aluno aluno3 = new Aluno("Mary", new GregorianCalendar(2002, Calendar.DECEMBER, 13), Genero.FEMININO);

		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);

		// Cadastrar 2 cursos relacionados com os alunos
		// Instaciar 2 cursos
		NanoCourse nanoCourse1 = new NanoCourse("Mobile Hibrido", 8, NivelCurso.INTERMEDIARIO);
		NanoCourse nanoCourse2 = new NanoCourse("Java Enterprise", 10, NivelCurso.AVANCADO);

		// Instanciar uma lista de curso
		List<NanoCourse> nanoCourses = new ArrayList<>();
		nanoCourses.add(nanoCourse1);
		nanoCourses.add(nanoCourse2);

		// Setar a lista de curso no aluno
		aluno1.setNanoCourses(nanoCourses);
		aluno2.setNanoCourses(nanoCourses);

		// Cadastrar um projeto
		projetoDao.create(projeto);

		try {
			// Commit
			projetoDao.commit();
			System.out.println("Grupo e projeto cadastrados");

		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();
	}

}
