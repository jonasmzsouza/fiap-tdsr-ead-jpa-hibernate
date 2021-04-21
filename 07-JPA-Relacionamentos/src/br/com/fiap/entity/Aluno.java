package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(name = "aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name = "nr_rm")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int rm;

	@Column(name = "nm_aluno", length = 120, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero", length = 20, nullable = false)
	private Genero genero;

	// Mapeamento do relacionamento muitos-para-um
	@ManyToOne
	@JoinColumn(name = "cd_grupo", nullable = false)
	private GrupoChallenge grupo;

	public Aluno() {
	}

	public Aluno(String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

}
