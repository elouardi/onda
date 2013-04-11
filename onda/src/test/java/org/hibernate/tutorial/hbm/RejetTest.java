package org.hibernate.tutorial.hbm;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class RejetTest extends TestCase {
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
		Rejet r = new Rejet();
        Motif mf1 = new Motif();
        Motif mf2 = new Motif();
        Collection<Motif> col = new HashSet<Motif>();
        col.add(mf1);
        col.add(mf2);
        OrdrePaiement op = new OrdrePaiement();
		r.setDate_Rejet(new Date(01,10,2012));
		r.setDir_Con(DirectionConcernee.AeroAgadir);
		r.setMotifs(col);
		r.setOrdrePaiement(op);
		session.save(r);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Rejet> result = session.createQuery( "from Rejet" ).list();
        for (Rejet rejet : result) {
			System.out.println(rejet.getDate_Rejet());
			System.out.println(rejet.getDir_Con());
			System.out.println(rejet.getDate_Rejet());
			System.out.println(rejet.getMotifs());
			System.out.println(rejet.getOrdrePaiement());
			
		}
        session.getTransaction().commit();
        session.close();
	}
}
