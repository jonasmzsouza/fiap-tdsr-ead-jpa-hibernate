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

}
