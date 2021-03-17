package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(sequenceName = "SEQ_TB_CLIENTE", name = "cliente", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;

	@Column(name = "nm_cliente", nullable = false, length = 100)
	private String nome;

	@Column(name = "ds_genero", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(name = "nr_cep", nullable = false, length = 10)
	private String cep;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	private Calendar dataNascimento;

	@Lob
	@Column(name = "fl_foto_cnh")
	private byte[] fotoCNH;

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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getFotoCNH() {
		return fotoCNH;
	}

	public void setFotoCNH(byte[] fotoCNH) {
		this.fotoCNH = fotoCNH;
	}

}
