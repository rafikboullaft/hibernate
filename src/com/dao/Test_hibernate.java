package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_hibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			System.out.println("creat client 1");
			Client client1=new Client(1,"boullaft3","rafik3",22,"taza");
			Client client2=new Client(2,"boullaft4","raf",30,"taza");
			session.beginTransaction();
			System.out.println("saving client 1...");
			session.save(client1);
			System.out.println("saving client 2...");
			session.save(client2);
			session.getTransaction().commit();
			System.out.println("done ..");
			System.out.println("change the name");
			Client cl=(Client) session.load(Client.class,1);
			session.beginTransaction();
			cl.setNom("blft");
			session.save(cl) ;
			System.out.println("name changed! done");
			/*
			 * System.out.println("delete ..."); Client cl2=(Client)
			 * session.load(Client.class,new Integer(4)); session.delete(cl2) ;
			 */
			System.out.println("deleted");
			session.getTransaction().commit();
		}
		finally {
			sf.close();
		}
	}

}
