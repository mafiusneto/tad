package br.unipe.pos.web.hibernate;

public class main {

	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setDescricao("Teste001");
		p.setNome("Produto teste 001");
		p.setOutraColuna("test");
		p.setOutroNome("pdt");
		p.setPreco(1.99);
		
		ProdutoDAO repProduto = new ProdutoDAO();
		repProduto.incluir(p);
		
	}

}
