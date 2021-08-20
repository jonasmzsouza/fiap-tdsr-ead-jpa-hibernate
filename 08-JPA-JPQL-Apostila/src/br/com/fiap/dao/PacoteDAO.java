package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote, Integer> {

	// 3 - Buscar por um transporte (Objecto Transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);

	// Buscar pacote por pre�o menor, retornando somente a descri��o e aqtd de dias
	// (Object[])
	List<Object[]> buscarPorPrecoMenor(float preco);

	// Buscar pacote por pre�o menor, retornando somente a descri��o e aqtd de dias
	// (Pacote)
	List<Pacote> buscarPorPrecoMenor2(float preco);

	// Buscar pacotes por pre�o menor, retornando somente a descri��o (List<String>)
	List<String> buscarPorPrecoMenor3(float preco);
	
	// 6 - Buscar pacotes por data de sa�da dentro de um intervalo
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
	// 12 - Somar pre�os por um transporte espec�fico
	double somarPrecoPorTransporte(String transporte);
	
	// Utilizando query nativa do banco
	// Buscar por qtde de dias maior e pre�o menor
	List<Pacote> buscarPorQtdDiasMaiorEPrecoMenor(int qtd, float preco);

}
