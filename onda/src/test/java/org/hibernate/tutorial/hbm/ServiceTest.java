package org.hibernate.tutorial.hbm;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServiceTest extends TestCase {
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
	}

	@Override
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	public void testBasicUsage() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Service s1 = new Service();
		Facture f1= new Facture();
		User u1 = new User();
	    User u2 = new User();
	    Collection<User> col1 = new HashSet<User>();
	    col1.add(u1);
	    col1.add(u2); 
		s1.setLibelle("Liquidation");
		s1.setFacture(f1);
		s1.setUsers(col1);
		Service s2 = new Service();
		Facture f2= new Facture();
		User u3 = new User();
	    User u4 = new User();
	    Collection<User> col2 = new HashSet<User>();
	    col2.add(u3);
	    col2.add(u4); 
		s2.setLibelle("Comptabilité");
		s2.setFacture(f2);
		s2.setUsers(col2);
		session.save(s1);
		session.save(s2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Service> result = session.createQuery( "from Service" ).list();
        for (Service service : result) {
			System.out.println(service.getLibelle());
			System.out.println(service.getFacture());
			System.out.println(service.getUsers());
		}
        session.getTransaction().commit();
        session.close();
	}
}
