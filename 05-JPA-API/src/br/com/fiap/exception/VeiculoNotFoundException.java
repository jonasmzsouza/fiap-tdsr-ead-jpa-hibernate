package br.com.fiap.exception;

public class VeiculoNotFoundException extends Exception {

	public VeiculoNotFoundException() {
		super("Veículo não encontrado");
	}

	public VeiculoNotFoundException(String msg) {
		super(msg);
	}

}
