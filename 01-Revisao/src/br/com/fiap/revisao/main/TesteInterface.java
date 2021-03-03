package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.dao.FuncionarioDao;
import br.com.fiap.revisao.dao.FuncionarioOracleDao;

// View (JSP) <-> Servlet (FuncionarioDao) <-> DAO <-> Banco de Dados
// Diminuir o aclopamento (dependência)

public class TesteInterface {

	public static void main(String[] args) {

		// Instanciar um objeto do tipo FuncionarioDao
		FuncionarioDao dao = new FuncionarioOracleDao();
		dao.cadastrar(new Funcionario());

	}

}
