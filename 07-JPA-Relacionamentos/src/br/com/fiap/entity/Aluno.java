package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	// Mapeamento do relacionamento muitos-para-muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
	// @JoinTable - > configura a tabela associativa
	// name -> nome da tabela associativa
	// joinsColumns -> configura a coluna que armazena a PF/FK da classe atual
	// (Aluno)
	// inverseJoinColumns -> configura a coluna que armazena a PK/FK do outro lado
	// da relação
	@JoinTable(name = "TB_ALUNO_NANO_COURSE", joinColumns = @JoinColumn(name = "nr_rm"), inverseJoinColumns = @JoinColumn(name = "cd_nano_course"))
	private List<NanoCourse> nanoCourses;

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

	public List<NanoCourse> getNanoCourses() {
		return nanoCourses;
	}

	public void setNanoCourses(List<NanoCourse> nanoCourses) {
		this.nanoCourses = nanoCourses;
	}

}
