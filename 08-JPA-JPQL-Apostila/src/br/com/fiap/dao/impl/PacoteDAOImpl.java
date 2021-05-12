package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote, Integer> implements PacoteDAO {

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte = :trans", Pacote.class);
		query.setParameter("trans", transporte);
		return query.getResultList();
	}

	@Override
	public List<Object[]> buscarPorPrecoMenor(float preco) {
		return em.createQuery("select p.descricao, p.qtdDias from Pacote p where p.preco < :p", Object[].class)
				.setParameter("p", preco).getResultList();
	}

	@Override
	public List<Pacote> buscarPorPrecoMenor2(float preco) {
		return em
				.createQuery("select new Pacote(p.descricao, p.qtdDias) from Pacote p where p.preco < :p", Pacote.class)
				.setParameter("p", preco).getResultList();
	}

	@Override
	public List<String> buscarPorPrecoMenor3(float preco) {
		return em.createQuery("select p.descricao from Pacote p where p.preco < :p", String.class)
				.setParameter("p", preco).getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :dtInicio and :dtFim", Pacote.class)
				.setParameter("dtInicio", inicio).setParameter("dtFim", fim).getResultList();
	}

	@Override
	public double somarPrecoPorTransporte(String transporte) {
		TypedQuery<Double> query = em.createQuery("select sum(p.preco) from Pacote p where lower(p.transporte.empresa) = lower(:trans)", Double.class);
		query.setParameter("trans", transporte);
		Double soma = query.getSingleResult(); 
		return soma;
	}

}