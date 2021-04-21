package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_DISCIPLINA")
@SequenceGenerator(sequenceName = "SQ_TB_DISCIPLINA", name = "disciplina", allocationSize = 1)
public class Disciplina {

	@Id
	@Column(name = "cd_disciplina")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina")
	private int codigo;

	@Column(name = "nm_disciplina", length = 50, nullable = false)
	private String nome;

	@Column(name = "ds_ementa", length = 255)
	private String ementa;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadstro", updatable = false)
	private Calendar dataCadastro;

	@Column(name = "nr_horas")
	private Integer horas;

	public Disciplina() {
	}

	public Disciplina(String nome, String ementa, Integer horas) {
		this.nome = nome;
		this.ementa = ementa;
		this.horas = horas;
	}

	public Disciplina(int codigo, String nome, String ementa, Integer horas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ementa = ementa;
		this.horas = horas;
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

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
