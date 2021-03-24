package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Combustivel;
import br.com.fiap.bean.Veiculo;

public class CadastroTeste {

	public static void main(String[] args) {

		// Obter uma instância da fabrica de EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		// Obter uma instância do EntityManager
		EntityManager em = fabrica.createEntityManager();

		// Instancia um veiculo sem o codigo (Estado : novo não gerenciado)
		Veiculo veiculo = new Veiculo("FIAT", "PRETO", new GregorianCalendar(2021, Calendar.MAY, 5), Combustivel.FLEX,
				false);

		// Cadastrar o veiculo
		// Passar o objeto veicuylo para o entity manger gerenciar
		em.persist(veiculo);

		// Começar uma transação
		em.getTransaction().begin();

		// Finalizar a transação com commit
		em.getTransaction().commit();

		System.out.println("Veiculo registrado");

		// Fechar
		em.close();
		fabrica.close();

	}

}
