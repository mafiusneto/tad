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
package br.unipe.pos.web.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que define o comportamento para o objeto.
 * 
 * @author: Rodrigo
 * @date: 27 de mai de 2016
 * @Time: 01:27:39
 */
public class TestaConexao {

	public static void main(String[] args) {

		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("tad");
		EntityManager em = emFactory.createEntityManager();
		em.close();
		emFactory.close();
		System.out.println("Tudo Certo!");
		
	}

}


