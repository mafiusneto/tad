package br.neto.hibernate.beans;


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
	
	public Produto(){
		
	}
	
	public Produto (String nome, String descricao, Double preco){
		setNome(nome);
		setDescricao(descricao);
		setPreco(preco);
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
		return getNome();
	}
	@Override
	public String exibeDadosProduto() {
		return id+" - "+nome+" - R$" + preco +"\n"+descricao;
	}

	
	
}
