package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {

	public static void main(String[] args) {

		// Instanciar uma conta corrente
		ContaCorrente cc = new ContaCorrente(2, 1234, Calendar.getInstance(), 150, TipoConta.COMUM);

		// Instanciar uma conta poupança
		ContaPoupanca cp = new ContaPoupanca(2, 4321, new GregorianCalendar(2021, Calendar.JUNE, 5), 250, 1);

		// Chamar o método retirar
		try {
			cc.retirar(180);
			System.out.println("Saque efetuado");
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}

	}

}
