package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Aluno;
import br.com.fiap.dao.AlunoDao;

public class AlunoDaoImpl extends GenericDaoImpl<Aluno, Integer> implements AlunoDao {

	public AlunoDaoImpl(EntityManager em) {
		super(em);
	}

}
