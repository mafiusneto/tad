/**
 * Projeto das trilhas de treinamento de Java b�sico ou avan�ado 
 * com foco nas certifica��es java e em treinamentos corporativos. 
 * Fontes dispon�veis em https://github.com/rodrigofujioka
 * 
 * Professor: Rodrigo da Cruz Fujioka
 * Ano: 2016
 * http://www.rodrigofujioka.com
 * http://www.fujideia.com.br
 * http://lattes.cnpq.br/0843668802633139
 * 
 * Contato: rcf4@cin.ufpe.br 
 * 
 */
package br.unipe.pos.web.hibernate;

import java.util.List;

/**
 * Classe que define o comportamento para o objeto.
 * @author: Rodrigo
 * @date: 31 de mai de 2016
 * @Time: 21:08:26
 */
public class EstoqueProduto {
	
	
	public static void main(String[] args) {
		
		
		AdicaoDeProduto ad = new AdicaoDeProduto();

		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros 2");
		produto.setPreco(35.90);
		
		ad.adicionaProduto(produto);
	
		
		List<Produto> lista = ad.listarProdutos();
		
		System.out.println("ok");
		
		
	}

}




