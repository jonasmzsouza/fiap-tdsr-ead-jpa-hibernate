package br.com.fiap.exception;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
	}

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}

	public SaldoInsuficienteException(double saldo) {
		super("Saldo insuficiente, limite disponível: " + saldo);
	}

}
