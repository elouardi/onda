package org.hibernate.tutorial.hbm;

import java.sql.Date;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HistoriqueFactureTest extends TestCase {
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
		HistoriqueFacture h1 = new HistoriqueFacture();
		Facture f1 = new Facture();
		h1.setAction(Statut.ADispatcher);
		h1.setDateRecp(new Date(01,02,2013));
		h1.setEntite("Liquidation");
		h1.setDateEnvoi(new Date(05,02,2013));
		h1.setFacture(f1);
		HistoriqueFacture h2 = new HistoriqueFacture();
		Facture f2 = new Facture();
		h2.setAction(Statut.APayer);
		h2.setDateRecp(new Date(01,01,2013));
		h2.setEntite("Tresorerie");
		h2.setDateEnvoi(new Date(05,01,2013));
		h2.setFacture(f2);
		session.save(h1);
		session.save(h2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<HistoriqueFacture> result = session.createQuery( "from HistoriqueFacture" ).list();
        for (HistoriqueFacture historiqueFacture : result) {
			System.out.println(historiqueFacture.getAction());
			System.out.println(historiqueFacture.getDateRecp());
			System.out.println(historiqueFacture.getEntite());
			System.out.println(historiqueFacture.getDateEnvoi());
			System.out.println(historiqueFacture.getFacture());
		
		}
        session.getTransaction().commit();
        session.close();
	}
}
