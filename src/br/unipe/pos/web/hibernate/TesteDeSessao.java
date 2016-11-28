package br.unipe.pos.web.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesteDeSessao {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		session.close();
		
		System.out.println("Ok");
	}
}





