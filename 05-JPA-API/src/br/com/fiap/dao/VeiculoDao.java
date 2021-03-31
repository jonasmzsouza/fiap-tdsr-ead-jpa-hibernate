package br.com.fiap.dao;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.VeiculoNotFoundException;

// View - Controller (VeiculoDAO) - DAO - Banco

public interface VeiculoDao {

	void add(Veiculo veiculo);

	Veiculo read(int codigo) throws VeiculoNotFoundException;

	void update(Veiculo veiculo);

	void delete(int codigo) throws VeiculoNotFoundException;

	void commit() throws CommitException;

}
