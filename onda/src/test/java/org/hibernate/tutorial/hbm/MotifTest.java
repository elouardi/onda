package org.hibernate.tutorial.hbm;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MotifTest extends TestCase {
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
		Motif m1 = new Motif();
		Rejet r1 = new Rejet();
		m1.setNom_Motif("Produire CCC à l'original des factures");
		m1.setRejet(r1);
		Motif m2 = new Motif();
		m2.setNom_Motif("La qualité des signataires n'est pas conforme à l'organisation actuelle de l'ONDA");
		m2.setRejet(r1);
		session.save(m1);
		session.save(m2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Motif> result = session.createQuery( "from Fournisseur" ).list();
        for (Motif motif : result) {
			System.out.println(motif.getNom_Motif());
			System.out.println(motif.getRejet());
			
		}
        session.getTransaction().commit();
        session.close();
	}
}
