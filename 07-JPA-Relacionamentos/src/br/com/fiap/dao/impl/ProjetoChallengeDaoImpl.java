package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.entity.ProjetoChallenge;

public class ProjetoChallengeDaoImpl extends GenericDaoImpl<ProjetoChallenge, Integer> implements ProjetoChallengeDao{

	public ProjetoChallengeDaoImpl(EntityManager em) {
		super(em);
	}

}
