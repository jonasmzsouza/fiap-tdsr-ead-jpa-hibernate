package br.com.fiap.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.dao.VeiculoDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.VeiculoNotFoundException;

public class VeiculoDaoImpl implements VeiculoDao {

	private EntityManager em;

	public VeiculoDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(Veiculo veiculo) {
		em.persist(veiculo);
	}

	@Override
	public Veiculo read(int codigo) throws VeiculoNotFoundException {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		if (veiculo == null) {
			throw new VeiculoNotFoundException();
		}
		return veiculo;
	}

	@Override
	public void update(Veiculo veiculo) {
		em.merge(veiculo);
	}

	@Override
	public void delete(int codigo) throws VeiculoNotFoundException {
		Veiculo veiculo = read(codigo);
		em.remove(veiculo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
}
