package br.com.fiap.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SistemaDao;
import br.com.fiap.dao.impl.SistemaDaoImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	// Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {

		// Instanciar um sistema com o nome
		Sistema sistema = new Sistema("Sistema Virtual");

		// Instaciar 2 casos de teste com o nome e descrição
		CasoTeste caso1 = new CasoTeste("Caso 1", "Caso de teste 1");
		CasoTeste caso2 = new CasoTeste("Caso 2", "Caso de teste 2");

		// Adicionar os casos de teste no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);

		// Instanciar 3 itens de teste com a descrição
		ItemTeste item1 = new ItemTeste("Item 1");
		ItemTeste item2 = new ItemTeste("Item 2");
		ItemTeste item3 = new ItemTeste("Item 3");

		// Adicionar 2 itens no primeiro caso e 1 item no segundo
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		caso2.addItemTeste(item3);

		// Instanciar 2 usuarios
		Usuario usuario1 = new Usuario("Jonas");
		Usuario usuario2 = new Usuario("Leticia");

		// Criar uma lista de usuários e adicioná-los na lista
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);

		// Setar a lista de usuário em 2 itens de teste
		item1.setUsuarios(usuarios);
		item3.setUsuarios(usuarios);

		// Instanciar um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		// Instanciar um SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);

		// Cadastro do sistema
		try {
			// Cadastrar o sistema
			dao.create(sistema);
			// Commit
			dao.commit();
			System.out.println("Tudo certo!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstace().close();

	}

}
