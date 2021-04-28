package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SistemaDao;
import br.com.fiap.dao.impl.SistemaDaoImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {

		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Obter um SistemaDao
		SistemaDao sistemaDao = new SistemaDaoImpl(em);

		try {
			// Pesquisar um sistema pelo código
			Sistema sistema = sistemaDao.read(1);

			// Exibir o nome do sistema
			System.out.println("Sistema: " + sistema.getNome());

			// Exibir os nomes e descrições dos casos de teste
			for (CasoTeste caso : sistema.getCasosTeste()) {
				System.out.println("Caso de teste: " + caso.getNome() + " - " + caso.getDescricao());

				// Exibir a descrição dos itens de teste de cada caso
				System.out.println("Item de teste:");
				for (ItemTeste item : caso.getItensTeste()) {
					System.out.println(item.getDescricao());

					// Exibir os usuários responsáveis pelo teste dos itens
					System.out.println("Usuario:");
					for (Usuario usuario : item.getUsuarios()) {
						System.out.println(usuario.getNome());
					}
				}

			}

		} catch (EntityNotFoundException e) {
			System.out.println("Sistema não encontrado");
		}

		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
