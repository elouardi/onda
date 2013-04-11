package org.hibernate.tutorial.hbm;

import java.sql.Date;
import java.util.List;


import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class JournalTest extends TestCase {
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

	@SuppressWarnings("deprecation")
	public void testBasicUsage() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Journal j1 = new Journal();
		Facture f1= new Facture();
		j1.setDate_Fct(new Date(14,02,2013));
		j1.setLibelle("");
		j1.setFacture(f1);
		Journal j2 = new Journal();
		Facture f2 = new Facture();
		j1.setDate_Fct(new Date(14,03,2013));
		j1.setLibelle("statut modifiée");
		j2.setFacture(f2);
		session.save(j1);
		session.save(j2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Journal> result = session.createQuery( "from Journal" ).list();
        for (Journal journal : result) {
			System.out.println(journal.getDate_Fct());
			System.out.println(journal.getLibelle());
			System.out.println(journal.getFacture());
			
		}
        session.getTransaction().commit();
        session.close();
	}
}
