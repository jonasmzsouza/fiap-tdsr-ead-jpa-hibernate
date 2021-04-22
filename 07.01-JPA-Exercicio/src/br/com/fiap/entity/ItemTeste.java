package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_TESTE")
@SequenceGenerator(name = "itemTeste", sequenceName = "SQ_TB_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {

	@Id
	@Column(name = "cd_item_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemTeste")
	private int codigo;

	@Column(name = "ds_item_teste")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cd_caso_teste", nullable = false)
	private CasoTeste casoTeste;
	
	@ManyToMany(mappedBy = "itemTeste")
	private List<Usuario> usuarios;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
