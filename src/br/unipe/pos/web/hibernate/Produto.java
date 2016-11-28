package br.unipe.pos.web.hibernate;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable, InterfaceProduto{
	
	
	@Id @GeneratedValue
	private Long id;	
	private String nome;
	private String descricao;
	private Double preco;
	
	@Column(name="complemento", nullable=true)
	private String outroNome;
	
	@Column(name="gramatura", length=45, nullable=true)
	private String outraColuna;
	
	/**
	 * @return the outraColuna
	 */
	public String getOutraColuna() {
		return outraColuna;
	}
	/**
	 * @param outraColuna the outraColuna to set
	 */
	public void setOutraColuna(String outraColuna) {
		this.outraColuna = outraColuna;
	}
	/**
	 * @return the outroNome
	 */
	public String getOutroNome() {
		return outroNome;
	}
	/**
	 * @param outroNome the outroNome to set
	 */
	public void setOutroNome(String outroNome) {
		this.outroNome = outroNome;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	/* (non-Javadoc)
	 * @see br.unipe.pos.web.hibernate.InterfaceProduto#exibeNome()
	 */
	@Override
	public String exibeNome() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
