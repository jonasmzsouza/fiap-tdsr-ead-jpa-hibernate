package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoChallengeDao;
import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.GrupoChallenge;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {
	
	// Utiliza o grupo para cadastrar o projeto
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
		
		//setar o projeto do grupo
		grupo.setProjeto(projeto);
		
		// Cadastrar um grupo
		grupoDao.create(grupo);

		// Cadastrar um projeto
		//projetoDao.create(projeto);

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
