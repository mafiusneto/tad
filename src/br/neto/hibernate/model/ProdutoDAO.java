package br.neto.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.neto.hibernate.beans.Produto;

public class ProdutoDAO {

	Configuration configuration = null;    
    SessionFactory factory = null;
    
    ArrayList<Produto> produtos = null;
    
    public ProdutoDAO (){
    	configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	factory = configuration.buildSessionFactory();
    	
    	//this.produtos = new ArrayList<Produto>(listarProdutos());
    }
    
    /**
     * 
     * @param p
     */
	public void incluir(String nome, String descricao, Double preco){
		Produto p = new Produto(nome, descricao, preco);
		
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();		
		session.save(p);
		tx.commit();
		session.close();		
		//tx.close();
	}
	public void incluir(Produto p){		
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
		session.close();
		// select p from Produto p where p.outroNome =:produto
		return listaRetorno;
	}
	
	public List<Produto> buscarProdutosPorId(Long id){
		Session session = factory.openSession();

		Query query = 
				session.createQuery("select p from Produto p where p.id =:id");
		query.setLong("id", id);
		
		List<Produto> listaRetorno = query.list();
		session.close();
		
		// select p from Produto p where p.outroNome =:produto		
		return listaRetorno;
	}
	
	public Produto buscaProduto2(Long id){		
		Session session = factory.openSession();
		
		Produto produto = (Produto) session.get(Produto.class, id);
		session.close();
		
		return produto;
	}
	
	public Boolean existeProduto(Long id){
		produtos = new ArrayList<Produto>(buscarProdutosPorId(id));
		for(Produto p: produtos){
			if (p.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	public Produto buscaProduto(Long id){
		produtos = new ArrayList<Produto>(buscarProdutosPorId(id));//listarProdutos());
		if(existeProduto(id)){
			for(Produto p: produtos){
				if (p.getId() == id){
					return p;
				}
			}
		}
		return null;
	}

	public void close() {
    	factory.close();
    	System.out.println("close factory");
	}

}
