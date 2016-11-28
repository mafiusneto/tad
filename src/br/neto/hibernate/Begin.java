package br.neto.hibernate;

import javax.swing.JOptionPane;

import br.neto.hibernate.beans.Produto;
import br.neto.hibernate.control.Fachada;
import br.neto.hibernate.model.ProdutoDAO;

public class Begin {
	
	public static void main(String[] args) {
		/*
		Produto p = new Produto();
		p.setNome("Produto teste 001");
		p.setDescricao("Teste001");
		p.setPreco(1.99);
		//p.setOutraColuna("test");
		//p.setOutroNome("pdt");
		
		ProdutoDAO repProduto = new ProdutoDAO();
		//repProduto.incluir(p);
		 */
		System.out.println("Iniciando #########################");
		Fachada fachada = new Fachada();
		
		int opc = 0;
		
		while (opc != 10){
			try {
				try {
					opc = Integer.parseInt(JOptionPane.showInputDialog("Op��es Menu"+
							"\n\t1-Add Produto"+
							"\n\t2-Alterar Produto"+
							"\n\t3-Remover Produto"+
							"\n\t4-Listar Produto"+
							"\n\t5-Buscar Produto"+
							"\n\t6-Teste"+
							"\n\t10-Sair"
					));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Op��o invalida!");
				}
				
				Long id;
				String nome, descricao;
				Double preco;
				
				switch (opc) {
				case 1: //incluir 
					JOptionPane.showMessageDialog(null, "Incluir um produto! (informe o Nome, Descri��o e Pre�o)");
					nome = 		JOptionPane.showInputDialog("Informe o nome do produto");
					descricao =	JOptionPane.showInputDialog("Informe a descri��o do produto");
					preco = 0d;
					while (! (preco > 0)){
						try {
							preco = 	Double.parseDouble(JOptionPane.showInputDialog("Informe o pre�o. ex.: 1.99"));							
						} catch (Exception e) {
							// TODO: handle exception
						}						
					}
					
					fachada.incluirProduto(nome, descricao, preco);
					break;
				case 2: //alterar
					JOptionPane.showMessageDialog(null, "Alterar um produto! (informe o Id do produto que deseja alterar.)");
					id = 0l;
					while(!(id>0l)){
						try {
							id = 	 Long.parseLong(JOptionPane.showInputDialog("Informe o Id do Produto!"));
							if (! fachada.existeProduto(id)) {
								JOptionPane.showMessageDialog(null, "Produto n�o encontrado!");
								break;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Id inv�lido!");
							//break;
							e.printStackTrace();
						}
						System.out.println("id:"+id);
					}
					
					nome = 		JOptionPane.showInputDialog("Alterar nome para:");
					descricao =	JOptionPane.showInputDialog("Alterar descri��o para:");
					preco = 0d;
					while (! (preco > 0)){
						try {
							preco = 	Double.parseDouble(JOptionPane.showInputDialog("Alterar pre�o para: (ex. 1.99)"));							
						} catch (Exception e) {
							// TODO: handle exception
						}						
					}
					fachada.alteraProduto(id, nome, descricao, preco);
					break;
				case 3: //remover
					JOptionPane.showMessageDialog(null, "Deletar um produto! (informe o Id do produto que deseja deletar.)");
					id = 0l;
					while(!(id>0l)){
						try {
							id = 	 Long.parseLong(JOptionPane.showInputDialog("Informe o Id do Produto!"));
							if (! fachada.existeProduto(id)) {
								JOptionPane.showMessageDialog(null, "Produto n�o encontrado!");
								break;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Id inv�lido!");
							//break;
							e.printStackTrace();
						}
						//System.out.println("id:"+id);
					}
					try {
						if(fachada.deletarProduto(id)){
							JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
						}else{
							JOptionPane.showMessageDialog(null, "Falha ao deletar produto!");							
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Falha ao deletar produto!");
					}
					
					/*Produto p = new Produto("Ma�a", "fruta maca", 5.0);
					
					ProdutoDAO repProduto = new ProdutoDAO();
					repProduto.incluir(p);*/
					break;
				case 4: //listar
					fachada.listarProdutos();
					break;
				case 5: //buscar
					JOptionPane.showMessageDialog(null, "Busca de produto!");
					id = 0l;
					while(!(id>0l)){
						try {
							id = 	 Long.parseLong(JOptionPane.showInputDialog("Informe o Id do Produto!"));
							if (! fachada.existeProduto(id)) {
								JOptionPane.showMessageDialog(null, "Produto n�o encontrado!");
								break;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Id inv�lido!");
							//break;
							e.printStackTrace();
						}
						//System.out.println("id:"+id);
					}
					fachada.mostraProduto(id);
					//fachada.teste();
					break;
				case 6:
					fachada.teste();
					break;
				case 10:
					JOptionPane.showMessageDialog(null, "Adios muchacho!");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Op��o invalida!");
					break;
				}
				
			} catch (Exception e) {
				System.out.println("erroooo");
				e.printStackTrace();
			}
		}
		fachada.close();
		System.out.println("-- fim --");
		
	}

}
