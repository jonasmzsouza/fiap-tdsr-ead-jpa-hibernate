package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Combustivel;
import br.com.fiap.bean.Veiculo;

public class AtualizacaoTeste {

	public static void main(String[] args) {

		// Obter uma instância da fabrica de EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		// Obter uma instância do EntityManager
		EntityManager em = fabrica.createEntityManager();

		// Instaciar um objeto veiculo com um codigo (Estado : detached)
		Veiculo veiculo = new Veiculo(1, "HYUNDAI", "PRATA", new GregorianCalendar(2021, Calendar.JUNE, 23),
				Combustivel.ELETRICO, true);

		// Atualizar
		// Merge retorna o objeto gerenciado pelo Entity Manager (cópia)
		Veiculo veiculoGerenciado = em.merge(veiculo);
		// em.merge(veiculo);

		// veiculoGerenciado.setNovo(false);

		em.getTransaction().begin();
		em.getTransaction().commit();

		// Fechar
		em.close();
		fabrica.close();
	}

}
