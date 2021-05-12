package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote, Integer> {

	// 3 - Buscar por um transporte (Objecto Transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);

	// Buscar pacote por preço menor, retornando somente a descrição e aqtd de dias
	// (Object[])
	List<Object[]> buscarPorPrecoMenor(float preco);

	// Buscar pacote por preço menor, retornando somente a descrição e aqtd de dias
	// (Pacote)
	List<Pacote> buscarPorPrecoMenor2(float preco);

	// Buscar pacotes por preço menor, retornando somente a descrição (List<String>)
	List<String> buscarPorPrecoMenor3(float preco);
	
	// 6 - Buscar pacotes por data de saída dentro de um intervalo
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
	// 12 - Somar preços por um transporte específico
	double somarPrecoPorTransporte(String transporte);

}
