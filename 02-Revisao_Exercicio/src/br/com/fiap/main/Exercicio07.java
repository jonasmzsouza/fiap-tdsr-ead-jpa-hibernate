package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {

		// Criar uma lista de conta corrente
		List<ContaCorrente> listaCC = new ArrayList<ContaCorrente>();

		// Adicionar 3 contas na lista
		listaCC.add(new ContaCorrente(1, 111, Calendar.getInstance(), 130, TipoConta.COMUM));
		listaCC.add(new ContaCorrente(1, 222, Calendar.getInstance(), 210, TipoConta.PREMIUM));
		listaCC.add(new ContaCorrente(1, 333, Calendar.getInstance(), 180, TipoConta.ESPECIAL));

		// Exibir os saldos da conta
		for (ContaCorrente c : listaCC) {
			System.out.println(c.getSaldo());
		}

	}

}
