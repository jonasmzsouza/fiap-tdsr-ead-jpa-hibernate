package br.com.fiap.revisao.bean;

public class Funcionario {

	// Modificadores de acesso:
	// public - todos;>
	// private - somente a prorpia classe>
	// protected - classes filhas, classes no mesmo pacote>
	// default (package) - > classes no mesmo pacote

	// Tipos primitivos: boolean, byte, short, int, long, char, float, double (só
	// armazena valor)
	// Valor padrão: números = 0, boolean = ?

	// Tipos de referência: String, Integer, Double e classes criadas
	// (contém atributos e métodos)
	// Valor padrão: null

	// Atributos
	private int id;
	private String nome;
	private int anoNascimento;
	private Genero genero;
	

	// Construtores
	public Funcionario() {
	}

	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	// Métodos
	public void trabalhar() {
		System.out.println("Funcionário trabalhando...");
	}

	public void receberBonificacao() {
		System.out.println("Funcionário recebendo bonus");
	}

	// Sobrecarga - > mesmo método com parametros diferentes
	public void trabalhar(int horas) {
		System.out.println("Trabalhando " + horas);
	}

	public void trabalhar(int horas, boolean extra) {
		System.out.println("Trabalhando " + horas + " extras: " + extra);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
