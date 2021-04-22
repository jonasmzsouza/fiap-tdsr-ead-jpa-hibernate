package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SISTEMA")
@SequenceGenerator(name = "sistema", sequenceName = "SQ_TB_SISTEMA", allocationSize = 1)
public class Sistema {

	@Id
	@Column(name = "cd_sistema")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sistema")
	private int codigo;

	@Column(name = "nm_sistema")
	private String nome;

	@OneToMany(mappedBy = "sistema", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<CasoTeste> casoTeste;

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

}
