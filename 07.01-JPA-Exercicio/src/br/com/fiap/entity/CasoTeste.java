package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CASO_TESTE")
@SequenceGenerator(name = "casoTeste", sequenceName = "SQ_TB_CASO_TESTE", allocationSize = 1)
public class CasoTeste {

	@Id
	@Column(name = "cd_caso_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casoTeste")
	private int codigo;

	@Column(name = "nm_caso_teste")
	private String nome;

	@Column(name = "ds_caso_teste")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cd_sistema", nullable = false)
	private Sistema sistema;
	
	@OneToMany(mappedBy = "casoTeste", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTeste> itemTeste;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
