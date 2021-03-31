package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface GenericDao<E, K> {

	void create(E entidade);

	E read(K id) throws EntityNotFoundException;

	void update(E entidade);

	void delete(K id) throws EntityNotFoundException;

	void commit() throws CommitException;

}
