package com.farmarcia.farmacia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@ManyToOne
	@JoinColumn(name = "categoriaProduto_idCategoria", nullable = false)
	@JsonIgnoreProperties("categoriaProduto")
	private CategoriaModel categoriaProduto;
	
	@NotBlank
	private String nomeProduto;
	
	private String descricaoProduto;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}


	public CategoriaModel getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaModel categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	
}
