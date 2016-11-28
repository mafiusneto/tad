package br.unipe.pos.web.hibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdicaoDeProduto {
	
	
	
public static void main(String args[]){			
		
		Produto p = new Produto();
		p.setNome("Corona");
		p.setDescricao("Cerveja boa");
		p.setOutroNome("hummmmmm");
		p.setPreco(5.0);
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();		
		session.save(p);
		
		tx.commit();		
		session.close();
		
	}
	
	
	
	public void adicionaProduto(Produto produto){			
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();		
		session.save(produto);		
		tx.commit();		
		session.close();
		
	}
	
	
	public List<Produto> listarProdutos(){
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Query query = 
				session.createQuery("select p from Produto p ");
		
		List<Produto> listaRetorno = query.list();
		
		// select p from Produto p where p.outroNome =:produto		
		
		return listaRetorno;
	}
	
	
	
	
}