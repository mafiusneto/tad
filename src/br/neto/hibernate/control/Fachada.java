package br.neto.hibernate.control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.neto.hibernate.beans.Produto;
import br.neto.hibernate.model.ProdutoDAO;

public class Fachada {
	public ProdutoDAO repProd;
	
	public Fachada(){
		repProd = new ProdutoDAO();
	}

	public void incluirProduto(String nome, String descricao, Double preco) {
		repProd.incluir(nome, descricao, preco);		
	}

	public boolean existeProduto(Long id) {
		return repProd.existeProduto(id);
	}

	public void alteraProduto(Long id, String nome, String descricao, Double preco) {
		if(repProd.existeProduto(id)){
			Produto p = repProd.buscaProduto(id);
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPreco(preco);
			
			repProd.alterar(p);
		}
	}
	
	public Boolean deletarProduto(Long id) {
		if(repProd.existeProduto(id)){
			Produto p = repProd.buscaProduto(id);
			repProd.delete(p);
			return true;
		}
		return false;
	}

	public void listarProdutos() {
		ArrayList<Produto> produtos = new ArrayList<Produto>(repProd.listarProdutos());
		System.out.println("teste - sive: "+Integer.toString(produtos.size()));
		for (Produto produto : produtos) {
			JOptionPane.showMessageDialog(null, produto.exibeDadosProduto());
		}
		/*
		for(int i = 0; i < produtos.size()){
			//JOptionPane.showMessageDialog(null, p.exibeDadosProduto());
			System.out.println(produtos.get(i).getNome());
		}*/		
	}
	
	public void mostraProduto(Long id){
		if(repProd.existeProduto(id)){
			//Produto p = repProd.buscaProduto(id);
			Produto p = repProd.buscaProduto2(id);
			if(p != null){
				JOptionPane.showMessageDialog(null, p.exibeDadosProduto());
			}
		}else{
			JOptionPane.showMessageDialog(null, "produto não encontrado");
		}
		
	}
	
	public void teste(){
		Produto p = repProd.buscaProduto2(new Long(2));
		if(p != null){
			JOptionPane.showMessageDialog(null, p.exibeDadosProduto());
		}else{
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		}
	}

	public void close() {
		repProd.close();
		
	}
	
	
}
