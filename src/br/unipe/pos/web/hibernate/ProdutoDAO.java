package br.unipe.pos.web.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProdutoDAO {

	Configuration configuration = null;    
    SessionFactory factory = null;
    
    List<Produto> produtos = null;
    
    public ProdutoDAO (){
    	configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	factory = configuration.buildSessionFactory();    	
    }
    
	public void incluir(Produto p){
		//Produto p = new Produto();
		
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();		
		session.save(p);
		tx.commit();
		session.close();		
	}
	
	public void alterar(Produto p){
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();		
		session.update(p);
		tx.commit();
		session.close();
	}
	
	public void delete(Produto p){
		Session session = factory.openSession();	
		
		// carrega o produto do banco de dados
		//Produto produto = (Produto) session.load(Produto.class, 1);

		Transaction tx = session.beginTransaction();

		session.delete(p);
		tx.commit();
		session.close();
	}
	
	public List<Produto> listarProdutos(){
		Session session = factory.openSession();

		Query query = 
				session.createQuery("select p from Produto p ");
		
		List<Produto> listaRetorno = query.list();
		
		// select p from Produto p where p.outroNome =:produto		
		
		return listaRetorno;
	}

}
