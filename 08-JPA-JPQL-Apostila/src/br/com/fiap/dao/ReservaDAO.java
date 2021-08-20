package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva, Integer> {

	// Pesquisar reserva por parte do nome do cliente
	List<Reserva> buscarClientePorNome(String nome);

	// Pesquisar reserva por precço do pacote entre 2 valores
	List<Reserva> buscarPorPrecoPacote(float preco1, float preco2);

}
