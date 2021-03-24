package br.com.fiap.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_VEICULO")
@SequenceGenerator(sequenceName = "SEQ_TB_VEICULO", name = "veiculo", allocationSize = 1)
public class Veiculo {

	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
	private int codigo;

	@Column(name = "ds_marca", nullable = false, length = 60)
	private String marca;

	@Column(name = "ds_cor", length = 20)
	private String cor;

	@Temporal(TemporalType.DATE)
	@Column(name = "ds_venda")
	private Calendar dataVenda;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_combustivel", nullable = false, length = 40)
	private Combustivel tipoCombustivel;

	@CreationTimestamp // Atribuir a data de cadastro automaticamente
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ds_cadastro", updatable = false)
	private Calendar dataCadastro;

	@Column(name = "st_novo")
	private boolean statusNovo;

	public Veiculo() {
	}

	public Veiculo(String marca, String cor, Calendar dataVenda, Combustivel tipoCombustivel, boolean statusNovo) {
		super();
		this.marca = marca;
		this.cor = cor;
		this.dataVenda = dataVenda;
		this.tipoCombustivel = tipoCombustivel;
		this.statusNovo = statusNovo;
	}

	public Veiculo(int codigo, String marca, String cor, Calendar dataVenda, Combustivel tipoCombustivel,
			boolean statusNovo) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.cor = cor;
		this.dataVenda = dataVenda;
		this.tipoCombustivel = tipoCombustivel;
		this.statusNovo = statusNovo;
	}

	@PrePersist // Antes do persist
	public void antesCadastrar() {
		System.out.println("Antes de cadastrar...");
	}

	@PostPersist // Pós do persist
	public void posCadastrar() {
		System.out.println("Pós de cadastrar...");
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return "Código: " + codigo + "\nMarca: " + marca + "\nCor: " + cor + "\nCombustivel: " + tipoCombustivel
				+ "\nNovo: " + statusNovo + "\nData Venda: " + sdf.format(dataVenda.getTime()) + "\nData Cadastro: "
				+ sdf.format(dataCadastro.getTime());
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Combustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(Combustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isStatusNovo() {
		return statusNovo;
	}

	public void setStatusNovo(boolean statusNovo) {
		this.statusNovo = statusNovo;
	}

}
