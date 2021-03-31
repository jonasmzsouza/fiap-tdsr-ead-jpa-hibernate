package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Gerencia a única instância da EntityManagerFactory
public class EntityManagerFactorySingleton {

	// 1 - Atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;

	// 2- Método estático que retorna a única instância
	public static EntityManagerFactory getInstace() {
		// Valida se já existe uma instância da fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}

	// 3 - Construtor privado, nenhuma classe consegue instanciar
	private EntityManagerFactorySingleton() {
	}

}
