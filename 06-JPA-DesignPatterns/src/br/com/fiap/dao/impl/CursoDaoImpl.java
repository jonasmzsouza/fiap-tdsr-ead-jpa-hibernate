package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Curso;
import br.com.fiap.dao.CursoDao;

public class CursoDaoImpl extends GenericDaoImpl<Curso, Integer> implements CursoDao {

	public CursoDaoImpl(EntityManager em) {
		super(em);
	}
}
