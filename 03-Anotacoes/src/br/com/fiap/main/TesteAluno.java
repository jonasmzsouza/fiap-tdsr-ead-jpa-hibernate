package br.com.fiap.main;

import br.com.fiap.orm.Orm;
import br.com.fiap.tds.bean.Aluno;
import br.com.fiap.tds.bean.Pedido;

public class TesteAluno {

	public static void main(String[] args) {
		// Instaciar um aluno/Pedido
		Aluno aluno = new Aluno();
		Pedido pedido = new Pedido();

		// Instaciar um Orm
		Orm orm = new Orm();

		// Exibir o resultado do método gerarPesquisa passando o aluno
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(pedido));
	}

}
