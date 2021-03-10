package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//CTRL + 1 ->Solução rápida (a classe filha é obrigada a declarar os métodos)
public class ContaCorrente extends Conta {

	private TipoConta tipoConta;

	// CTRL + D ->apaga a linha

	public ContaCorrente() {
	}

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipoConta) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipoConta = tipoConta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (this.tipoConta == TipoConta.COMUM && saldo - valor < 0) {
			throw new SaldoInsuficienteException(saldo);
		}
		saldo -= valor;
	}

}
