package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, Integer> {

	// 2 - Pesquisar o cliente por parte do nome
	List<Cliente> buscarPorParteNome(String parteNome);

	// 4 - Pesquisar clientes por estado
	List<Cliente> buscarPorEstado(String estado);

	// 5 - Pesquisar clientes por qtd de dias de reserva
	List<Cliente> buscarPorDiasReserva(int dias);

	// 7 - Pesquisar por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);

	// 8 - Pesquisar clientes por estado
	List<Cliente> buscarPorEstados(List<String> estados);
	
	// 10 - Buscar por parte do nome, sem diferenciar as maiuscular e minúsculas, ordenando por nome
	List<Cliente> buscarPorParteNome2(String parteNome);
	
	// 11 - Contar cliente por estado específico
	long contarPorEstado(String estado);

}
