package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GRUPO_CHALLENGE")
@SequenceGenerator(name = "grupo", sequenceName = "SQ_TB_GRUPO_CHALLENGE", allocationSize = 1)
public class GrupoChallenge {

	@Id
	@Column(name = "cd_grupo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo")
	private int codigo;

	@Column(name = "nm_grupo", length = 50, nullable = false)
	private String nome;

	// Mapear o relacionamento um-para-um bidirecional
	// mappedBy -> nome do atributo que mapeia a FK
	// mappedBy -> sempre utilizado no bidirecional
	@OneToOne(mappedBy = "grupo", cascade = CascadeType.ALL)
	private ProjetoChallenge projeto;

	// Mapear o relacionamento um-para-muitos bidirecional
	@OneToMany(mappedBy = "grupo")
	private List<Aluno> alunos;

	// Método auxiliar para adicionar um aluno no grupo, para garantir o
	// preenchimento da FK no banco
	// Utilizado para cadastrar em cascata (cadastrar o grupo e o grupo cadastra os
	// alunos)
	public void addAluno(Aluno aluno) {
		if (alunos == null) {
			alunos = new ArrayList<>();
		}
		// adicionar o aluno na lista de alunos do grupo
		alunos.add(aluno);
		// setar o grupo do aluno
		aluno.setGrupo(this);
	}

	public GrupoChallenge() {
	}

	public GrupoChallenge(String nome) {
		super();
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProjetoChallenge getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoChallenge projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
