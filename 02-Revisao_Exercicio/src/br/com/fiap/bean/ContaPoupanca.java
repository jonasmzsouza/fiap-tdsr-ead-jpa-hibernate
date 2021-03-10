package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;

	// Constante
	// final:
	// na classe -> não pode ser herdada
	// no método e no atributo -> não permite a sobreescrita
	// static: o elemento passa a ser da classe e não do objeto
	public static final float RENDIMENTO = 0.032f;

	public ContaPoupanca() {
	}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (valor + taxa > saldo) {
			throw new SaldoInsuficienteException(saldo);
		}
		saldo -= valor + taxa;
	}

}
