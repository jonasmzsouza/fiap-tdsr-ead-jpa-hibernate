package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Veiculo;

public class RemocaoTeste {

	public static void main(String[] args) {

		// Obter uma instância da fabrica de EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		// Obter uma instância do EntityManager
		EntityManager em = fabrica.createEntityManager();

		// Pesquisar um veiculo
		Veiculo veiculo = em.find(Veiculo.class, 1);

		// Remover um veículo
		em.remove(veiculo);

		// Commit
		em.getTransaction().begin();
		em.getTransaction().commit();

		// Fechar
		em.close();
		fabrica.close();

	}

}
